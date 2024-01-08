package org.csrabolivia.ehistoriasclinicasmvc.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "cie10_data")
@Getter
@Setter
@NoArgsConstructor
public class Cie10DataEntity {

    @Id
    @SequenceGenerator(
            name = "cie10_id_sequence",
            sequenceName = "cie10_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "cie10_id_sequence")
    @Column(name = "id_cie10", nullable = false)
    private Integer idCie10;

    @Column(name = "id_cie10_official", nullable = false, length = 5, unique = true)
    private String idCie10Official;

    @Column(name = "id_cie10_category", nullable = false, length = 4)
    private String idCie10Category;

    @Column(name = "cie10_description", nullable = false, length = 500)
    private String cie10Description;

    @OneToMany(mappedBy = "diagnostic")
    private Set<ConsultationDiagnosisEntity> diagnostics;

}
