package org.csrabolivia.ehistoriasclinicasmvc.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "liname_data")
@Getter
@Setter
@NoArgsConstructor
public class LinameDataEntity {

    @Id
    @SequenceGenerator(
            name = "liname_id_sequence",
            sequenceName = "liname_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "liname_id_sequence")

    @Column(name = "id_liname", nullable = false)
    private Integer idPathologicHist;

    @Column(name = "liname_code", nullable = false, unique = true, length = 5)
    private String linameCode;

    @Column(name = "medicine_name", nullable = false, length = 300)
    private String medicineName;

    @Column(name = "pharmaceutical_form", nullable = false, length = 150)
    private String pharmaceutical_form;

    @Column(name = "drug_concentration", nullable = false, length = 150)
    private String drugConcentration;

    @Column(name = "atq_clasification", nullable = false, length = 10)
    private String atqClasification;

    @Column(name = "active", columnDefinition = "TINYINT")
    private Boolean active;

    @Column(columnDefinition = "TINYINT")
    private Boolean isPartOfLiname;

    @Column(name = "notes", nullable = false, length = 500)
    private String notes;

    @OneToMany(mappedBy = "medicationHistories")
    private Set<PatientMedicationHistoryRel> medicationHistoriesData;

}
