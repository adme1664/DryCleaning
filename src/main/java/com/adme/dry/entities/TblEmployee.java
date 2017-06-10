/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adme.dry.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adme System
 */
@Entity
@Table(name = "Tbl_Employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblEmployee.findAll", query = "SELECT t FROM TblEmployee t"),
    @NamedQuery(name = "TblEmployee.findById", query = "SELECT t FROM TblEmployee t WHERE t.id = :id"),
    @NamedQuery(name = "TblEmployee.findByEmployeeId", query = "SELECT t FROM TblEmployee t WHERE t.employeeId = :employeeId"),
    @NamedQuery(name = "TblEmployee.findByEmployeeLastName", query = "SELECT t FROM TblEmployee t WHERE t.employeeLastName = :employeeLastName"),
    @NamedQuery(name = "TblEmployee.findByEmployeeFirstName", query = "SELECT t FROM TblEmployee t WHERE t.employeeFirstName = :employeeFirstName"),
    @NamedQuery(name = "TblEmployee.findByEmployeeGender", query = "SELECT t FROM TblEmployee t WHERE t.employeeGender = :employeeGender"),
    @NamedQuery(name = "TblEmployee.findByEmployeeAdress", query = "SELECT t FROM TblEmployee t WHERE t.employeeAdress = :employeeAdress"),
    @NamedQuery(name = "TblEmployee.findByEmployeePhone", query = "SELECT t FROM TblEmployee t WHERE t.employeePhone = :employeePhone"),
    @NamedQuery(name = "TblEmployee.findByEmployeeStatus", query = "SELECT t FROM TblEmployee t WHERE t.employeeStatus = :employeeStatus"),
    @NamedQuery(name = "TblEmployee.findByCreateUser", query = "SELECT t FROM TblEmployee t WHERE t.createUser = :createUser"),
    @NamedQuery(name = "TblEmployee.findByCreateDate", query = "SELECT t FROM TblEmployee t WHERE t.createDate = :createDate"),
    @NamedQuery(name = "TblEmployee.findByUpdateUser", query = "SELECT t FROM TblEmployee t WHERE t.updateUser = :updateUser"),
    @NamedQuery(name = "TblEmployee.findByUdpateDate", query = "SELECT t FROM TblEmployee t WHERE t.udpateDate = :udpateDate")})
public class TblEmployee implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "employee_id")
    private int employeeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "employee_last_name")
    private String employeeLastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "employee_first_name")
    private String employeeFirstName;
    @Size(max = 1)
    @Column(name = "employee_gender")
    private String employeeGender;
    @Size(max = 150)
    @Column(name = "employee_adress")
    private String employeeAdress;
    @Size(max = 20)
    @Column(name = "employee_phone")
    private String employeePhone;
    @Size(max = 36)
    @Column(name = "employee_status")
    private String employeeStatus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "create_user")
    private int createUser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "create_date")
    private String createDate;
    @Column(name = "update_user")
    private Integer updateUser;
    @Size(max = 10)
    @Column(name = "udpate_date")
    private String udpateDate;
    @JoinColumn(name = "employee_type", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TblTypeEmployee employeeType;

    public TblEmployee() {
    }

    public TblEmployee(Integer id) {
        this.id = id;
    }

    public TblEmployee(Integer id, int employeeId, String employeeLastName, String employeeFirstName, int createUser, String createDate) {
        this.id = id;
        this.employeeId = employeeId;
        this.employeeLastName = employeeLastName;
        this.employeeFirstName = employeeFirstName;
        this.createUser = createUser;
        this.createDate = createDate;
    }

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

    public String getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(String employeeStatus) {
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

    public TblTypeEmployee getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(TblTypeEmployee employeeType) {
        this.employeeType = employeeType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblEmployee)) {
            return false;
        }
        TblEmployee other = (TblEmployee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dry.entities.TblEmployee[ id=" + id + " ]";
    }
    
}
