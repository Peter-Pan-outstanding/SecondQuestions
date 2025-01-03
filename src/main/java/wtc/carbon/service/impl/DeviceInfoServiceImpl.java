package wtc.carbon.service.impl;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import wtc.carbon.entity.DeviceInfo;
import wtc.carbon.mapper.DeviceInfoMapper;
import wtc.carbon.service.DeviceInfoService;

import java.time.LocalDate;
import java.util.List;

@Service
public class DeviceInfoServiceImpl implements DeviceInfoService {

    @Resource
    private DeviceInfoMapper deviceInfoMapper;


    @Override
    public List<DeviceInfo> getAllDeviceInfo() {
        return deviceInfoMapper.getAllDeviceInfo();
    }

    @Override
    public DeviceInfo getDeviceInfoById(Integer id){
        return deviceInfoMapper.getDeviceInfoById(id);
    }

    @Override
    public boolean saveDeviceInfo(DeviceInfo deviceInfo) {
        return deviceInfoMapper.saveDeviceInfo(deviceInfo) >= 1;
    }

    @Override
    public boolean updateDeviceInfo(DeviceInfo deviceInfo) {
        return deviceInfoMapper.updateDeviceInfo(deviceInfo) >= 1;
    }

    @Override
    public boolean deleteDeviceInfoById(Integer id) {
        return deviceInfoMapper.deleteDeviceInfo(id) >= 1;
    }

    @Override
    public List<DeviceInfo> searchDevices(String name, String code, String model, LocalDate startDate, LocalDate endDate, String batchNumber, String manufacturer, String status) {
        return deviceInfoMapper.searchDevices(name, code, model, startDate, endDate, batchNumber, manufacturer, status);
    }
}
