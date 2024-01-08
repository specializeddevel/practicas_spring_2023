package org.csrabolivia.ehistoriasclinicasmvc.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "consultation_diagnosis")
@Getter
@Setter
@NoArgsConstructor
public class ConsultationDiagnosisEntity {

    @Id
    @SequenceGenerator(
            name = "diagnosis_id_sequence",
            sequenceName = "diagnosis_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "diagnosis_id_sequence")
    @Column(name = "id_diagnosis", nullable = false)
    private Integer idDiagnosis;

    @Column(name = "id_consultation", nullable = false)
    private Integer idConsultation;

    @Column(name = "id_cie10", nullable = false)
    private Integer idCie10;

    @Column(name = "medical_diagnosis", length = 2000, nullable = false)
    private String medicalDiagnosis;

    @Column(name = "diagnosis_notes", length = 1000, nullable = false)
    private String diagnosisNotes;

    @ManyToOne
    @JoinColumn(name = "id_consultation", referencedColumnName = "id_consultation", insertable = false, updatable = false)
    private ConsultationEntity consultationData;

    @ManyToOne()
    @JoinColumn(name = "id_cie10", referencedColumnName = "id_cie10", insertable = false, updatable = false)
    private Cie10DataEntity diagnostic;

}
