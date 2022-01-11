package com.paydala.common.auth.pojos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Kyc implements Serializable {

    @JsonProperty("first_name")
    @SerializedName("first_name")
    @NotNull
    private String firstName;

    @JsonProperty("mid_name")
    @SerializedName("mid_name")
    private String midName;

    @JsonProperty("last_name")
    @SerializedName("last_name")
    @NotNull
    private String lastName;

    @NotNull
    private String address;

    @NotNull
    private String city;

    @NotNull
    private String state;

    @NotNull
    private String zip;

    @NotNull
    private String dob;

    @JsonProperty("mob_no")
    @SerializedName("mob_no")
    @NotNull
    private String mobile;

    @NotNull
    private String email;

    @JsonProperty("ssn_last_four")
    @SerializedName("ssn_last_four")
    @NotNull
    private String ssnLastFour;

    @JsonProperty("qual_id")
    @SerializedName("qual_id")
    @NotNull
    private int qualId;

    @JsonProperty("qual_no")
    @SerializedName("qual_no")
    @NotNull
    private String qualNo;

    @JsonProperty("issuing_state")
    @SerializedName("issuing_state")
    @NotNull
    private String issuingState;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMidName() {
        return midName;
    }

    public void setMidName(String midName) {
        this.midName = midName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSsnLastFour() {
        return ssnLastFour;
    }

    public void setSsnLastFour(String ssnLastFour) {
        this.ssnLastFour = ssnLastFour;
    }

    public int getQualId() {
        return qualId;
    }

    public void setQualId(int qualId) {
        this.qualId = qualId;
    }

    public String getQualNo() {
        return qualNo;
    }

    public void setQualNo(String qualNo) {
        this.qualNo = qualNo;
    }

    public String getIssuingState() {
        return issuingState;
    }

    public void setIssuingState(String issuingState) {
        this.issuingState = issuingState;
    }
}
