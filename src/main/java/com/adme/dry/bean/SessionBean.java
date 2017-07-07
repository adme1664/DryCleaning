package com.adme.dry.bean;

import com.adme.dry.configuration.CustomUserDetails;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.io.Serializable;

/**
 * Created by Adme System on 7/4/2017.
 */
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionBean implements Serializable {
    private CustomUserDetails customUserDetails;

    public CustomUserDetails getCustomUserDetails() {
        return customUserDetails;
    }

    public void setCustomUserDetails(CustomUserDetails customUserDetails) {
        this.customUserDetails = customUserDetails;
    }
}
