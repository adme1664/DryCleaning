/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adme.dry.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Adme System
 */
@Entity
@Table(name = "Tbl_Service")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblService.findAll", query = "SELECT t FROM TblService t"),
    @NamedQuery(name = "TblService.findById", query = "SELECT t FROM TblService t WHERE t.id = :id"),
    @NamedQuery(name = "TblService.findByServiceName", query = "SELECT t FROM TblService t WHERE t.serviceName = :serviceName"),
    @NamedQuery(name = "TblService.findByServiceCharge", query = "SELECT t FROM TblService t WHERE t.serviceCharge = :serviceCharge"),
    @NamedQuery(name = "TblService.findByCreateUser", query = "SELECT t FROM TblService t WHERE t.createUser = :createUser"),
    @NamedQuery(name = "TblService.findByCreateDate", query = "SELECT t FROM TblService t WHERE t.createDate = :createDate"),
    @NamedQuery(name = "TblService.findByUpdateUser", query = "SELECT t FROM TblService t WHERE t.updateUser = :updateUser"),
    @NamedQuery(name = "TblService.findByUpdateDate", query = "SELECT t FROM TblService t WHERE t.updateDate = :updateDate")})
public class TblService implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "service_name")
    private String serviceName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "service_charge")
    private double serviceCharge;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeService")
    private Collection<TblDetailsTicket> tblDetailsTicketCollection;

    public TblService() {
    }

    public TblService(Integer id) {
        this.id = id;
    }

    public TblService(Integer id, String serviceName, double serviceCharge, int createUser, String createDate) {
        this.id = id;
        this.serviceName = serviceName;
        this.serviceCharge = serviceCharge;
        this.createUser = createUser;
        this.createDate = createDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(double serviceCharge) {
        this.serviceCharge = serviceCharge;
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

    @XmlTransient
    public Collection<TblDetailsTicket> getTblDetailsTicketCollection() {
        return tblDetailsTicketCollection;
    }

    public void setTblDetailsTicketCollection(Collection<TblDetailsTicket> tblDetailsTicketCollection) {
        this.tblDetailsTicketCollection = tblDetailsTicketCollection;
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
        if (!(object instanceof TblService)) {
            return false;
        }
        TblService other = (TblService) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dry.entities.TblService[ id=" + id + " ]";
    }
    
}
