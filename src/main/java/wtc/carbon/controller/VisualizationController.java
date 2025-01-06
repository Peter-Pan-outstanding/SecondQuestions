package wtc.carbon.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import wtc.carbon.common.Result;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/visualization")
public class VisualizationController {

    @GetMapping("/dashboard")
    public Result<?> getDashboardData() {
        Map<String, Object> data = Map.of(
                "totalElectricity", 5000,
                "totalWater", 2000,
                "totalCarbonEmission", 300
        );
        return Result.success(data);
    }

    @GetMapping("/energyBreakdown")
    public Result<?> getEnergyBreakdown() {
        Map<String, Object> data = Map.of(
                "totalEnergy", 10000,
                "breakdown", List.of(
                        Map.of("type", "办公耗电量", "value", 2500, "percentage", 25),
                        Map.of("type", "办公用水量", "value", 1500, "percentage", 15),
                        Map.of("type", "生产用水量", "value", 3000, "percentage", 30),
                        Map.of("type", "生产耗电量", "value", 3000, "percentage", 30)
                )
        );
        return Result.success(data);
    }

    @GetMapping("/inventoryWarning")
    public Result<?> getInventoryWarning() {
        Map<String, Object> data = Map.of(
                "products", List.of(
                        Map.of("name", "产品A", "inventory", 80),
                        Map.of("name", "产品B", "inventory", 50),
                        Map.of("name", "产品C", "inventory", 120),
                        Map.of("name", "产品D", "inventory", 40),
                        Map.of("name", "产品E", "inventory", 60)
                ),
                "warningLine", 70
        );
        return Result.success(data);
    }


    @GetMapping("/dataOverview")
    public Result<?> getDataOverview() {
        List<Map<String, Object>> data = List.of(
                Map.of("month", "2023-01", "visits", 850, "orders", 320),
                Map.of("month", "2023-02", "visits", 780, "orders", 350),
                Map.of("month", "2023-03", "visits", 900, "orders", 400),
                Map.of("month", "2023-04", "visits", 600, "orders", 220),
                Map.of("month", "2023-05", "visits", 950, "orders", 450),
                Map.of("month", "2023-06", "visits", 700, "orders", 330)
        );

        return Result.success(data);
    }


    // 新增销售计划数据接口
    @GetMapping("/salesPlanning")
    public Result<?> getSalesPlanningData() {
        List<Map<String, Object>> data = List.of(
                Map.of("month", "2023-01", "actualSales", 800, "plannedSales", 1000),
                Map.of("month", "2023-02", "actualSales", 950, "plannedSales", 1100),
                Map.of("month", "2023-03", "actualSales", 1200, "plannedSales", 1200),
                Map.of("month", "2023-04", "actualSales", 1000, "plannedSales", 1100),
                Map.of("month", "2023-05", "actualSales", 1100, "plannedSales", 1150),
                Map.of("month", "2023-06", "actualSales", 1300, "plannedSales", 1300)
        );
        return Result.success(data);
    }


}
