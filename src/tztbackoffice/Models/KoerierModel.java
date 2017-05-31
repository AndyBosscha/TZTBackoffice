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
    private String sex;
    private String houseNumber;
    private String zipCode;
    private String streetName;
    private String phoneNumber;
    private String mailAddress;

    public String getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }
    private String bankNumber;
    
    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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
