package org.csra.historiaClinica.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.Date;

@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String firstName;
    private String middleName;
    private String lastName;
    private Integer dni;
    private Integer cellPhoneNumber;
    private Date dob;
    private String Occupation;
    private String city;
    private String Zone;
    private String NeighborhoodName;
    private String StreetName;
    private String homeMoreSpecifications;
    private String contactName;
    private Integer contactNameCellphone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public Integer getCellPhoneNumber() {
        return cellPhoneNumber;
    }

    public void setCellPhoneNumber(Integer cellPhoneNumber) {
        this.cellPhoneNumber = cellPhoneNumber;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getOccupation() {
        return Occupation;
    }

    public void setOccupation(String occupation) {
        Occupation = occupation;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZone() {
        return Zone;
    }

    public void setZone(String zone) {
        Zone = zone;
    }

    public String getNeighborhoodName() {
        return NeighborhoodName;
    }

    public void setNeighborhoodName(String neighborhoodName) {
        NeighborhoodName = neighborhoodName;
    }

    public String getStreetName() {
        return StreetName;
    }

    public void setStreetName(String streetName) {
        StreetName = streetName;
    }

    public String getHomeMoreSpecifications() {
        return homeMoreSpecifications;
    }

    public void setHomeMoreSpecifications(String homeMoreSpecifications) {
        this.homeMoreSpecifications = homeMoreSpecifications;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public Integer getContactNameCellphone() {
        return contactNameCellphone;
    }

    public void setContactNameCellphone(Integer contactNameCellphone) {
        this.contactNameCellphone = contactNameCellphone;
    }
}
