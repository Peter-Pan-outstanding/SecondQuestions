package wtc.carbon.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wtc.carbon.common.Result;
import wtc.carbon.entity.DeviceInfo;
import wtc.carbon.service.DeviceInfoService;

import java.util.List;

@RestController
@RequestMapping("/deviceInfo")
public class DeviceInfoController {

    @Resource
    private DeviceInfoService service;

    @GetMapping("/getAll")
    public Result<?> getAll(){
        List<DeviceInfo> allDeviceInfo = service.getAllDeviceInfo();
        if (allDeviceInfo.isEmpty()) {
            return Result.error(400,"没有设备信息");
        } else {
            return Result.success(allDeviceInfo);
        }
    }


}
