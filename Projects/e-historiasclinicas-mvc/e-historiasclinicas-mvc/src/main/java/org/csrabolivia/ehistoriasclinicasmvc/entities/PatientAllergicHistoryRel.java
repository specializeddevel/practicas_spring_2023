package org.csrabolivia.ehistoriasclinicasmvc.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "patient_allergic_history", indexes = {@Index(name = "patient_allergic_history_index", columnList = "id_patient, id_allergic_hist", unique = true)})
@Getter
@Setter
@NoArgsConstructor
public class PatientAllergicHistoryRel {

    @Id
    @SequenceGenerator(
            name = "patient_allergic_history_id_sequence",
            sequenceName = "patient_allergic_history_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "patient_allergic_history_id_sequence")
    @Column(name = "id", nullable = false)
    private Integer id;


    @Column(name = "notes", length = 500)
    private String notes;

    @ManyToOne
    @JoinColumn(name = "id_patient", referencedColumnName = "id_patient")
    private PatientEntity patient;

    @ManyToOne
    @JoinColumn(name = "id_allergic_hist", referencedColumnName = "id_allergic_hist")
    private AllergicHistoryDataEntity allergicHistories;


}
