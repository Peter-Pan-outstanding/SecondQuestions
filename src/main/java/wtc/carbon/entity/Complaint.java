package wtc.carbon.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Complaint {
    private Integer id;
    private String title;
    private String content;
    private String contactPerson;
    private String contactPhone;
    private LocalDateTime createdTime;
    private String status;
    private String result;
    private String attachment;
}
