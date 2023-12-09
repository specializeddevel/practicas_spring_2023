package org.csrabolivia.ehistoriasclinicasmvc.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "patient_medication_history", indexes = {@Index(name = "patient_medication_history_index", columnList = "id_patient, id_liname", unique = true)})
@Getter
@Setter
@NoArgsConstructor
public class PatientMedicationHistoryRel {

    @Id
    @SequenceGenerator(
            name = "patient_medication_history_id_sequence",
            sequenceName = "patient_medication_history_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "patient_medication_history_id_sequence")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "notes", length = 500)
    private String notes;

    @ManyToOne
    @JoinColumn(name = "id_patient", referencedColumnName = "id_patient")
    private PatientEntity patient;

    @ManyToOne
    @JoinColumn(name = "id_liname", referencedColumnName = "id_liname")
    private LinameDataEntity medicationHistories;

}
