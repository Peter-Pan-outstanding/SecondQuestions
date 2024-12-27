package wtc.carbon.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeviceInfo {
    private Integer id;
    private String name;
    private String code;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime manufactureDate;
    private String manufactureNumber;
    private String manufacturer;
    private String deviceStatus;
}

