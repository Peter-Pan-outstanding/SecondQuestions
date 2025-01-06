package wtc.carbon.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnergyData {
    private Integer id;
    private String deviceName; // 设备名称
    private Integer producedQuantity; // 已产数量
    private Double unitElectricityConsumption; // 单位耗电量
    private Double totalElectricityConsumption; // 总耗电量
    private Double unitCarbonEmission; // 单位碳排放
    private Double totalCarbonEmission; // 总碳排放
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date; // 日期
}
