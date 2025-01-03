package wtc.carbon.service;


import wtc.carbon.entity.DeviceInfo;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface DeviceInfoService {

    List<DeviceInfo> getAllDeviceInfo();

    DeviceInfo getDeviceInfoById(Integer id);

    boolean saveDeviceInfo(DeviceInfo deviceInfo);

    boolean updateDeviceInfo(DeviceInfo deviceInfo);

    boolean deleteDeviceInfoById(Integer id);

    List<DeviceInfo> searchDevices(String name, String code, String model, LocalDate startDate, LocalDate endDate, String batchNumber, String manufacturer, String status);
}
