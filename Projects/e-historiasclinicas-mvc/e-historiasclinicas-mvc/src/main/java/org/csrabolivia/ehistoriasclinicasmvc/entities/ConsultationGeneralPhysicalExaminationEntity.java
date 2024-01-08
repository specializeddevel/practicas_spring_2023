package org.csrabolivia.ehistoriasclinicasmvc.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "consultation_general_physycal_examination")
@Getter
@Setter
@NoArgsConstructor
public class ConsultationGeneralPhysicalExaminationEntity {

    @Id
    @SequenceGenerator(
            name = "consultation_gen_phyexam_id_sequence",
            sequenceName = "consultation_gen_phyexam_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "consultation_gen_phyexam_id_sequence")
    @Column(name = "id_gen_physycal_exam", nullable = false)
    private Integer idGenPhysycalExam;

    @Column(name = "id_consultation", nullable = false, unique = true)
    private Integer idConsultation;

    @Column(name = "cardiac_frequency")
    private Integer cardiacFrequency;

    @Column(name = "respiration_rate")
    private Integer respirationRate;

    @Column(name = "body_temperature", columnDefinition = "DOUBLE(3,1)")
    private Double bodyTemperature;

    @Column(name = "blood_pressure", length = 10)
    private String bloodPressure;

    @Column(name = "bood_oxygen_saturation")
    private Integer bloodOxygenSaturation;

    @Column(name = "weight", columnDefinition = "DOUBLE(4,2)")
    private Double weight;

    @Column(name = "height", columnDefinition = "DOUBLE(4,2)")
    private Double height;

    @OneToOne
    @JoinColumn(name = "id_consultation", referencedColumnName = "id_consultation", updatable = false, insertable = false)
    private ConsultationEntity consultation;


}
