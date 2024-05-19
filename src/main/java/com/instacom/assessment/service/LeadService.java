package com.instacom.assessment.service;

import com.instacom.assessment.model.Leads;

import java.util.List;

public interface LeadService {
    //We get All Leads in the System
    List<Leads> getAllLeads();
    //We can get Leads created by specific user
    List<Leads> getUserLeads(String username);
    void saveLead(Leads lead);
    Leads getLeadById(long id);
    void deleteLeadById(long id);
    public List<String> findUniqueDates();
    String getUserName();
}
