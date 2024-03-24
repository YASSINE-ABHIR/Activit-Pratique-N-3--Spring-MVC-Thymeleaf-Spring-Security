package ma.yassine.tp_hospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.yassine.tp_hospital.entities.Patient;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    List<Patient> findByName(String name);
}
