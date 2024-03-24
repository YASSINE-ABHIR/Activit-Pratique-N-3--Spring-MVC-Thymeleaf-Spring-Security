package ma.yassine.tp_hospital;

import ma.yassine.tp_hospital.entities.*;
import ma.yassine.tp_hospital.services.IHospitalService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Calendar;
import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class TpHospitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(TpHospitalApplication.class, args);
    }

    @Bean
    CommandLineRunner start(IHospitalService hospitalService) {
        return args -> {
            Stream.of("Khalid","Najate","Amine","Nouhaila")
                    .forEach(name -> {
                        Patient patient = new Patient();
                        patient.setName(name);
                        patient.setSick(Math.random() > 0.5);
                        patient.setBirthDay(new Date(1994-1900, Calendar.MARCH,15));
                        hospitalService.savePatient(patient);
                    });

            Stream.of("Ahmed","Mamoune","Asmae","Hind")
                    .forEach(name -> {
                        Doctor doctor = new Doctor();
                        doctor.setName(name);
                        doctor.setEmail(name + "@hospital.org");
                        doctor.setSpeciality(Math.random() > 0.5 ? "Dentist" : "Cardiologist");
                        hospitalService.saveDoctor(doctor);
                    });

            Appointment appointment = new Appointment();
            appointment.setAppointmentDate(new Date(2024-1900,Calendar.APRIL,23,10,30));
            appointment.setStatus(StatusAppointment.PENDING);
            appointment.setPatient(hospitalService.patientFindById(2L));
            appointment.setDoctor(hospitalService.doctorFindByName("Hind").getFirst());
            Appointment savedAppointment = hospitalService.saveAppointment(appointment);
            System.out.println("The appointment id: " + savedAppointment.getId());

            Consultation consultation = new Consultation();
            consultation.setAppointment(savedAppointment);
            consultation.setConsultationDate(new Date(2024-1900,Calendar.APRIL,23,11,0));
            consultation.setDoctor(hospitalService.doctorFindByName("Hind").getFirst());
            consultation.setPatient(hospitalService.patientFindById(2L));
            consultation.setReport("Everything is ok.");
            hospitalService.saveConsultation(consultation);
        };


    }

}
