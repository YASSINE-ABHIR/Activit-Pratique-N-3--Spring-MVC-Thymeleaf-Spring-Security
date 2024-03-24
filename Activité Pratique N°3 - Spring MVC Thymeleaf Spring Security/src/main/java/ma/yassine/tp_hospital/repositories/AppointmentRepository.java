package ma.yassine.tp_hospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.yassine.tp_hospital.entities.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment,String> {
}
