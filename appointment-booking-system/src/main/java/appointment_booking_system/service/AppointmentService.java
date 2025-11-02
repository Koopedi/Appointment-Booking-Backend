package appointment_booking_system.service;

import appointment_booking_system.dto.AppointmentRequest;
import appointment_booking_system.dto.PostponeRequest;
import appointment_booking_system.entity.Appointment;
import appointment_booking_system.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {

   @Autowired
    AppointmentRepository repository;

    public Appointment create(AppointmentRequest request) {
        Appointment appointment = Appointment.builder()
                .customerName(request.getCustomerName())
                .branchName(request.getBranchName())
                .appointmentDate(request.getAppointmentDate())
                .contactNumber(request.getContactNumber())
                .status(Appointment.Status.SCHEDULED)
                .build();
        return repository.save(appointment);
    }

    public List<Appointment> getAll() {
        return repository.findAll();
    }

    public Appointment cancel(Long id) {
        Appointment appointment = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Appointment not found"));
        appointment.setStatus(Appointment.Status.CANCELLED);
        return repository.save(appointment);
    }

    public Appointment postpone(PostponeRequest request) {
        Appointment appointment = repository.findById(request.getAppointmentId())
                .orElseThrow(() -> new IllegalArgumentException("Appointment not found"));
        appointment.setAppointmentDate(request.getNewDate());
        appointment.setStatus(Appointment.Status.SCHEDULED);
        return repository.save(appointment);
    }

    public List<Appointment> getByDateAndBranch(String dateStr, String branchName) {
        LocalDate date = LocalDate.parse(dateStr, DateTimeFormatter.ISO_DATE);
        LocalDateTime startOfDay = date.atStartOfDay();
        LocalDateTime endOfDay = date.atTime(23, 59, 59);
        return repository.findByBranchNameAndAppointmentDateBetweenAndStatus(
                branchName,
                startOfDay,
                endOfDay,
                Appointment.Status.SCHEDULED
        );
    }
}
