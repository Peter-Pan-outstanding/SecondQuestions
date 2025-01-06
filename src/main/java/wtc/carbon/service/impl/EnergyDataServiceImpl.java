package wtc.carbon.service.impl;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import wtc.carbon.entity.EnergyData;
import wtc.carbon.mapper.EnergyDataMapper;
import wtc.carbon.service.EnergyDataService;

import java.time.LocalDate;
import java.util.List;

@Service
public class EnergyDataServiceImpl implements EnergyDataService {
    @Resource
    private EnergyDataMapper mapper;

    @Override
    public List<EnergyData> getAllEnergyData() {
        return mapper.findAll();
    }

    @Override
    public List<EnergyData> searchEnergyData(String deviceName, LocalDate date) {
        return mapper.searchByDeviceNameAndDate(deviceName, date);
    }
}