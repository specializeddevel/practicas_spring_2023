package org.csrabolivia.ehistoriasclinicasmvc.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "patient_pathologic_history", indexes = {@Index(name = "patient_pathological_history_index", columnList = "id_patient, id_pathologic_hist", unique = true)})
@Getter
@Setter
@NoArgsConstructor
public class PatientPathologicHistoryRel {

    @Id
    @SequenceGenerator(
            name = "patient_pathologic_history_id_sequence",
            sequenceName = "patient_pathologic_history_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "patient_pathologic_history_id_sequence")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "notes", length = 150)
    private String notes;

    @ManyToOne
    @JoinColumn(name = "id_patient", referencedColumnName = "id_patient")
    private PatientEntity patient;

    @ManyToOne
    @JoinColumn(name = "id_pathologic_hist", referencedColumnName = "id_pathologic_hist")
    private PathologicHistoryDataEntity pathologicHistories;

}
