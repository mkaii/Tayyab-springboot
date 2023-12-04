package be.kdg.integration3.arduinotoserver.Service;

import be.kdg.integration3.arduinotoserver.Domain.ClientConnection;
import be.kdg.integration3.arduinotoserver.Domain.SerialConnection;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Scanner;

@Component
public class Menu {

    public SerialConnection serialConnection = new SerialConnection();
    public Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        System.out.println("Welcome to the Arduino application setup!");
        System.out.println("========================================");
        System.out.println("Please select the IP address of the server:");
        while (true) {
            System.out.println("""
                    1. 10.134.178.154
                    2. localhost
                    2. input IP address
                    3. Exit
                    """);
            int choiceIP = scanner.nextInt();
            scanner.nextLine();
            switch (choiceIP) {
                case 1 -> preparedIP();
                case 2 -> localhost();
                case 3 -> inputIP();
                case 0 -> System.exit(0);
            }
        }
    }

    public void preparedIP() {
        ClientConnection clientConnectionPrepared = new ClientConnection();
        try {
            clientConnectionPrepared.startConnection("10.134.178.154", 5100);
            System.out.println("Connection established");
            System.out.println("========================================");
            SerialStart();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void localhost() {
        ClientConnection clientConnectionLocalhost = new ClientConnection();
        try {
            clientConnectionLocalhost.startConnection("localhost", 5100);
            System.out.println("Connection established to localhost");
            System.out.println("========================================");
            SerialStart();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void inputIP() {
        System.out.println("Please enter the IP address of the server");
        System.out.println("or enter 0 to exit:");
        String ip = scanner.nextLine();
        if (ip.equals("0")) {
            System.out.println("Exiting the application");
            System.exit(0);
        }
        System.out.println("Please enter the port of the server");
        System.out.println("or enter 0 to exit:");
        int port = scanner.nextInt();
        scanner.nextLine();
        if (port == 0) {
            System.out.println("Exiting the application");
            System.exit(0);
        }
        ClientConnection clientConnectionInput = new ClientConnection();
        try {
            clientConnectionInput.startConnection(ip, port);
            System.out.println("Connection established");
            System.out.println("========================================");
            SerialStart();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void SerialStart() throws IOException {
        System.out.println("Starting the serial connection");
        serialConnection.serialConnectionStart();
    }
}
