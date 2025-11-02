# Appointment Booking System - Backend

A Spring Boot backend for the Appointment Booking System, using **Java 17** and **H2 in-memory database** for development.

---

## Features

* Create new appointments
* View all appointments
* Cancel appointments
* Postpone appointments
* REST API endpoints

---

## Project Structure

```
backend/
├── src/main/java
│   └── appointment_booking_system/
│       ├── controller
│       ├── dto
│       ├── entity
│       └── service
├── src/main/resources
│   └── application.properties
└── pom.xml
```

---

## Requirements

* Java 17
* Maven

---

## Run Backend Locally

```bash
cd backend
./mvnw clean package
java -jar target/appointment-booking-system-0.0.1-SNAPSHOT.jar
```

* The backend runs on **[http://localhost:8080](http://localhost:8080)**

---

## API Endpoints

| Method | Endpoint                      | Description              |
| ------ | ----------------------------- | ------------------------ |
| GET    | /api/appointments             | Get all appointments     |
| POST   | /api/appointments             | Create a new appointment |
| PUT    | /api/appointments/{id}/cancel | Cancel an appointment    |
| PUT    | /api/appointments/postpone    | Postpone an appointment  |

---

## Notes

* Uses H2 in-memory database for development
* Lombok is used to reduce boilerplate code
* No Docker required
* Pure CLI-based setup
