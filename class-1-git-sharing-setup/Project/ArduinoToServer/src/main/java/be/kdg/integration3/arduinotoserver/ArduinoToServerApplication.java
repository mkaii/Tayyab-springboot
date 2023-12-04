package be.kdg.integration3.arduinotoserver;

import be.kdg.integration3.arduinotoserver.Domain.SerialConnection;
import be.kdg.integration3.arduinotoserver.Service.Menu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class ArduinoToServerApplication {

    public static void main(String[] args) throws IOException {
        ApplicationContext context =
            SpringApplication.run(ArduinoToServerApplication.class, args);

        // comment out if you want to use only the serial port and no server connection
        context.getBean(Menu.class).showMenu();

        // uncomment if you want to only use the serial port and no server connection
//        context.getBean(SerialConnection.class).serialConnectionStart();
    }
}
