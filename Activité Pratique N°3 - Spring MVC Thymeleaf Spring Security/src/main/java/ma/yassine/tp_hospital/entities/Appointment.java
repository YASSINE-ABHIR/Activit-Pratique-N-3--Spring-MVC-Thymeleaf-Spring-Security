package ma.yassine.tp_hospital.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.Date;

@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString
public class Appointment {
    @Id @UuidGenerator
    private String id;
    private Date appointmentDate;
    @Enumerated(EnumType.STRING)
    private StatusAppointment status;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    private Doctor doctor;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    private Patient patient;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToOne(mappedBy = "appointment", fetch = FetchType.LAZY)
    private Consultation consultation;
}
