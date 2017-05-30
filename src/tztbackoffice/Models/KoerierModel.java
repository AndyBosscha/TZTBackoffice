/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tztbackoffice.Models;

/**
 *
 * @author Andy
 */
public class KoerierModel {
    private String firstName;
    private String middleName;
    private String lastName;
    private String status;
    private String city;
    private int idUser;
    private String dateOfBirth;
    private String startDate;
    private int amountOfAcceptedPackages;
    private int amountOfDeliveredPackages;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public int getAmountOfAcceptedPackages() {
        return amountOfAcceptedPackages;
    }

    public void setAmountOfAcceptedPackages(int amountOfAcceptedPackages) {
        this.amountOfAcceptedPackages = amountOfAcceptedPackages;
    }

    public int getAmountOfDeliveredPackages() {
        return amountOfDeliveredPackages;
    }

    public void setAmountOfDeliveredPackages(int amountOfDeliveredPackages) {
        this.amountOfDeliveredPackages = amountOfDeliveredPackages;
    }
    
}
