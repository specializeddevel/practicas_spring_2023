package org.csrabolivia.ehistoriasclinicasmvc.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pathologic_history_data")
@Getter
@Setter
@NoArgsConstructor
public class PathologicHistoryDataEntity {

    @Id
    @SequenceGenerator(
            name = "pathologic_hist_id_sequence",
            sequenceName = "pathologic_hist_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "pathologic_hist_id_sequence")

    @Column(name = "id_pathologic_hist", nullable = false)
    private Integer idPathologicHist;

    @Column(name = "description", nullable = false, length = 150)
    private String descriptionPathologicHist;


}
