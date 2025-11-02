package appointment_booking_system;

import appointment_booking_system.entity.Appointment;
import appointment_booking_system.repository.AppointmentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataInitializer implements CommandLineRunner {

    private final AppointmentRepository repository;

    public DataInitializer(AppointmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {
        repository.save(Appointment.builder()
                .customerName("Tshepo Koopedi")
                .branchName("Sandton Branch")
                .appointmentDate(LocalDateTime.of(2025, 11, 5, 10, 0))
                .contactNumber("0812345678")
                .status(Appointment.Status.SCHEDULED)
                .build());

        repository.save(Appointment.builder()
                .customerName("Thabang Koopedi")
                .branchName("Pretoria Branch")
                .appointmentDate(LocalDateTime.of(2025, 11, 6, 14, 30))
                .contactNumber("0823456789")
                .status(Appointment.Status.SCHEDULED)
                .build());

        repository.save(Appointment.builder()
                .customerName("Robert Koopedi")
                .branchName("Cape Town Branch")
                .appointmentDate(LocalDateTime.of(2025, 11, 7, 9, 0))
                .contactNumber("0834567890")
                .status(Appointment.Status.CANCELLED)
                .build());

        repository.save(Appointment.builder()
                .customerName("Taylor Smith")
                .branchName("Johannesburg Branch")
                .appointmentDate(LocalDateTime.of(2025, 11, 8, 11, 15))
                .contactNumber("0845678901")
                .status(Appointment.Status.SCHEDULED)
                .build());

        repository.save(Appointment.builder()
                .customerName("Robert Wilson")
                .branchName("Durban Branch")
                .appointmentDate(LocalDateTime.of(2025, 11, 9, 15, 45))
                .contactNumber("0856789012")
                .status(Appointment.Status.COMPLETED)
                .build());
    }
}
