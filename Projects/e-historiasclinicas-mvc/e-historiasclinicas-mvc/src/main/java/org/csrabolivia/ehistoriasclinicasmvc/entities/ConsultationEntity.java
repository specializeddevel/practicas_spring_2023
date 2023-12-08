package org.csrabolivia.ehistoriasclinicasmvc.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "consultation")
@IdClass(ConsultationEntityId.class)
@Getter
@Setter
@NoArgsConstructor
public class ConsultationEntity {
    @Id
    @SequenceGenerator(
            name = "consultation_id_sequence",
            sequenceName = "consultation_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "consultation_id_sequence")
    @Column(name = "id_consultation", nullable = false)
    private Integer idConsultation;

    @Id
    @Column(name = "id_patient", nullable = false)
    private Integer idPatient;

    @Column(name = "consultation_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date consultationDate;

    @Column(name = "consultation_time", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date consultationTime;

    @Column(name = "consultation_cause", nullable = false, length = 500)
    private String consultationCause;

    @Column(name = "actual_disease_story", nullable = false, length = 500)
    private String actualDiseaseStory;

    @ManyToOne
    @JoinColumn(name = "id_patient", referencedColumnName = "id_patient", insertable = false, updatable = false)
    private PatientEntity patient;



}
