package domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -5037328775785059700L;
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private Credentials credentials;
    private String address;
    private String phoneNumber;

    public Customer() {
    }

    public Customer(int id, String firstname, String lastname, String email, String address, String phoneNumber,
	    Credentials credentials) {
	this.id = id;
	this.firstname = firstname;
	this.lastname = lastname;
	this.email = email;
	this.address = address;
	this.phoneNumber = phoneNumber;
	this.credentials = credentials;
    }

    @JsonProperty
    public int getId() {

	return id;
    }

    public void setId(int id) {

	this.id = id;
    }

    @JsonProperty
    public String getFirstname() {

	return firstname;
    }

    public void setFirstname(String firstname) {

	this.firstname = firstname;
    }

    @JsonProperty
    public String getLastname() {

	return lastname;
    }

    public void setLastname(String lastname) {

	this.lastname = lastname;
    }

    @JsonProperty
    public String getEmail() {

	return email;
    }

    public void setEmail(String email) {

	this.email = email;
    }

    @JsonProperty
    public String getAddress() {

	return address;
    }

    public void setAddress(String address) {

	this.address = address;
    }

    @JsonProperty
    public String getPhoneNumber() {

	return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {

	this.phoneNumber = phoneNumber;
    }

    public Credentials getCredentials() {

	return credentials;
    }

    public void setCredentials(Credentials credentials) {

	this.credentials = credentials;
    }
}