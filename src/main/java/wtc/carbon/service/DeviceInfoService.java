package wtc.carbon.service;


import wtc.carbon.entity.DeviceInfo;

import java.util.List;

public interface DeviceInfoService {

    List<DeviceInfo> getAllDeviceInfo();

    DeviceInfo getDeviceInfoById(Integer id);

    boolean saveDeviceInfo(DeviceInfo deviceInfo);

    boolean updateDeviceInfo(DeviceInfo deviceInfo);

    boolean deleteDeviceInfoById(Integer id);

}
