package com.sliansoft.slianOA.dataaccess.model;

import java.math.BigDecimal;

public class OaCustomerAddressList {
    private Integer addressListId;

    private String customerName;

    private String corporateName;

    private String post;

    private String mobileNumber;

    private String telNumber;

    private String email;

    private String address;

    private BigDecimal test;

    public Integer getAddressListId() {
        return addressListId;
    }

    public void setAddressListId(Integer addressListId) {
        this.addressListId = addressListId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public String getCorporateName() {
        return corporateName;
    }

    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName == null ? null : corporateName.trim();
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post == null ? null : post.trim();
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber == null ? null : mobileNumber.trim();
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber == null ? null : telNumber.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public BigDecimal getTest() {
        return test;
    }

    public void setTest(BigDecimal test) {
        this.test = test;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        OaCustomerAddressList other = (OaCustomerAddressList) that;
        return (this.getAddressListId() == null ? other.getAddressListId() == null : this.getAddressListId().equals(other.getAddressListId()))
            && (this.getCustomerName() == null ? other.getCustomerName() == null : this.getCustomerName().equals(other.getCustomerName()))
            && (this.getCorporateName() == null ? other.getCorporateName() == null : this.getCorporateName().equals(other.getCorporateName()))
            && (this.getPost() == null ? other.getPost() == null : this.getPost().equals(other.getPost()))
            && (this.getMobileNumber() == null ? other.getMobileNumber() == null : this.getMobileNumber().equals(other.getMobileNumber()))
            && (this.getTelNumber() == null ? other.getTelNumber() == null : this.getTelNumber().equals(other.getTelNumber()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getTest() == null ? other.getTest() == null : this.getTest().equals(other.getTest()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAddressListId() == null) ? 0 : getAddressListId().hashCode());
        result = prime * result + ((getCustomerName() == null) ? 0 : getCustomerName().hashCode());
        result = prime * result + ((getCorporateName() == null) ? 0 : getCorporateName().hashCode());
        result = prime * result + ((getPost() == null) ? 0 : getPost().hashCode());
        result = prime * result + ((getMobileNumber() == null) ? 0 : getMobileNumber().hashCode());
        result = prime * result + ((getTelNumber() == null) ? 0 : getTelNumber().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getTest() == null) ? 0 : getTest().hashCode());
        return result;
    }
}