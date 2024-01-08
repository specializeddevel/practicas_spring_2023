package org.csrabolivia.ehistoriasclinicasmvc.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "consultation")
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


    @Column(name = "consultation_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date consultationDate;

    @Column(name = "consultation_time", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date consultationTime;

    @Column(name = "consultation_cause", nullable = false, length = 500)
    private String consultationCause;

    @Column(name = "actual_disease_history", nullable = false, length = 500)
    private String actualDiseaseHistory;

    @ManyToOne
    @JoinColumn(name = "id_patient", referencedColumnName = "id_patient", insertable = false, updatable = false)
    private PatientEntity patient;

    @OneToMany(mappedBy = "idDiagnosis")
    private Set<ConsultationDiagnosisEntity> diagnostics;

    @OneToOne(mappedBy = "consultation")
    private ConsultationComplementaryTestsEntity complementaryTest;

    @OneToOne(mappedBy = "consultation")
    private ConsultationGeneralPhysicalExaminationEntity generalPhysicalExamination;

}
