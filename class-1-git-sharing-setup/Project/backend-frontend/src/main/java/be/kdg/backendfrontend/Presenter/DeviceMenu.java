package be.kdg.backendfrontend.Presenter;

import be.kdg.backendfrontend.Domain.ArduinoDevice;
import be.kdg.backendfrontend.Domain.Data;
import be.kdg.backendfrontend.Domain.DeviceType;
import be.kdg.backendfrontend.Domain.SocketConnectionServer;
import be.kdg.backendfrontend.Repository.JdbcDataRepository;
import be.kdg.backendfrontend.Repository.JdbcDeviceRepository;
import be.kdg.backendfrontend.Repository.JdbcTemplateDataRepository;
import be.kdg.backendfrontend.Service.DataService;
import be.kdg.backendfrontend.Service.DeviceService;
import com.fazecast.jSerialComm.SerialPort;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static be.kdg.backendfrontend.Repository.JdbcTemplateDataRepository.parseData;

@Component
public class DeviceMenu {
    private DeviceService jdbcDeviceRepository;
    private DataService jdbcDataRepository;
    private Scanner scanner = new Scanner(System.in);

    public DeviceMenu(DeviceService jdbcDeviceRepository, DataService jdbcDataRepository) {
        this.jdbcDeviceRepository = jdbcDeviceRepository;
        this.jdbcDataRepository = jdbcDataRepository;
    }

    public void showDeviceMenu() throws IOException {
        while (true) {
            System.out.println("""
                    1. Show all devices
                    2. Create a device
                    3. Show device by ID
                    4. Update a device
                    5. Show all data
                    6. Create data
                    7. Show data by ID
                    8. Exit
                    9. Import data from string
                    10. listen for data
                    """);
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> showAllDevices();
                case 2 -> createDevice();
                case 3 -> showDeviceById();
                case 4 -> updateDevice();
                case 5 -> showAllData();
                case 6 -> createData();
                case 7 -> showDataById();
                case 8 -> System.exit(0);
                case 9 -> importDataFromString();
                case 10 -> listenForData();
            }
        }
    }

    private void showAllDevices() {
        try {
            jdbcDeviceRepository.findAllDevice().forEach(System.out::println);
        } catch (RuntimeException dbe) {
            System.out.println("Unable to find all devices");
            System.out.println(dbe.getMessage());
        }
    }

    private void createDevice() {
        System.out.println("Enter the device type (MOB_VICTIM or AUTONOMOUS_CRAFT)");
        DeviceType deviceType = DeviceType.valueOf(scanner.nextLine());
        ArduinoDevice arduinoDevice = new ArduinoDevice(deviceType);
        try {
            jdbcDeviceRepository.createDevice(arduinoDevice);
            System.out.println("Device created");
        } catch (RuntimeException dbe) {
            System.out.println("Unable to create device");
            System.out.println(dbe.getMessage());
        }
    }

    private ArduinoDevice createDeviceWithReturn(DeviceType deviceType) {
        ArduinoDevice arduinoDevice = new ArduinoDevice(deviceType);
        try {
            jdbcDeviceRepository.createDevice(arduinoDevice);
            System.out.println("Device created");
        } catch (RuntimeException dbe) {
            System.out.println("Unable to create device");
            System.out.println(dbe.getMessage());
        }
        return arduinoDevice;
    }

    private void showDeviceById() {
        System.out.println("Enter the device ID");
        int deviceID = scanner.nextInt();
        scanner.nextLine();
        try {
            System.out.println(jdbcDeviceRepository.findDeviceById(deviceID));
        } catch (RuntimeException dbe) {
            System.out.println("Unable to find device");
            System.out.println(dbe.getMessage());
        }
    }

    private void updateDevice() {
        System.out.println("Enter the device ID");
        int deviceID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the device type (MOB_VICTIM or AUTONOMOUS_CRAFT)");
        DeviceType deviceType = DeviceType.valueOf(scanner.nextLine());
        ArduinoDevice arduinoDevice = new ArduinoDevice(deviceID, deviceType);
        try {
            jdbcDeviceRepository.updateDevice(arduinoDevice);
            System.out.println("Device updated");
        } catch (RuntimeException dbe) {
            System.out.println("Unable to update device");
            System.out.println(dbe.getMessage());
        }
    }

    private void showAllData() {
        try {
            jdbcDataRepository.findAllData().forEach(System.out::println);
        } catch (RuntimeException dbe) {
            System.out.println("Unable to find all data");
            System.out.println(dbe.getMessage());
        }
    }

    private void createData() {

        SerialPort[] ports = SerialPort.getCommPorts();
        System.out.println("Select a port:");
        int i = 1;
        for (SerialPort port : ports) {
            System.out.println(i++ + ". " + port.getSystemPortName());
        }
        Scanner s = new Scanner(System.in);
        int chosenPort = s.nextInt();

        SerialPort serialPort = ports[chosenPort - 1];
        if (serialPort.openPort()) {
            System.out.println("Port opened successfully.");
        } else {
            System.out.println("Unable to open the port.");
            return;
        }
        serialPort.setComPortParameters(115200, 8, 1, SerialPort.NO_PARITY);
        serialPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
        Scanner data = new Scanner(serialPort.getInputStream());
        ArduinoDevice device = createDeviceWithReturn(DeviceType.AUTONOMOUS_CRAFT);
        System.out.println("Do you want to use dummy data? (y/n)");
        String dummyData = scanner.nextLine();
        if (dummyData.equals("y")) {
            System.out.println("Enter the starting latitude in this format (ddd.mmmm): ");
            String startingLatitude = scanner.nextLine();
            System.out.println("Enter the starting longitude in this format (ddd.mmmm): ");
            String startingLongitude = scanner.nextLine();
            System.out.println("Enter the heading angle");
            String headingAngle = scanner.nextLine();
            while (true) {
                // Generate the dummy data
                System.out.println(jdbcDataRepository.generateGpsString(startingLongitude,
                        startingLatitude, headingAngle));
                importDataFromArduino(jdbcDataRepository.generateGpsString(startingLongitude,
                        startingLatitude, headingAngle), device.getDeviceID());
                System.out.println("=====================================");

                // Calculate the new latitude and longitude using the angle given
                BigDecimal angle = BigDecimal.valueOf(Double.parseDouble(headingAngle));
                BigDecimal sinAngle = new BigDecimal(Math.sin(Math.toRadians(angle.doubleValue())));
                BigDecimal latitudeIncrement = BigDecimal.valueOf(0.0001);
                BigDecimal startingLat = new BigDecimal(startingLatitude);
                BigDecimal newLatitude = startingLat.add(latitudeIncrement.multiply(sinAngle))
                        .setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();

                BigDecimal cosAngle = new BigDecimal(Math.cos(Math.toRadians(angle.doubleValue())));
                BigDecimal longitudeIncrement = BigDecimal.valueOf(0.0001);
                BigDecimal startingLon = new BigDecimal(startingLongitude);
                BigDecimal newLongitude = startingLon.add(longitudeIncrement.multiply(cosAngle))
                        .setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();


                // Continue the loop or break
                System.out.println("Do you want to continue? (y/n)");
                String continueLoop = scanner.nextLine();
                if (continueLoop.equals("y")) {
                    startingLatitude = String.valueOf(newLatitude);
                    startingLongitude = String.valueOf(newLongitude);
                } else {
                    break;
                }
            }
        } else if (dummyData.equals("n")) {
            while (true) {
                String line = data.nextLine();
                System.out.println(line);

                // Split the line into fields
                String[] fields = line.split(",");

                // if there are more than 10 fields, and the first field is $GPRMC
                // This is here to handle broken strings that the arduino might send
                if (fields.length > 10 && fields[0].equals("$GPRMC")) {
                    importDataFromArduino(line, device.getDeviceID());
                }

                // Continue the loop or break
                System.out.println("Do you want to continue? (y/n)");
                String continueLoop = scanner.nextLine();
                if (continueLoop.equals("n")) {
                    break;
                }
            }
//        data.close();
        } else {
            System.out.println("Invalid input");
        }
    }

    private void showDataById() {
        System.out.println("Enter the data ID");
        int dataID = scanner.nextInt();
        scanner.nextLine();
        try {
            System.out.println(jdbcDataRepository.findDataById(dataID));
        } catch (RuntimeException dbe) {
            System.out.println("Unable to find data");
            System.out.println(dbe.getMessage());
        }
    }

    public static ArrayList<String> splitString(String input) {
        // Split the string using commas as delimiters
        String[] parts = input.split(",");

        // Convert the array to an ArrayList
        ArrayList<String> resultList = new ArrayList<>(Arrays.asList(parts));

        return resultList;
    }

    private void importDataFromString() {
        System.out.println("Enter the data");
        String input = scanner.nextLine();
        System.out.println("Enter the device ID");
        int deviceID = scanner.nextInt();
        Data data = parseData(input, deviceID);
        try {
            jdbcDataRepository.createData(data);
            System.out.println("Data created");
        } catch (RuntimeException dbe) {
            System.out.println("Unable to create data");
            System.out.println(dbe.getMessage());
        }
        System.out.println(data);
    }

    private void importDataFromArduino(String input, int deviceID) {
        Data data = parseData(input, deviceID);
        try {
            jdbcDataRepository.createData(data);
            System.out.println("Data created");
        } catch (RuntimeException dbe) {
            System.out.println("Unable to create data");
            System.out.println(dbe.getMessage());
        }
        System.out.println(data);
        System.out.println("=====================================");
        System.out.println("Longitude: " + jdbcDataRepository.returningLongitude(data));
        System.out.println("Latitude: " + jdbcDataRepository.returningLatitude(data));
        System.out.println("=====================================");
    }

    public void listenForData() throws IOException {
        SocketConnectionServer socketConnectionServer = new SocketConnectionServer();
        socketConnectionServer.start(5100);
        System.out.println("listening");
    }

}
