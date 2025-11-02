package appointment_booking_system.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;
    private String branchName;
    private LocalDateTime appointmentDate;
    private String contactNumber;

    @Enumerated(EnumType.STRING)
    private Status status;


    public enum Status {
        SCHEDULED, CANCELLED, COMPLETED
    }
}
