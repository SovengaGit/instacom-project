package com.instacom.assessment.model;
/*
* leads entity mirrors the database table LEAD with column structrure below*/
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "leads")
public class Leads {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "lead_source")
    private String lead_source;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "phone_number")
    private String phone_number;

    //The company name of the lead (if applicable)
    @Column(name = "company")
    private String company;
    //The job title or position of the lead within their company.
    @Column(name = "job_title")
    private String job_title;
    //Indicates the current status of the lead in the sales process (e.g., new, contacted, qualified, closed).
    @Column(name = "lead_status")
    private String lead_status;
    //The salesperson or team responsible for managing the lead.
    @Column(name = "lead_owner")
    private String lead_owner;
    @Column(name = "created_at")
    private String created_at;
    @Column(name = "updated_at")
    private Date updated_at;
    @Column(name = "username")
    private String username;

    public Leads() {
    }

    public Leads(long id, String lead_source, String firstName, String lastName, String emailId, String phone_number, String company, String job_title, String lead_status, String lead_owner, String created_at, Date updated_at, String username) {
        this.id = id;
        this.lead_source = lead_source;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.phone_number = phone_number;
        this.company = company;
        this.job_title = job_title;
        this.lead_status = lead_status;
        this.lead_owner = lead_owner;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLead_source() {
        return lead_source;
    }

    public void setLead_source(String lead_source) {
        this.lead_source = lead_source;
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

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public String getLead_status() {
        return lead_status;
    }

    public void setLead_status(String lead_status) {
        this.lead_status = lead_status;
    }

    public String getLead_owner() {
        return lead_owner;
    }

    public void setLead_owner(String lead_owner) {
        this.lead_owner = lead_owner;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
}
