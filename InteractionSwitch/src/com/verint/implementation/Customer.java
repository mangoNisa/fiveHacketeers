package com.verint.implementation;

/**
 * Created by scottm on 26/08/14.
 */
public class Customer {

    private int _customerId;
    private String _firstName;
    private String _surname;
    private String _preferredAddressStreet;
    private String _preferredAddressCity;
    private String _preferredAddressPostcode;
    private String _preferredAddressRegion;
    private String _preferredAddressCountry;
    private String _preferredAddressLatitude;
    private String _preferredTelephoneNo;
    private String _preferredEmail;
    private String _preferredBankAccount;
    private String _preferredCreditCardNo;
    private String _preferredCreditCardCvv;
    private String _employer;
    private String _netPromoterScore;
    private int _customerVolatilityScore;

    public String getPreferredAddressStreet() {
        return _preferredAddressStreet;
    }

    public void setPreferredAddressStreet(String preferredAddressStreet) {
        this._preferredAddressStreet = preferredAddressStreet;
    }

    public String getPreferredAddressCity() {
        return _preferredAddressCity;
    }

    public void setPreferredAddressCity(String preferredAddressCity) {
        this._preferredAddressCity = preferredAddressCity;
    }

    public String getPreferredAddressPostcode() {
        return _preferredAddressPostcode;
    }

    public void setPreferredAddressPostcode(String preferredAddressPostcode) {
        this._preferredAddressPostcode = preferredAddressPostcode;
    }

    public String getPreferredAddressRegion() {
        return _preferredAddressRegion;
    }

    public void setPreferredAddressRegion(String preferredAddressRegion) {
        this._preferredAddressRegion = preferredAddressRegion;
    }

    public String getPreferredAddressCountry() {
        return _preferredAddressCountry;
    }

    public void setPreferredAddressCountry(String preferredAddressCountry) {
        this._preferredAddressCountry = preferredAddressCountry;
    }

    public String getPreferredAddressLatitude() {
        return _preferredAddressLatitude;
    }

    public void setPreferredAddressLatitude(String preferredAddressLatitude) {
        this._preferredAddressLatitude = preferredAddressLatitude;
    }

    public String getPreferredTelephoneNo() {
        return _preferredTelephoneNo;
    }

    public void setPreferredTelephoneNo(String preferredTelephoneNo) {
        this._preferredTelephoneNo = preferredTelephoneNo;
    }

    public String getPreferredEmail() {
        return _preferredEmail;
    }

    public void setPreferredEmail(String preferredEmail) {
        this._preferredEmail = preferredEmail;
    }

    public String getPreferredBankAccount() {
        return _preferredBankAccount;
    }

    public void setPreferredBankAccount(String preferredBankAccount) {
        this._preferredBankAccount = preferredBankAccount;
    }

    public String getPreferredCreditCardNo() {
        return _preferredCreditCardNo;
    }

    public void setPreferredCreditCardNo(String preferredCreditCardNo) {
        this._preferredCreditCardNo = preferredCreditCardNo;
    }

    public String getPreferredCreditCardCvv() {
        return _preferredCreditCardCvv;
    }

    public void setPreferredCreditCardCvv(String preferredCreditCardCvv) {
        this._preferredCreditCardCvv = preferredCreditCardCvv;
    }

    public String getEmployer() {
        return _employer;
    }

    public void setEmployer(String _employer) {
        this._employer = _employer;
    }

    public String getNetPromoterScore() {
        return _netPromoterScore;
    }

    public void setNetPromoterScore(String _netPromoterScore) {
        this._netPromoterScore = _netPromoterScore;
    }

    public int getCustomerVolatilityScore() {
        return _customerVolatilityScore;
    }

    public void setCustomerVolatilityScore(int _customerVolatilityScore) {
        this._customerVolatilityScore = _customerVolatilityScore;
    }

    public void setSurname(String _surname) {
        this._surname = _surname;
    }

    public int getCustomerId() {
        return this._customerId;
    }

    public void setCustomerId(int _customerId) {
        this._customerId = _customerId;
    }

    public void setFirstName(String _firstName) {
        this._firstName = _firstName;
    }

    public String getFirstName() {
        return _firstName;
    }

    public String getSurname() {
        return _surname;
    }

    public String toString() {
        return "-x-x-x-x-x-x-x-x-x-x-\n ID : " + _customerId + "\nFirst Name : " + _firstName + ", \nSurname : " + _surname + ", \nVolatility : " + _customerVolatilityScore + "\n-x-x-x-x-x-x-x-x-x-x-";
    }
}