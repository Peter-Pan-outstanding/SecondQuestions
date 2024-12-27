package wtc.carbon.service.impl;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import wtc.carbon.entity.DeviceInfo;
import wtc.carbon.mapper.DeviceInfoMapper;
import wtc.carbon.service.DeviceInfoService;

import java.util.List;

@Service
public class DeviceInfoServiceImpl implements DeviceInfoService {

    @Resource
    private DeviceInfoMapper deviceInfoMapper;


    @Override
    public List<DeviceInfo> getAllDeviceInfo() {
        return deviceInfoMapper.getAllDeviceInfo();
    }
}
