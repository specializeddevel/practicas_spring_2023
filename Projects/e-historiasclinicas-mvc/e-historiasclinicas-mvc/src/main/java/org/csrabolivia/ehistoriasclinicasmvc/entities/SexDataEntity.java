package org.csrabolivia.ehistoriasclinicasmvc.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "sex")
@Getter
@Setter
@NoArgsConstructor
public class SexDataEntity {

    @Id
    @SequenceGenerator(
            name = "sex_id_sequence",
            sequenceName = "sex_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "sex_id_sequence")

    @Column(name = "id_sex", nullable = false)
    private Integer idSex;

    @Column(name = "description", nullable = false, length = 150)
    private String descriptionSex;

    @OneToMany(mappedBy = "sexData")
    private Set<PatientEntity> patient;
}
