package be.kdg.backendfrontend.Repository;

import be.kdg.backendfrontend.Domain.ArduinoDevice;
import be.kdg.backendfrontend.Domain.Data;
import be.kdg.backendfrontend.Domain.DeviceType;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// TODO figure out if you want this code or to replace it with 'try' so that it closes the
//  connection automatically
@Repository
@Profile("dev")
public class JdbcTemplateDeviceRepository implements JdbcDeviceRepository {
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert jdbcInsert;

    public JdbcTemplateDeviceRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.jdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("DEVICE")
                .usingGeneratedKeyColumns("DEVICE_ID");
    }

    public static ArduinoDevice mapDeviceRow(ResultSet rs, int rowID) throws SQLException {
        return new ArduinoDevice(rs.getInt("DEVICE_ID"), rs.getString("DEVICE_TYPE").equals(
                "MOB_VICTIM") ? DeviceType.MOB_VICTIM : DeviceType.AUTONOMOUS_CRAFT);
    }

    @Override
    public List<ArduinoDevice> findAllDevice() {
        List<ArduinoDevice> deviceList = jdbcTemplate.query("SELECT * FROM DEVICE",
                JdbcTemplateDeviceRepository::mapDeviceRow);
        deviceList.forEach(this::loadDeviceData);
        return deviceList;
    }

    @Override
    public ArduinoDevice createDevice(ArduinoDevice arduinoDevice) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("DEVICE_ID", arduinoDevice.getDeviceID());
        parameters.put("DEVICE_TYPE", arduinoDevice.getDeviceType().toString());
        arduinoDevice.setDeviceID(jdbcInsert.executeAndReturnKey(parameters).intValue());
        return arduinoDevice;
    }

    @Override
    public ArduinoDevice findDeviceById(int deviceID) {
        ArduinoDevice arduinoDevice = jdbcTemplate.queryForObject("SELECT * FROM DEVICE WHERE " +
                "DEVICE_ID = ?", JdbcTemplateDeviceRepository::mapDeviceRow, deviceID);
        if (arduinoDevice != null) {
            loadDeviceData(arduinoDevice);
        }
        return arduinoDevice;
    }

    private void loadDeviceData(ArduinoDevice arduinoDevice) {
        List<Data> dataList = jdbcTemplate.query("SELECT * FROM DATA WHERE DEVICE_ID = ?",
                JdbcTemplateDataRepository::mapDataRow, arduinoDevice.getDeviceID());
        arduinoDevice.setDataList(dataList);
    }

    @Override
    public void updateDevice(ArduinoDevice arduinoDevice) {
        jdbcTemplate.update("UPDATE DEVICE SET DEVICE_TYPE = ? WHERE DEVICE_ID = ?",
                arduinoDevice.getDeviceType().toString(), arduinoDevice.getDeviceID());
        jdbcTemplate.update("DELETE FROM DATA WHERE DEVICE_ID = ?", arduinoDevice.getDeviceID());
        for (Data data : arduinoDevice.getDataList()) {
            jdbcTemplate.update("INSERT INTO data (DEVICE_ID, DATE, STATUS, LATITUDE, " +
                    "LATITUDE_DIRECTION, LONGITUDE, LONGITUDE_DIRECTION, HEADING, " +
                    "MAGNETIC_DEVIATION, DEVIATION_DIRECTION) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                    "?)", arduinoDevice.getDeviceID(), data.getDate(), data.getStatus(),
                    data.getLatitude(), data.getLatitudeDirection(), data.getLongitude(),
                    data.getLongitudeDirection(), data.getHeading(), data.getMagneticDeviation(),
                    data.getDeviationDirection());
        }
    }
}





