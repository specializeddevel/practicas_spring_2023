package org.csrabolivia.ehistoriasclinicasmvc.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "family_history_data")
@Getter
@Setter
@NoArgsConstructor
public class FamilyHistoryDataEntity {

    @Id
    @SequenceGenerator(
            name = "family_history_id_sequence",
            sequenceName = "family_history_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "family_history_id_sequence")

    @Column(name = "id_family_hist", nullable = false)
    private Integer idFamilyHist;

    @Column(name = "description", nullable = false, length = 150)
    private String descriptionFamilyHist;


}
