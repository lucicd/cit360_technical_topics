/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit360.drazen.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author aed20672
 */
@Entity
@Table(name = "customers")
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "first_name")
    private String firstName;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "last_name")
    private String lastName;
    
// @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "phone")
    private String phone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "mobile")
    private String mobile;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "email")
    private String email;
    @Size(max = 255)
    @Column(name = "street")
    private String street;
    @Size(max = 255)
    @Column(name = "city")
    private String city;
    @Size(max = 2)
    @Column(name = "state_code")
    private String stateCode;
    @Column(name = "zip_code")
    private Integer zipCode;

    public Customer() {
    }

    public Customer(Integer id) {
        this.id = id;
    }

    public Customer(Integer id, String firstName, String lastName, String mobile, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.email = email;
    }

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
        this.firstName = Helpers.nullWhenEmpty(firstName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = Helpers.nullWhenEmpty(lastName);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = Helpers.nullWhenEmpty(phone);
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = Helpers.nullWhenEmpty(mobile);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null) email = email.toLowerCase();
        this.email = Helpers.nullWhenEmpty(email);
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = Helpers.nullWhenEmpty(street);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = Helpers.nullWhenEmpty(city);
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        if (stateCode != null) stateCode = stateCode.toUpperCase();
        this.stateCode = Helpers.nullWhenEmpty(stateCode);
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone + ", mobile=" + mobile + ", email=" + email + ", street=" + street + ", city=" + city + ", stateCode=" + stateCode + ", zipCode=" + zipCode + '}';
    }
}
