package be.kdg.backendfrontend.Service;

import be.kdg.backendfrontend.Domain.ArduinoDevice;
import be.kdg.backendfrontend.Repository.JdbcDeviceRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {
    private JdbcDeviceRepository jdbcDeviceRepository;

    public DeviceServiceImpl(JdbcDeviceRepository jdbcDeviceRepository) {
        this.jdbcDeviceRepository = jdbcDeviceRepository;
    }

    @Override
    public List<ArduinoDevice> findAllDevice() {
        return jdbcDeviceRepository.findAllDevice();
    }

    @Override
    public ArduinoDevice createDevice(ArduinoDevice device) {
        return jdbcDeviceRepository.createDevice(device);
    }

    @Override
    public ArduinoDevice findDeviceById(int id) {
        return jdbcDeviceRepository.findDeviceById(id);
    }

    @Override
    public void updateDevice(ArduinoDevice device) {
        jdbcDeviceRepository.updateDevice(device);
    }
}
