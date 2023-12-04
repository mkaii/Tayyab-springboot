package be.kdg.backendfrontend.Service;

import be.kdg.backendfrontend.Domain.Data;

import java.util.List;

public interface DataService {
    List<Data> findAllData();
    Data createData(Data data);
    Data findDataById(int id);

    double returningLongitude(Data data);

    double returningLatitude(Data data);

    String generateGpsString(String longInput, String latInput, String headingAngle);
}
