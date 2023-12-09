package org.csrabolivia.ehistoriasclinicasmvc.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "surgical_background_data")
@Getter
@Setter
@NoArgsConstructor
public class SurgicalBackgroundDataEntity {

    @Id
    /*@GenericGenerator(name = "idGenerator",strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")*/
    @SequenceGenerator(
            name = "surgical_bg_id_sequence",
            sequenceName = "surgical_bg_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "surgical_bg_id_sequence")

    @Column(name = "id_surgical_bg", nullable = false)
    private Integer idSurgicalBg;

    @Column(name = "description", nullable = false, length = 150)
    private String descriptionBgDescription;

    /*@ManyToMany(mappedBy = "surgicalBackgrounds")
    private Set<PatientEntity> patients;*/

}
