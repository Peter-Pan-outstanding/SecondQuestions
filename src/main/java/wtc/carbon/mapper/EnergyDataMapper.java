package wtc.carbon.mapper;

import org.apache.ibatis.annotations.Mapper;
import wtc.carbon.entity.EnergyData;
import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EnergyDataMapper {
    List<EnergyData> findAll();
    List<EnergyData> searchByDeviceNameAndDate(String deviceName, LocalDate date);
}
