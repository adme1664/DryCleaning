package com.adme.dry.controllers;

import com.adme.dry.bean.SessionBean;
import com.adme.dry.configuration.CustomUserDetails;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Adme System on 6/15/2017.
 */
@Controller
@Scope(value = "request")
public class LoginController {

    private static final String VIEW_LOGIN = "views/login/";
    private static final String VIEW_BASE = "views/home/";
    private static Logger log = Logger.getLogger(LoginController.class);

    @Autowired
    private SessionBean sessionBean;

    @ModelAttribute("beanSession")
    public SessionBean beanSession(){
        return sessionBean;
    }

    @RequestMapping("/home")
    public String index(Model model) {
        CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (customUserDetails != null) {
            sessionBean.setCustomUserDetails(customUserDetails);
            beanSession();
            log.info("User connected:" + customUserDetails.getUsername());
            log.info("User Role:"+customUserDetails.getTypeEmployeeBean().getTypeName());
            model.addAttribute("user",customUserDetails.getUsername());
            model.addAttribute("userDetails", customUserDetails);
        }
        return VIEW_BASE + "home";
    }

    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("msg", "Your username and password is invalid.");
        } else if (logout != null) {
            model.addAttribute("msg", "You have been logged out successfully.");
        }
        return VIEW_LOGIN + "login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logOut(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "redirect::/login?logout";

    }


}
