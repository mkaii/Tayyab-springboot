package be.kdg.backendfrontend.Repository;

import be.kdg.backendfrontend.Domain.ArduinoDevice;

import java.util.List;

public interface JdbcDeviceRepository {

    List<ArduinoDevice> findAllDevice();

    ArduinoDevice createDevice(ArduinoDevice arduinoDevice);


    ArduinoDevice findDeviceById(int deviceID);

    void updateDevice(ArduinoDevice arduinoDevice);
}
