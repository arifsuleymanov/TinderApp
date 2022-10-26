package com.entity;

import org.joda.time.Days;
import org.joda.time.LocalDate;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "workspace")
    private String workspace;

    @Column(name = "last_login_date")
    private Date last_login_date;

    @Column(name = "surname")
    private String surname;

    @Column(name = "profile_link")
    private String profile_link;


    public Profile(int id, String name, String surname,String profile_link, String workspace, Date last_login_date) {
        this.id = id;
        this.name = name;
        this.workspace = workspace;
        this.last_login_date = last_login_date;
        this.surname = surname;
        this.profile_link = profile_link;
    }

    public Profile() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String fullName) {
        this.name = fullName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String password) {
        this.surname = password;
    }

    public String getProfile_link() {
        return profile_link;
    }

    public void setProfile_link(String profile_link) {
        this.profile_link = profile_link;
    }

    public String getWorkspace() {
        return workspace;
    }

    public void setWorkspace(String workspace) {
        this.workspace = workspace;
    }

    public Date getLast_login_date() {
        return last_login_date;
    }

    public void setLast_login_date(Date last_login_date) {
        this.last_login_date = last_login_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return Objects.equals(id, profile.id);
    }

    @Override
    public int hashCode() {
        long result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return (int) result;
    }

    public Days dateDiff(){
        LocalDate lastServiceLocalDate = LocalDate.fromDateFields(last_login_date);
        return Days.daysBetween(lastServiceLocalDate,org.joda.time.LocalDate.now());
    }

}
