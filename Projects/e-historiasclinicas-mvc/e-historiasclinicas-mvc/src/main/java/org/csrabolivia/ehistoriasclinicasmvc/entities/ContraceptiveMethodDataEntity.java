package org.csrabolivia.ehistoriasclinicasmvc.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "contraceptive_method_data")
@Getter
@Setter
@NoArgsConstructor
public class ContraceptiveMethodDataEntity {

    @Id
    @SequenceGenerator(
            name = "contraceptive_method_id_sequence",
            sequenceName = "contraceptive_method_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "contraceptive_method_id_sequence")
    @Column(name = "id_contraceptive_method", nullable = false, columnDefinition = "SMALLINT")
    private Integer idContraceptiveMethod;

    @Column(name = "description", nullable = false, length = 150)
    private String descriptionContraceptiveMethod;

    @OneToMany(mappedBy = "contraceptiveMethod")
    private Set<PatientObstetricAndGinecologicHistoryEntity> patientObstetricAndGinecologicData;
}
