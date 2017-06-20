package com.adme.dry.configuration;

import org.apache.log4j.Logger;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Adme System on 6/14/2017.
 */
@Component
public class MyAccessDeniedHandler implements AccessDeniedHandler {


    public static Logger log=Logger.getLogger(AccessDeniedHandler.class);

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e)
            throws IOException, ServletException {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        if(authentication!=null){
            log.info("User:=>"+authentication.getName()+
                    "Attemted to get access"+httpServletRequest.getRequestURI());
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/403");
        }

    }
}
