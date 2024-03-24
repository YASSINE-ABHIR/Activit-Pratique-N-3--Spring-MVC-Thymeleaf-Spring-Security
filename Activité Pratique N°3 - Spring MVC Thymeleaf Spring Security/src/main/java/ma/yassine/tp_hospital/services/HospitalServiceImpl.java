package ma.yassine.tp_hospital.services;

import jakarta.transaction.Transactional;
import ma.yassine.tp_hospital.entities.Appointment;
import ma.yassine.tp_hospital.entities.Consultation;
import ma.yassine.tp_hospital.entities.Doctor;
import ma.yassine.tp_hospital.entities.Patient;
import ma.yassine.tp_hospital.repositories.AppointmentRepository;
import ma.yassine.tp_hospital.repositories.ConsultationRepository;
import ma.yassine.tp_hospital.repositories.DoctorRepository;
import ma.yassine.tp_hospital.repositories.PatientRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {

    private final PatientRepository patientRepository;
    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final ConsultationRepository consultationRepository;

    public HospitalServiceImpl(
            PatientRepository patientRepository,
            AppointmentRepository appointmentRepository,
            DoctorRepository doctorRepository,
            ConsultationRepository consultationRepository
    ) {
        this.patientRepository = patientRepository;
        this.appointmentRepository = appointmentRepository;
        this.doctorRepository = doctorRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient patientFindById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    @Override
    public List<Patient> patientFindByName(String name) {
        return patientRepository.findByName(name);
    }

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor doctorFindById(Long id) {
        return doctorRepository.findById(id).orElse(null);
    }

    @Override
    public List<Doctor> doctorFindByName(String name) {
        return doctorRepository.findByName(name);
    }

    @Override
    public Appointment saveAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment appointmentFindById(String id) {
        return appointmentRepository.findById(id).orElse(null);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    @Override
    public Consultation consultationFindById(Long id) {
        return consultationRepository.findById(id).orElse(null);
    }
}
