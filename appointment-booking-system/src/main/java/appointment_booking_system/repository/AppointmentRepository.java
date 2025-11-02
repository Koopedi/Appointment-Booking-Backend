package appointment_booking_system.repository;

import appointment_booking_system.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findByBranchNameAndAppointmentDateBetweenAndStatus(
            String branchName,
            LocalDateTime startOfDay,
            LocalDateTime endOfDay,
            Appointment.Status status
    );

}
