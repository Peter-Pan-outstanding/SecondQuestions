package wtc.carbon.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import wtc.carbon.common.Result;
import wtc.carbon.entity.DeviceInfo;
import wtc.carbon.service.DeviceInfoService;

import java.util.List;



@RestController
@RequestMapping("/deviceInfo")
public class DeviceInfoController {

    @Resource
    private DeviceInfoService service;

    @GetMapping("/list")
    public Result<?> list(){
        List<DeviceInfo> allDeviceInfo = service.getAllDeviceInfo();
        return !allDeviceInfo.isEmpty()
                ? Result.success(allDeviceInfo)
                : Result.error(404, "没有设备信息");
    }

    @GetMapping("/get/{id}")
    public Result<?> get(@PathVariable Integer id){
        DeviceInfo deviceInfo = service.getDeviceInfoById(id);
        return deviceInfo != null
                ? Result.success(deviceInfo)
                : Result.error(404,"没有这样的设备");
    }

    @PostMapping("/save")
    public Result<?> save(@RequestBody DeviceInfo deviceInfo){
        boolean isSave = service.saveDeviceInfo(deviceInfo);

        return isSave
                ? Result.success("保存成功")
                : Result.error(400, "保存失败，请检查id是否存在");
    }

    @PutMapping("/update")
    public Result<?> update(@RequestBody DeviceInfo deviceInfo){
        boolean isUpdate = service.updateDeviceInfo(deviceInfo);
        return isUpdate
                ? Result.success("更新成功")
                : Result.error(400, "请检查id是否正确");

    }

    @DeleteMapping("/delete/{id}")
    public Result<?> delete(@PathVariable Integer id){
        boolean isDel = service.deleteDeviceInfoById(id);
        return isDel
                ? Result.success("成功刪除")
                : Result.error(400, "刪除失败，请联系管理员");

    }



}
