package ma.yassine.tp_hospital.services;

import java.util.List;

import ma.yassine.tp_hospital.entities.Appointment;
import ma.yassine.tp_hospital.entities.Consultation;
import ma.yassine.tp_hospital.entities.Doctor;
import ma.yassine.tp_hospital.entities.Patient;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Patient patientFindById(Long id);
    List<Patient> patientFindByName(String name);
    Doctor saveDoctor(Doctor doctor);
    Doctor doctorFindById(Long id);
    List<Doctor> doctorFindByName(String name);
    Appointment saveAppointment(Appointment appointment);
    Appointment appointmentFindById(String id);
    Consultation saveConsultation(Consultation consultation);
    Consultation consultationFindById(Long id);

}
