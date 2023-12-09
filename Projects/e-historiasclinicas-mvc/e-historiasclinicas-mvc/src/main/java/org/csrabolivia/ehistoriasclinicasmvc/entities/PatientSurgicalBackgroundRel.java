package org.csrabolivia.ehistoriasclinicasmvc.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "patient_surgical_background", indexes = {@Index(name = "patient_surgical_background_index", columnList = "id_patient, id_surgical_bg", unique = true)})
@Getter
@Setter
@NoArgsConstructor
public class PatientSurgicalBackgroundRel {

    @Id
    @SequenceGenerator(
            name = "patient_surgical_background_id_sequence",
            sequenceName = "patient_surgical_background_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "patient_surgical_background_id_sequence")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "notes", length = 150)
    private String notes;

    @ManyToOne
    @JoinColumn(name = "id_patient", referencedColumnName = "id_patient")
    private PatientEntity patient;

    @ManyToOne
    @JoinColumn(name = "id_surgical_bg", referencedColumnName = "id_surgical_bg")
    private SurgicalBackgroundDataEntity surgicalBackgrounds;

}
