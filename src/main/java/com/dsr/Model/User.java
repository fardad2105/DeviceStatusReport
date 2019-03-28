package com.dsr.Model;

import javax.persistence.*;

@Entity
@Table(name = "users" )
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "enabled")
    private Boolean Enabled;
    private String firstname;
    private Boolean isCompanyAdmin;
    private Boolean isSystemAdmin;


    public User() {
    }

    public User(String username, String password, String firstname, Boolean enabled, Boolean isCompanyAdmin, Boolean isSystemAdmin) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        Enabled = enabled;
        this.isCompanyAdmin = isCompanyAdmin;
        this.isSystemAdmin = isSystemAdmin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Boolean getEnabled() {
        return Enabled;
    }

    public void setEnabled(Boolean enabled) {
        Enabled = enabled;
    }

    public Boolean getCompanyAdmin() {
        return isCompanyAdmin;
    }

    public void setCompanyAdmin(Boolean companyAdmin) {
        isCompanyAdmin = companyAdmin;
    }

    public Boolean getSystemAdmin() {
        return isSystemAdmin;
    }

    public void setSystemAdmin(Boolean systemAdmin) {
        isSystemAdmin = systemAdmin;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstname='" + firstname + '\'' +
                ", Enabled=" + Enabled +
                ", isCompanyAdmin=" + isCompanyAdmin +
                ", isSystemAdmin=" + isSystemAdmin +
                '}';
    }
}
