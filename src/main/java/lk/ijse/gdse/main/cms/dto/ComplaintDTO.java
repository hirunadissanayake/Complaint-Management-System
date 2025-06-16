package lk.ijse.gdse.main.cms.dto;

import lombok.*;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class ComplaintDTO {
    private int complaintId;
    private String title;
    private String description;
    private String priority;
    private int submittedBy;
    private String adminRemarks;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
