package ma.yassine.tp_hospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.yassine.tp_hospital.entities.Consultation;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}
