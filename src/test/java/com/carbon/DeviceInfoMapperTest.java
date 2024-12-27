package com.carbon;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import wtc.carbon.CarbonApplication;
import wtc.carbon.entity.DeviceInfo;
import wtc.carbon.mapper.DeviceInfoMapper;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest(classes = CarbonApplication.class)
public class DeviceInfoMapperTest {

    @Resource
    private DeviceInfoMapper deviceInfoMapper;

    @Test
    @Sql(scripts = {"classpath:schema.sql", "classpath:data.sql"}) // 确保 schema.sql 和 data.sql 设置了测试所需的表和数据
    public void testGetAllDeviceInfo() {
        List<DeviceInfo> deviceInfos = deviceInfoMapper.getAllDeviceInfo();
        Assertions.assertNotNull(deviceInfos, "Device info list should not be null");
        Assertions.assertFalse(deviceInfos.isEmpty(), "Device info list should not be empty");
    }

    @Test
    public void testSaveDeviceInfo() {
        DeviceInfo deviceInfo = new DeviceInfo();
        //deviceInfo.setId(1); // 如果数据库有自动生成 ID 的功能，这里可以忽略 ID 设置
        deviceInfo.setName("Test Device");
        deviceInfo.setCode("TD-12345");
        deviceInfo.setManufactureDate(LocalDateTime.now());
        deviceInfo.setManufactureNumber("MN-98765");
        deviceInfo.setManufacturer("Test Manufacturer");
        deviceInfo.setDeviceStatus("Active");

        Integer result = deviceInfoMapper.saveDeviceInfo(deviceInfo);
        Assertions.assertEquals(1, result, "Device info should be saved successfully");

        List<DeviceInfo> deviceInfos = deviceInfoMapper.getAllDeviceInfo();
        Assertions.assertTrue(deviceInfos.stream().anyMatch(d -> "Test Device".equals(d.getName())), "Saved device info should be retrievable");
    }
}