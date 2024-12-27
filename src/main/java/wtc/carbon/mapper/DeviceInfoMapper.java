package wtc.carbon.mapper;

import org.apache.ibatis.annotations.Mapper;
import wtc.carbon.entity.DeviceInfo;

import java.util.List;

@Mapper
public interface DeviceInfoMapper {
    List<DeviceInfo> getAllDeviceInfo();

    DeviceInfo getDeviceInfoById(Integer id);

    Integer saveDeviceInfo(DeviceInfo deviceInfo);

    Integer updateDeviceInfo(DeviceInfo deviceInfo);

    Integer deleteDeviceInfo(Integer id);

}
