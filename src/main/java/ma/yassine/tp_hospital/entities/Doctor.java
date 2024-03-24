package ma.yassine.tp_hospital.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString
public class Doctor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String speciality;
    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)
    private Collection<Appointment> appointments;
}
