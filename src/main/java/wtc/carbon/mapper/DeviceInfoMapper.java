package wtc.carbon.mapper;

import org.apache.ibatis.annotations.Mapper;
import wtc.carbon.entity.DeviceInfo;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Mapper
public interface DeviceInfoMapper {
    List<DeviceInfo> getAllDeviceInfo();

    DeviceInfo getDeviceInfoById(Integer id);

    Integer saveDeviceInfo(DeviceInfo deviceInfo);

    Integer updateDeviceInfo(DeviceInfo deviceInfo);

    Integer deleteDeviceInfo(Integer id);

    // 添加搜索方法
    List<DeviceInfo> searchDevices(
            String name,
            String code,
            String model,
            LocalDate startDate,
            LocalDate endDate,
            String manufactureNumber,
            String manufacturer,
            String status);
}
