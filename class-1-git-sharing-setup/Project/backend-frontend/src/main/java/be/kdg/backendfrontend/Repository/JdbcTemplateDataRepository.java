package be.kdg.backendfrontend.Repository;

import be.kdg.backendfrontend.Domain.Data;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Profile("dev")
public class JdbcTemplateDataRepository implements JdbcDataRepository {
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert jdbcInsert;

    public JdbcTemplateDataRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.jdbcInsert =
                new SimpleJdbcInsert(jdbcTemplate).withTableName("DATA").usingGeneratedKeyColumns("DATA_ID");
    }

    public static Data mapDataRow(ResultSet rs, int rowID) throws SQLException {
        return new Data(rs.getInt("DEVICE_ID"), rs.getInt("DATA_ID"),
                LocalDate.parse(rs.getString("DATE"), DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                rs.getString("STATUS"), rs.getDouble("LATITUDE"), rs.getString(
                "LATITUDE_DIRECTION"), rs.getDouble("LONGITUDE"), rs.getString(
                "LONGITUDE_DIRECTION"), rs.getDouble("HEADING"), rs.getDouble(
                "MAGNETIC_DEVIATION"), rs.getString("DEVIATION_DIRECTION"));
    }

    @Override
    public List<Data> findAllData() {
        List<Data> dataList = jdbcTemplate.query("SELECT * FROM DATA",
                JdbcTemplateDataRepository::mapDataRow);
        return dataList;
    }

    @Override
    public Data createData(Data data) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("DEVICE_ID", data.getDeviceID());
        parameters.put("DATE", data.getDate());
        parameters.put("STATUS", data.getStatus());
        parameters.put("LATITUDE", data.getLatitude());
        parameters.put("LATITUDE_DIRECTION", data.getLatitudeDirection());
        parameters.put("LONGITUDE", data.getLongitude());
        parameters.put("LONGITUDE_DIRECTION", data.getLongitudeDirection());
        parameters.put("HEADING", data.getHeading());
        parameters.put("MAGNETIC_DEVIATION", data.getMagneticDeviation());
        parameters.put("DEVIATION_DIRECTION", data.getDeviationDirection());
        data.setDataID(jdbcInsert.executeAndReturnKey(parameters).intValue());
        return data;

    }

    @Override
    public Data findDataById(double dataID) {
        Data data = jdbcTemplate.queryForObject("SELECT * FROM DATA WHERE DATA_ID = ?",
                JdbcTemplateDataRepository::mapDataRow, dataID);
        return data;
    }

    public static Data parseData(String input, int deviceID) {
        // Split the input string by commas
        String[] fields = input.split(",");

        // Extract individual values
        LocalDate date = LocalDate.now();
        String status = fields[2];
        Double latitude = parseLongLat(fields[3]);
        String latitudeDirection = fields[4];
        Double longitude = parseLongLat(fields[5]);
        String longitudeDirection = fields[6];
        Double heading = parseDouble(fields[7]);
        Double magneticDeviation = parseDouble(fields[9]);
        String deviationDirection = parseString(fields[10]);

        // Create and return a Data object
        return new Data(deviceID, date, status, latitude, latitudeDirection, longitude,
                longitudeDirection, heading, magneticDeviation, deviationDirection);
    }

    //TODO make it so that the first one to two lines in the Serial reader and ignored, so that
    // we get complete string
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

    @Override
    public double returningLongitude(Data data) {
        try {
            double longitude = data.getLongitude();
            String longitudeDirection = data.getLongitudeDirection();
            if (longitudeDirection.equals("W")) {
                longitude = longitude * -1;
            }
            return longitude;
        } catch (NullPointerException e) {
            System.out.println("No longitude found");
            return 0;
        }
    }

    @Override
    public double returningLatitude(Data data) {
        try {
            double latitude = data.getLatitude();
            String latitudeDirection = data.getLatitudeDirection();
            if (latitudeDirection.equals("S")) {
                latitude = latitude * -1;
            }
            return latitude;
        } catch (NullPointerException e) {
            System.out.println("No latitude found");
            return 0;
        }
    }

    private static double parseLongLat(String value) {
        // Check if the value is empty or null before parsing
        if (value == null || value.isEmpty()) {
            double defaultValue = 0.0;
            return defaultValue;
        }
        // Parse the double value
        double newValue = Double.parseDouble(value);
        newValue = newValue / 100;
        return newValue;
    }

    @Override
    public String generateGpsString(String longInput, String latInput, String headingAngle) {
        BigDecimal modifiedLong = new BigDecimal(longInput).multiply(BigDecimal.valueOf(100));
        BigDecimal modifiedLat = new BigDecimal(latInput).multiply(BigDecimal.valueOf(100));

        String gpsString = "$GPRMC,";
        gpsString += "123519,A,";

        if (modifiedLong.signum() == -1) {
            gpsString += modifiedLong.abs() + ",S,";
        } else {
            gpsString += modifiedLong + ",N,";
        }

        if (modifiedLat.signum() == -1) {
            gpsString += modifiedLat.abs() + ",W,";
        } else {
            gpsString += modifiedLat + ",E,";
        }

        gpsString += "0.30" + ",";
        gpsString += headingAngle + ",";
        gpsString += "170419,";
        gpsString += ",E,";
        gpsString += "A*79";

        return gpsString;
    }

//    public static Data parseData(String input, int deviceID) {
//        // Split the input string by commas
//        String[] fields = input.split(",");
//
//        // Extract individual values
//        LocalDate date = LocalDate.now();
//        String status = fields[2];
//        double latitude = Double.parseDouble(fields[3]);
//        String latitudeDirection = fields[4];
//        double longitude = Double.parseDouble(fields[5]);
//        String longitudeDirection = fields[6];
//        double heading = Double.parseDouble(fields[7]);
//        double magneticDeviation = Double.parseDouble(fields[9]);
//        String deviationDirection = fields[10];
//
//        // Create and return a Data object
//        return new Data(deviceID, date, status, latitude, latitudeDirection, longitude,
//                longitudeDirection, heading, magneticDeviation, deviationDirection);
//    }
}
