package be.kdg.programming3.HotelBooking.repository;

import be.kdg.programming3.HotelBooking.util.LocalDateTimeSerializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class JSonWriter {
    public static <T> void saveToJsonFile(List<T> dataList, String filePath) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer());
        Gson gson = gsonBuilder.create();

        String jsonString = gson.toJson(dataList);

        try (FileWriter jsonWriter = new FileWriter(filePath)) {
            jsonWriter.write(jsonString);
            System.out.println("Data saved to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
