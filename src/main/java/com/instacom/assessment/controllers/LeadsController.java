package com.instacom.assessment.controllers;

import com.instacom.assessment.model.Leads;
import com.instacom.assessment.service.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:8080")
@Controller
public class LeadsController {
    @Autowired
    private LeadService leadService;
    //POST http method used for saving lead in database
    //We can use requestMapping and select the proper HTTP method POST,DELETE,PUT,GET
    //i am using shortcut - we can PreAuthorize to check Roles users have
    //@PreAuthorize("hasRole('USER')")
    @PostMapping("/leads/saveLead")
    public String saveLead(@ModelAttribute("lead") Leads lead) {
        lead.setUsername(leadService.getUserName());
        leadService.saveLead(lead);
        System.out.println("Logged In User: "+leadService.getUserName());
        return "redirect:/leads";
    }
    //GET method used to Show Lead entry form
    @GetMapping("/leads/showNewLeadForm")
    public String showNewLeadForm(Model model) {
        // create model attribute to bind form data
        Leads leads = new Leads();
        model.addAttribute("lead", leads);
        return "new_lead";
    }
    // get leads by id rest api - we can PreAuthorize to check Roles users have
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/leads/showUpdateform/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id,Model model) {
        // get Lead from the service
        Leads lead = leadService.getLeadById(id);
        // set lead as a model attribute to pre-populate the form
        model.addAttribute("lead", lead);
        return "update_lead";
    }
    // get all leads rest api - we can PreAuthorize to check Roles users have
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/leads")
    public String getAllLeads_v2(Model model){
        //Uncomment code to see all leads
        //List<Leads> leads = leadService.getAllLeads();
        //Get leads for the logged in username
        List<Leads> leads = leadService.getUserLeads(leadService.getUserName());
        model.addAttribute("leads",leads);
        //List<String> dates = leadService.findUniqueDates();
        //I have used HashSet get unique dates to filter with in the UI
        Set<String> uniqueDates = new HashSet<>();
        for(Leads leads1: leads){
            uniqueDates.add(leads1.getCreated_at());
        }
        model.addAttribute("dates",uniqueDates);
        return "leads";
    }
    // delete lead rest api
    //The delete method is essentially saying we need to GET id to use the DELETE HTTP method
    @RequestMapping(value = "/leads/deleteLead/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteLead(@PathVariable (value = "id") long id) {
        // call delete lead method
        this.leadService.deleteLeadById(id);
        return "redirect:/leads";
    }


}
