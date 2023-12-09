package org.csrabolivia.ehistoriasclinicasmvc.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "patiend_obstetric_ginecologic_history")
@Getter
@Setter
@NoArgsConstructor
public class PatientObstetricAndGinecologicHistoryEntity {

    @Id
    @SequenceGenerator(
            name = "patiend_obstetric_ginecologic_history_id_sequence",
            sequenceName = "patiend_obstetric_ginecologic_history_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "patiend_obstetric_ginecologic_history_id_sequence")
    @Column(name = "id_ginecoobstetric", nullable = false)
    private Integer idGinecoObstetric;

    @Column(name = "age_of_menarche", columnDefinition = "SMALLINT")
    private Integer ageOfMenarche;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_last_menstrual_period")
    private Date dateOfLastMenstrualPeriod;

    @Column(name = "menstrual_cycle_length", columnDefinition = "SMALLINT")
    private Integer menstrualCycleLength;

    @Column(name = "number_of_pregnancies", columnDefinition = "SMALLINT", nullable = false)
    private Integer numberOfPregnancies;

    //numero de partos incluyendo los prematuros
    @Column(name = "deliveries", columnDefinition = "SMALLINT", nullable = false)
    private Integer deliveries;

    @Column(name = "cesarean_delivery_count", columnDefinition = "SMALLINT", nullable = false)
    private Integer cesareanDeliveryCount;

    @Column(name = "abortion_count", columnDefinition = "SMALLINT", nullable = false)
    private Integer abortionCount;

    @Temporal(TemporalType.DATE)
    @Column(name = "last_delivery_date")
    private Date lastDeliveryDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "last_pap_date")
    private Date lastPapDate;



}
