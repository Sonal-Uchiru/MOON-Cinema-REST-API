package com.github.vlsidlyarevich.dto;

import java.io.Serializable;


public class UserDTO implements Serializable {

    private static final long serialVersionUID = 91901774547107674L;

    private String username;
    private String password;
    private String firstName;


    private String lastName;
    private String email;
    private String gender;
    private String nic;
    private String mobilePhoneNumber;
    private String address;
    private String role;
    
    public UserDTO() {
    }

    public String getRole() {
    	return role;
    }
    
    public void setRole(String role) {
    	this.role = role; 
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getMobileNumber() {
        return this.mobilePhoneNumber;
    }
}
