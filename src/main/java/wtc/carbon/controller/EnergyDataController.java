package wtc.carbon.controller;

import jakarta.annotation.Resource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import wtc.carbon.common.Result;
import wtc.carbon.entity.EnergyData;
import wtc.carbon.service.EnergyDataService;
import java.time.LocalDate;

@RestController
@RequestMapping("/energyData")
public class EnergyDataController {
    @Resource
    private EnergyDataService service;

    @GetMapping("/list")
    public Result<?> list() {
        return Result.success(service.getAllEnergyData());
    }

    @GetMapping("/search")
    public Result<?> search(
            @RequestParam(required = false) String deviceName,
            @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate date) {
        System.out.println("deviceName = " + deviceName);
        return Result.success(service.searchEnergyData(deviceName, date));
    }
}
