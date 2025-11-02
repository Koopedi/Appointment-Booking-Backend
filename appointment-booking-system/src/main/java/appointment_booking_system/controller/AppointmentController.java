package appointment_booking_system.controller;

import appointment_booking_system.dto.AppointmentRequest;
import appointment_booking_system.dto.PostponeRequest;
import appointment_booking_system.entity.Appointment;
import appointment_booking_system.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/appointments")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class AppointmentController {
    @Autowired
    AppointmentService service;


    @PostMapping
    public ResponseEntity<Appointment> createAppointment(@RequestBody AppointmentRequest request) {
        return ResponseEntity.ok(service.create(request));
    }


    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        return ResponseEntity.ok(service.getAll());
    }


    @PutMapping("/{id}/cancel")
    public ResponseEntity<Appointment> cancelAppointment(@PathVariable Long id) {
        return ResponseEntity.ok(service.cancel(id));
    }


    @PutMapping("/postpone")
    public ResponseEntity<Appointment> postponeAppointment(@RequestBody PostponeRequest request) {
        return ResponseEntity.ok(service.postpone(request));
    }

    @GetMapping("/booked")
    public ResponseEntity<List<String>> getBookedTimes(
            @RequestParam String date,
            @RequestParam String branchName
    ) {
        List<Appointment> appointments = service.getByDateAndBranch(date, branchName);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        List<String> bookedTimes = appointments.stream()
                .map(a -> a.getAppointmentDate().toLocalTime().format(formatter)) //st toLocalTime()
                .collect(Collectors.toList());

        return ResponseEntity.ok(bookedTimes);
    }
}
