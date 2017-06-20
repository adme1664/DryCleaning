package com.adme.dry.bean;

import com.adme.dry.repository.TypeEmployeeRepository;

import java.io.Serializable;

/**
 * Created by Adme System on 6/15/2017.
 */
public class EmployeeBean implements Serializable {
    private Integer id;
    private int employeeId;
    private String employeeLastName;
    private String employeeFirstName;
    private String employeeGender;
    private String employeeAdress;
    private String employeePhone;
    private Integer employeeStatus;
    private int createUser;
    private String createDate;
    private Integer updateUser;
    private String udpateDate;
    private TypeEmployeeBean employeeType;
    private String employeeUsername;
    private String employeePassword;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    public String getEmployeeGender() {
        return employeeGender;
    }

    public void setEmployeeGender(String employeeGender) {
        this.employeeGender = employeeGender;
    }

    public String getEmployeeAdress() {
        return employeeAdress;
    }

    public void setEmployeeAdress(String employeeAdress) {
        this.employeeAdress = employeeAdress;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public Integer getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(Integer employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public int getCreateUser() {
        return createUser;
    }

    public void setCreateUser(int createUser) {
        this.createUser = createUser;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    public String getUdpateDate() {
        return udpateDate;
    }

    public void setUdpateDate(String udpateDate) {
        this.udpateDate = udpateDate;
    }

    public TypeEmployeeBean getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(TypeEmployeeBean employeeType) {
        this.employeeType = employeeType;
    }

    public String getEmployeeUsername() {
        return employeeUsername;
    }

    public void setEmployeeUsername(String employeeUsername) {
        this.employeeUsername = employeeUsername;
    }

    public String getEmployeePassword() {
        return employeePassword;
    }

    public void setEmployeePassword(String employeePassword) {
        this.employeePassword = employeePassword;
    }
}
