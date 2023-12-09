package org.csrabolivia.ehistoriasclinicasmvc.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "patient")
@Getter
@Setter
@NoArgsConstructor
public class PatientEntity {

    @Id
    @SequenceGenerator(
            name = "patient_id_sequence",
            sequenceName = "patient_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "patient_id_sequence")
    @Column(name = "id_patient", nullable = false)
    private Integer idPatient;
    @Column(name = "names", nullable = false, length = 50)
    private String name;
    @Column(name = "father_surname", nullable = false, length = 50)
    private String fatherSurname;
    @Column(name = "mother_surname", nullable = false, length = 50)
    private String motherSurname;
    @Column(name = "dni", nullable = false, unique = true, length = 10)
    private String dni;

    @Column(name = "cell_phone_number", length = 10)
    private String cellPhoneNumber;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;

    @Column(name = "city_of_residence", length = 50, nullable = false)
    private String cityOfResidence;

    @Column(name = "zone_of_residence", length = 50, nullable = false)
    private String zoneOfResidence;

    @Column(name = "neighborhood_of_residence", length = 50)
    private String neighborhoodOfResidence;

    @Column(name = "street_name_number", length = 70)
    private String streetNameAndNumber;

    @Column(name = "residence_more_details", length = 200)
    private String residenceMoreDetails;

    @Column(name = "contact_full_name", length = 150)
    private String contactFullName;

    @Column(name = "contact_cellphone_number", length = 10)
    private String contactCellphoneNumber;

    @Column(name = "occupation", length = 50)
    private String occupation;

    @Column(name = "aditional_notes", length = 250)
    private String aditionalNotes;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "registration_date", nullable = false)
    private Date registrationDate;

    @Column(columnDefinition = "TINYINT")
    private Boolean deleted;

    @OneToMany(mappedBy = "patient")
    private Set<ConsultationEntity> consultations;


}
