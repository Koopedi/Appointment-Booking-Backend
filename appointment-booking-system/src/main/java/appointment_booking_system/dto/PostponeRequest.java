package appointment_booking_system.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class PostponeRequest {
    private Long appointmentId;
    private LocalDateTime newDate;
}
