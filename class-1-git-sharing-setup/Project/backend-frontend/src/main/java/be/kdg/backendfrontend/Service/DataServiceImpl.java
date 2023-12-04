package be.kdg.backendfrontend.Service;

import be.kdg.backendfrontend.Domain.Data;
import be.kdg.backendfrontend.Repository.JdbcDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataServiceImpl implements DataService {
    private JdbcDataRepository jdbcDataRepository;

    public DataServiceImpl(JdbcDataRepository jdbcDataRepository) {
        this.jdbcDataRepository = jdbcDataRepository;
    }

    @Override
    public List<Data> findAllData() {
        return jdbcDataRepository.findAllData();
    }

    @Override
    public Data createData(Data data) {
        return jdbcDataRepository.createData(data);
    }

    @Override
    public Data findDataById(int id) {
        return jdbcDataRepository.findDataById(id);
    }
    @Override
    public double returningLongitude(Data data){
        return jdbcDataRepository.returningLongitude(data);
    }
    @Override
    public double returningLatitude(Data data){
        return jdbcDataRepository.returningLatitude(data);
    }
    @Override
    public String generateGpsString(String longInput, String latInput, String headingAngle){
        return jdbcDataRepository.generateGpsString(longInput, latInput, headingAngle);
    }
}
