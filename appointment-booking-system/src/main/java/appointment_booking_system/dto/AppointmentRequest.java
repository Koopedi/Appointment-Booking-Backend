package appointment_booking_system.dto;

import lombok.Data;
import java.time.LocalDateTime;


@Data
public class AppointmentRequest {
    private String customerName;
    private String branchName;
    private LocalDateTime appointmentDate;
    private String contactNumber;


}
