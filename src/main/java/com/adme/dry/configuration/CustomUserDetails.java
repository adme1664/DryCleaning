package com.adme.dry.configuration;

import com.adme.dry.bean.EmployeeBean;
import com.adme.dry.bean.TypeEmployeeBean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Created by Adme System on 6/18/2017.
 */
public class CustomUserDetails implements UserDetails {
    private EmployeeBean employeeBean;
    private TypeEmployeeBean typeEmployeeBean;
    boolean enabled = true;
    boolean accountNonExpired = true;
    boolean credentialsNonExpired = true;
    boolean accountNonLocked = true;


    public CustomUserDetails(EmployeeBean employeeBean, TypeEmployeeBean typeEmployeeBean,
                             boolean enabled,boolean accountNonExpired, boolean credentialsNonExpired,
                             boolean accountNonLocked){
        this.employeeBean=employeeBean;
        this.typeEmployeeBean=typeEmployeeBean;
        this.enabled=enabled;
        this.accountNonExpired=accountNonExpired;
        this.credentialsNonExpired=credentialsNonExpired;
        this.accountNonLocked=accountNonLocked;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public EmployeeBean getEmployeeBean() {
        return employeeBean;
    }

    public void setEmployeeBean(EmployeeBean employeeBean) {
        this.employeeBean = employeeBean;
    }

    public TypeEmployeeBean getTypeEmployeeBean() {
        return typeEmployeeBean;
    }

    public void setTypeEmployeeBean(TypeEmployeeBean typeEmployeeBean) {
        this.typeEmployeeBean = typeEmployeeBean;
    }
}
