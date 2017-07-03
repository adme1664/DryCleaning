package com.adme.dry.configuration;

import com.adme.dry.bean.EmployeeBean;
import com.adme.dry.bean.TypeEmployeeBean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Adme System on 6/18/2017.
 */
public class CustomUserDetails extends User {
    private EmployeeBean employeeBean;
    private TypeEmployeeBean typeEmployeeBean;

    public CustomUserDetails(String username, String password, EmployeeBean employeeBean, TypeEmployeeBean typeEmployeeBean,
                             boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired,
                             boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.employeeBean = employeeBean;
        this.typeEmployeeBean = typeEmployeeBean;
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
