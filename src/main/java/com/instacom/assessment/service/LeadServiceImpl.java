package com.instacom.assessment.service;

import com.instacom.assessment.model.Leads;
import com.instacom.assessment.repository.LeadsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class LeadServiceImpl implements LeadService {
    @Autowired
    LeadsRepository leadsRepository;
    @Override
    public List<Leads> getAllLeads() {
        return leadsRepository.findAll();
    }

    @Override
    public List<Leads> getUserLeads(String username) {
        return leadsRepository.getUserLeads(username);
    }

    @Override
    public void saveLead(Leads lead) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dateOnly = new SimpleDateFormat("MM/dd/yyyy");
        lead.setCreated_at(dateOnly.format(cal.getTime()));
       this.leadsRepository.save(lead);
        //return lead;
    }

    @Override
    public Leads getLeadById(long id) {
        Optional<Leads> optional = leadsRepository.findById(id);
        Leads lead = null;
        if (optional.isPresent()) {
            lead = optional.get();
        } else {
            throw new RuntimeException(" Leads not found for id :: " + id);
        }
        return lead;
    }

    @Override
    public void deleteLeadById(long id) {
        this.leadsRepository.deleteById(id);
    }

    //We will use this dates for filtering the leads in the UI
    @Override
    public List<String> findUniqueDates() {
        return leadsRepository.findUniqueDates();
    }
    @Override
    public String getUserName() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        String userName = null;
        if (authentication != null) {

            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            userName = userDetails.getUsername();

        }
        return userName;
    }

}
