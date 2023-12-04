package be.kdg.backendfrontend.Service;

import be.kdg.backendfrontend.Domain.ArduinoDevice;

import java.util.List;

public interface DeviceService {
    List<ArduinoDevice> findAllDevice();
    ArduinoDevice createDevice(ArduinoDevice device);
    ArduinoDevice findDeviceById(int id);
    void updateDevice(ArduinoDevice device);
}
