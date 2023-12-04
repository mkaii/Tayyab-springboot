package be.kdg.backendfrontend.Repository;

import be.kdg.backendfrontend.Domain.Data;

import java.util.List;

public interface JdbcDataRepository {
    List<Data> findAllData();

    Data createData(Data data);

    Data findDataById(double dataID);

    double returningLongitude(Data data);

    double returningLatitude(Data data);

    String generateGpsString(String longInput, String latInput, String headingAngle);
}
