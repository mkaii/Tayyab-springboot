package be.kdg.integration3.arduinotoserver.Domain;

import be.kdg.integration3.arduinotoserver.Domain.Data;
import com.fazecast.jSerialComm.SerialPort;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;

@Component
public class SerialConnection {

    private PrintWriter out ;
    private BufferedReader in;
    ClientConnection clientConnection = new ClientConnection(out, in);


    private Data Data;

    public void serialConnectionStart() throws IOException {
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
        while (data.hasNextLine()) {
            if (data.nextLine() == null) {
                System.out.println("No data received");
            } else {
                String parsedData = parseData(data.nextLine()).toString();

                System.out.println("serial data: " + data.nextLine());
                System.out.println("parsed data: " + parsedData);
                clientConnection.sendMessage("first data", "localhost", 5100);
                clientConnection.sendMessage(parsedData, "localhost", 5100);
            }
        }
        data.close();
    }

    public static Data parseData(String input) {
        // Split the input string by commas
        String[] fields = input.split(",");

        // Extract individual values
        LocalDate date = LocalDate.now();
        String status = fields[2];
        Double latitude = parseDouble(fields[3]);
        String latitudeDirection = parseString(fields[4]);
        Double longitude = parseDouble(fields[5]);
        String longitudeDirection = parseString(fields[6]);
        Double heading = parseDouble(fields[7]);
        Double magneticDeviation = parseDouble(fields[9]);
        String deviationDirection = parseString(fields[10]);

        // Create and return a Data object
        return new Data(date, status, latitude, latitudeDirection, longitude,
                longitudeDirection, heading, magneticDeviation, deviationDirection);
    }

    private static Double parseDouble(String value) {
        // Check if the value is empty or null before parsing
        if (value == null || value.isEmpty()) {
            double defaultValue = 0.0;
            return defaultValue;
        }
        // Parse the double value
        return Double.parseDouble(value);
    }

    private static String parseString(String value) {
        // Check if the value is empty or null before parsing
        if (value == null || value.isEmpty()) {
            String defaultValue = "N/A";
            return defaultValue;
        }
        return value;
    }
}
