package ma.yassine.tp_hospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.yassine.tp_hospital.entities.Doctor;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    List<Doctor> findByName(String name);
}
