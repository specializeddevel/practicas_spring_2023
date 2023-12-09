package org.csrabolivia.ehistoriasclinicasmvc.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "allergic_history_data")
@Getter
@Setter
@NoArgsConstructor
public class AllergicHistoryDataEntity {

    @Id
    @SequenceGenerator(
            name = "allergic_history_id_sequence",
            sequenceName = "allergic_history_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "allergic_history_id_sequence")

    @Column(name = "id_allergic_hist", nullable = false)
    private Integer idAllergicHist;

    @Column(name = "description", nullable = false, length = 150)
    private String descriptionAllergicHist;

}
