package wtc.carbon.controller;

import jakarta.annotation.Resource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import wtc.carbon.common.Result;
import wtc.carbon.entity.DeviceInfo;
import wtc.carbon.service.DeviceInfoService;

import java.time.LocalDate;
import java.util.Date;
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

    // 根据条件查询
    @GetMapping("/search")
    public Result<?> search(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String code,
            @RequestParam(required = false) String model,
            @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate startDate,
            @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate endDate,
            @RequestParam(required = false) String batchNumber,
            @RequestParam(required = false) String manufacturer,
            @RequestParam(required = false) String status) {
        System.out.println("startDate = " + startDate);
        List<DeviceInfo> devices = service.searchDevices(name, code, model, startDate, endDate, batchNumber, manufacturer, status);
        System.out.println(devices);
        return !devices.isEmpty()
                ? Result.success(devices)
                : Result.error(404, "没有找到符合条件的设备信息");
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
        System.out.println(deviceInfo);
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
