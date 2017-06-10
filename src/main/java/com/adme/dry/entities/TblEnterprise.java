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
import javax.persistence.Lob;
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
@Table(name = "Tbl_Enterprise")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblEnterprise.findAll", query = "SELECT t FROM TblEnterprise t"),
    @NamedQuery(name = "TblEnterprise.findById", query = "SELECT t FROM TblEnterprise t WHERE t.id = :id"),
    @NamedQuery(name = "TblEnterprise.findByEnterpriseName", query = "SELECT t FROM TblEnterprise t WHERE t.enterpriseName = :enterpriseName"),
    @NamedQuery(name = "TblEnterprise.findByEnterpriseAdress", query = "SELECT t FROM TblEnterprise t WHERE t.enterpriseAdress = :enterpriseAdress"),
    @NamedQuery(name = "TblEnterprise.findByEnterpriseSlogan", query = "SELECT t FROM TblEnterprise t WHERE t.enterpriseSlogan = :enterpriseSlogan"),
    @NamedQuery(name = "TblEnterprise.findByEnterpriseTelephone", query = "SELECT t FROM TblEnterprise t WHERE t.enterpriseTelephone = :enterpriseTelephone"),
    @NamedQuery(name = "TblEnterprise.findByEnterpriseEmail", query = "SELECT t FROM TblEnterprise t WHERE t.enterpriseEmail = :enterpriseEmail"),
    @NamedQuery(name = "TblEnterprise.findByCreateUser", query = "SELECT t FROM TblEnterprise t WHERE t.createUser = :createUser"),
    @NamedQuery(name = "TblEnterprise.findByCreateDate", query = "SELECT t FROM TblEnterprise t WHERE t.createDate = :createDate"),
    @NamedQuery(name = "TblEnterprise.findByUpdateUser", query = "SELECT t FROM TblEnterprise t WHERE t.updateUser = :updateUser"),
    @NamedQuery(name = "TblEnterprise.findByUpdateDate", query = "SELECT t FROM TblEnterprise t WHERE t.updateDate = :updateDate")})
public class TblEnterprise implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "enterprise_name")
    private String enterpriseName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "enterprise_adress")
    private String enterpriseAdress;
    @Size(max = 250)
    @Column(name = "enterprise_slogan")
    private String enterpriseSlogan;
    @Size(max = 20)
    @Column(name = "enterprise_telephone")
    private String enterpriseTelephone;
    @Size(max = 50)
    @Column(name = "enterprise_email")
    private String enterpriseEmail;
    @Lob
    @Column(name = "enterprise_logo")
    private byte[] enterpriseLogo;
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
    @Column(name = "update_date")
    private String updateDate;

    public TblEnterprise() {
    }

    public TblEnterprise(Integer id) {
        this.id = id;
    }

    public TblEnterprise(Integer id, String enterpriseName, String enterpriseAdress, int createUser, String createDate) {
        this.id = id;
        this.enterpriseName = enterpriseName;
        this.enterpriseAdress = enterpriseAdress;
        this.createUser = createUser;
        this.createDate = createDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getEnterpriseAdress() {
        return enterpriseAdress;
    }

    public void setEnterpriseAdress(String enterpriseAdress) {
        this.enterpriseAdress = enterpriseAdress;
    }

    public String getEnterpriseSlogan() {
        return enterpriseSlogan;
    }

    public void setEnterpriseSlogan(String enterpriseSlogan) {
        this.enterpriseSlogan = enterpriseSlogan;
    }

    public String getEnterpriseTelephone() {
        return enterpriseTelephone;
    }

    public void setEnterpriseTelephone(String enterpriseTelephone) {
        this.enterpriseTelephone = enterpriseTelephone;
    }

    public String getEnterpriseEmail() {
        return enterpriseEmail;
    }

    public void setEnterpriseEmail(String enterpriseEmail) {
        this.enterpriseEmail = enterpriseEmail;
    }

    public byte[] getEnterpriseLogo() {
        return enterpriseLogo;
    }

    public void setEnterpriseLogo(byte[] enterpriseLogo) {
        this.enterpriseLogo = enterpriseLogo;
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

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
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
        if (!(object instanceof TblEnterprise)) {
            return false;
        }
        TblEnterprise other = (TblEnterprise) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dry.entities.TblEnterprise[ id=" + id + " ]";
    }
    
}
