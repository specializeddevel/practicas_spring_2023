package org.csrabolivia.ehistoriasclinicasmvc.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "non_pathological_history_data")
@Getter
@Setter
@NoArgsConstructor
public class NonPathologicHistoryDataEntity {

    @Id
    @SequenceGenerator(
            name = "non_pathologic_hist_id_sequence",
            sequenceName = "non_pathologic_hist_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "non_pathologic_hist_id_sequence")

    @Column(name = "id_non_pathologic_hist", nullable = false)
    private Integer idPathologicHist;

    @Column(name = "description", nullable = false, length = 150)
    private String descriptionPathologicHist;


}
