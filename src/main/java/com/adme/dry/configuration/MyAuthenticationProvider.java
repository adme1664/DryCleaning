package com.adme.dry.configuration;

import com.adme.dry.bean.EmployeeBean;
import com.adme.dry.services.LoginServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Adme System on 6/15/2017.
 */
@Service("myAuthenticationProvider")
public class MyAuthenticationProvider  implements UserDetailsService {

    boolean enabled = true;
    boolean accountNonExpired = true;
    boolean credentialsNonExpired = true;
    boolean accountNonLocked = true;

    Logger log=Logger.getLogger(MyAuthenticationProvider.class);

    @Autowired
    @Qualifier("loginServiceImpl")
    LoginServiceImpl loginServiceImpl;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        try {
            RoleBean roleBean = new RoleBean();
            EmployeeBean employeeBean = loginServiceImpl.findEmployeeByUsername(s);
            roleBean.setRoleId(employeeBean.getEmployeeType().getTypeName());
            roleBean.setRoleName(employeeBean.getEmployeeType().getTypeName());
            UserBean userBean = new UserBean();
            userBean.setUsername(employeeBean.getEmployeeUsername());
            userBean.setPassword(employeeBean.getEmployeePassword());
            userBean.setRoles(new ArrayList<RoleBean>());
            userBean.getRoles().add(roleBean);
            //User user = new User(userBean.getUsername(), userBean.getPassword(), enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, getRoles(userBean.getRoles()));
            CustomUserDetails user = new CustomUserDetails(userBean.getUsername(), userBean.getPassword(),employeeBean,employeeBean.getEmployeeType(), enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, getRoles(userBean.getRoles()));
            return user;
        } catch (Exception ex) {
            log.info(ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }

    private Collection<? extends GrantedAuthority> getRoles(List<RoleBean> roles) {

        List<GrantedAuthority> authorities = new ArrayList<>();
        for (RoleBean role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return authorities;
    }

}
