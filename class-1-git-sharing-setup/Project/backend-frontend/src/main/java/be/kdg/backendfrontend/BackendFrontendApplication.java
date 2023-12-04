package be.kdg.backendfrontend;

import be.kdg.backendfrontend.Calculation.PathFinder;
import be.kdg.backendfrontend.Domain.SocketConnectionServer;
import be.kdg.backendfrontend.Presenter.DeviceMenu;
import be.kdg.backendfrontend.Repository.JdbcTemplateDataRepository;
import com.fazecast.jSerialComm.SerialPort;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.IOException;
import java.util.Scanner;


@SpringBootApplication
public class BackendFrontendApplication {

	public static void main(String[] args) throws IOException {

		// Pathfinder test
		PathFinder pathFinder = new PathFinder(4.403, 51.21, 4.403, 51.22, 2, 1, 45);

//		PathFinder pathFinder2 = new PathFinder(4.403, 51.25, 45);

		System.out.println("Distance: " + pathFinder.calculateDistance(pathFinder));
		System.out.println("Boat angle: " + pathFinder.getBoatAngle(pathFinder));
		System.out.println("Intersect angle: " + pathFinder.calculateIntersectAngle(pathFinder));
		System.out.println("Intersect distance: " + pathFinder.calculateIntersectDistance(pathFinder));
		System.out.println("Intersect point x:" + pathFinder.calculateIntersectX(pathFinder));
		System.out.println("Intersect point y:" + pathFinder.calculateIntersectY(pathFinder));

//		System.out.println("Distance: " + pathFinder2.calculateDistance(pathFinder2));
//		System.out.println("Boat angle: " + pathFinder2.getBoatAngle(pathFinder2));
//		System.out.println("Intersect angle: " + pathFinder2.calculateIntersectAngle(pathFinder2));
//		System.out.println("Intersect distance: " + pathFinder2.calculateIntersectDistance(pathFinder2));
//		System.out.println("Intersect point x:" + pathFinder2.calculateIntersectX(pathFinder2));
//		System.out.println("Intersect point y:" + pathFinder2.calculateIntersectY(pathFinder2));


		/*SpringApplication.run(BackendFrontendApplication.class, args);

		String inputString = "220739.000, a, 3244.8533, 11711.1233, W,0.30,209.10,240319,,,A*79";
		String inputString2 = "239.000, a, 3244.8533, 11711.1233, W,0.30,209.10,240319,,,A*79";
		ArduinoDevice dvc1 = new ArduinoDevice("1", DeviceType.AUTONOMOUS_CRAFT);
		// Call the function to split the string
		ArrayList<String> result = splitString(inputString);
		ArrayList<String> result2 = splitString(inputString2);

		// Print the result
		System.out.println("Resulting ArrayList: " + result);
		dvc1.setGPSData(result2);

		System.out.println(dvc1.getGPSData().get(0));
		System.out.println(dvc1.getGPSData().get(1));*/


//		String input = "220739.000, a, 3244.8533, 11711.1233, W,0.30,209.10,240319,,,A*79";
//		insertIntoTable(input);


		ApplicationContext context =
				SpringApplication.run(BackendFrontendApplication.class, args);
//		context.getBean(SocketConnectionServer.class).start(5100);
//		context.getBean(DeviceMenu.class).showDeviceMenu();




//		context.getBean(SocketConnectionServer.class).start(5000);
		context.getBean(DeviceMenu.class).showDeviceMenu();
	}

}
