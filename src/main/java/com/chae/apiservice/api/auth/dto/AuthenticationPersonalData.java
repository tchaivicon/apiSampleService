package com.chae.apiservice.api.auth.dto;

public class AuthenticationPersonalData {
    private final String ci;
    private final String name;
    private final String phone;
    private final String birthday;
    private final String gender;
    private final String nationality;
    private final String ci2;
    private final String di;
    private final String ciUpdate;
    private final String address;
    private final String addressDetails;
    private final String zipCode;
    private final String email;

    public AuthenticationPersonalData(String ci, String name, String phone, String birthday, String gender, String nationality, String ci2, String di, String ciUpdate, String address, String addressDetails, String zipCode, String email) {
        this.ci = ci;
        this.name = name;
        this.phone = phone;
        this.birthday = birthday;
        this.gender = gender;
        this.nationality = nationality;
        this.ci2 = ci2;
        this.di = di;
        this.ciUpdate = ciUpdate;
        this.address = address;
        this.addressDetails = addressDetails;
        this.zipCode = zipCode;
        this.email = email;
    }

    public String getCi() {
        return ci;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getGender() {
        return gender;
    }

    public String getNationality() {
        return nationality;
    }

    public String getCi2() {
        return ci2;
    }

    public String getDi() {
        return di;
    }

    public String getCiUpdate() {
        return ciUpdate;
    }

    public String getAddress() {
        return address;
    }

    public String getAddressDetails() {
        return addressDetails;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getEmail() {
        return email;
    }
}
