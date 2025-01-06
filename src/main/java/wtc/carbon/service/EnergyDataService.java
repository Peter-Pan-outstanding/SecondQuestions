package wtc.carbon.service;

import wtc.carbon.entity.EnergyData;
import java.time.LocalDate;
import java.util.List;

public interface EnergyDataService {
    List<EnergyData> getAllEnergyData();
    List<EnergyData> searchEnergyData(String deviceName, LocalDate date);
}