package com.instacom.assessment.controllers;

import com.instacom.assessment.service.LeadService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController { ;
    @Autowired
    private LeadService leadService;

    @GetMapping("/")
    public String showHome(Model model){
        //model.addAttribute("username",leadService.getUserName());
        return "index";
    }
    @GetMapping("/welcome")
    public String showPageAfterLogin(Model model){
        //List<Leads> leads = leadService.getAllLeads();
        //model.addAttribute("username",getUserName());
        return "welcome";
    }
    @GetMapping("/login")
    public String login(HttpServletRequest request, HttpSession session) {
        //System.out.println("Logged IN AS:"+auth.getName());
        session.setAttribute(
                "error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION")
        );
        return "login";
    }
    private String getErrorMessage(HttpServletRequest request, String key) {
        Exception exception = (Exception) request.getSession().getAttribute(key);
        String error = "";
        if (exception instanceof BadCredentialsException) {
            error = "Invalid username and password!";
        } else if (exception instanceof LockedException) {
            error = exception.getMessage();
        } else {
            error = "Invalid username and password!";
        }
        return error;
    }
}
