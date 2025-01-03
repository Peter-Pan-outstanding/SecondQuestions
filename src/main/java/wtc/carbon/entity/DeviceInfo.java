package wtc.carbon.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeviceInfo {
    private Integer id;
    private String name;
    private String code;
    private String model;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate manufactureDate;
    private String manufactureNumber;
    private String manufacturer;
    private String deviceStatus;
    private String note;
}

