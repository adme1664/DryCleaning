package com.adme.dry.services;

import com.adme.dry.bean.EmployeeBean;

/**
 * Created by Adme System on 6/15/2017.
 */
public interface LoginService {
    EmployeeBean findEmployeeByUsername(String employeeUsername);
    EmployeeBean findEmployeeByFirstname(String firstName);
}
