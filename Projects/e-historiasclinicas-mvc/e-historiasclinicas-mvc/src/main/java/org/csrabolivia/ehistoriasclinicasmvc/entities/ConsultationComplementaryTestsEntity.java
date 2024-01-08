package org.csrabolivia.ehistoriasclinicasmvc.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "consultation_complementary_test")
@Getter
@Setter
@NoArgsConstructor
public class ConsultationComplementaryTestsEntity {

    @Id
    @SequenceGenerator(
            name = "consultation_complementary_test_id_sequence",
            sequenceName = "consultation_complementary_test_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "consultation_complementary_test_id_sequence")
    @Column(name = "id_complementary_test", nullable = false)
    private Integer idComplementaryTest;

    @Column(name="id_consultation", nullable = false, unique = true)
    private Integer idConsultation;

    @Column(name = "description", nullable = false, length = 1000)
    private String description;

    @Column(name = "notes", length = 1000)
    private String notes;

    @OneToOne()
    @JoinColumn(name = "id_consultation", referencedColumnName = "id_consultation", updatable = false, insertable = false)
    private ConsultationEntity consultation;

}
