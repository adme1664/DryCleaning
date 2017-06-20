package com.adme.dry.controllers;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Adme System on 6/15/2017.
 */
@Controller
@Component
public class LoginController {

    private static final String VIEW_LOGIN = "views/login/";
    private static final String VIEW_BASE = "views/home/";
    private static Logger log = Logger.getLogger(LoginController.class);

    @RequestMapping("/home")
    public String index(Model model) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (userDetails != null) {
            log.info("User connected:" + userDetails.getUsername());
            model.addAttribute("user",userDetails.getUsername());
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
