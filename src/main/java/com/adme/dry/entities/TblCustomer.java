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
@Table(name = "Tbl_Customer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblCustomer.findAll", query = "SELECT t FROM TblCustomer t"),
    @NamedQuery(name = "TblCustomer.findById", query = "SELECT t FROM TblCustomer t WHERE t.id = :id"),
    @NamedQuery(name = "TblCustomer.findByCustomerId", query = "SELECT t FROM TblCustomer t WHERE t.customerId = :customerId"),
    @NamedQuery(name = "TblCustomer.findByCustomerFirstName", query = "SELECT t FROM TblCustomer t WHERE t.customerFirstName = :customerFirstName"),
    @NamedQuery(name = "TblCustomer.findByCustomerLastName", query = "SELECT t FROM TblCustomer t WHERE t.customerLastName = :customerLastName"),
    @NamedQuery(name = "TblCustomer.findByCustomerAdress", query = "SELECT t FROM TblCustomer t WHERE t.customerAdress = :customerAdress"),
    @NamedQuery(name = "TblCustomer.findByCustomerPhone1", query = "SELECT t FROM TblCustomer t WHERE t.customerPhone1 = :customerPhone1"),
    @NamedQuery(name = "TblCustomer.findByCustomerPhone2", query = "SELECT t FROM TblCustomer t WHERE t.customerPhone2 = :customerPhone2"),
    @NamedQuery(name = "TblCustomer.findByCustomerEmail", query = "SELECT t FROM TblCustomer t WHERE t.customerEmail = :customerEmail"),
    @NamedQuery(name = "TblCustomer.findByCustomerPreferedCommunication", query = "SELECT t FROM TblCustomer t WHERE t.customerPreferedCommunication = :customerPreferedCommunication"),
    @NamedQuery(name = "TblCustomer.findByCustomerRemarks", query = "SELECT t FROM TblCustomer t WHERE t.customerRemarks = :customerRemarks"),
    @NamedQuery(name = "TblCustomer.findByCustomerStatus", query = "SELECT t FROM TblCustomer t WHERE t.customerStatus = :customerStatus"),
    @NamedQuery(name = "TblCustomer.findByCustomerDeliveryMode", query = "SELECT t FROM TblCustomer t WHERE t.customerDeliveryMode = :customerDeliveryMode"),
    @NamedQuery(name = "TblCustomer.findByCreateUser", query = "SELECT t FROM TblCustomer t WHERE t.createUser = :createUser"),
    @NamedQuery(name = "TblCustomer.findByCreateDate", query = "SELECT t FROM TblCustomer t WHERE t.createDate = :createDate"),
    @NamedQuery(name = "TblCustomer.findByUpdateUser", query = "SELECT t FROM TblCustomer t WHERE t.updateUser = :updateUser"),
    @NamedQuery(name = "TblCustomer.findByUpdateDate", query = "SELECT t FROM TblCustomer t WHERE t.updateDate = :updateDate")})
public class TblCustomer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "customer_id")
    private int customerId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "customer_first_name")
    private String customerFirstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "customer_last_name")
    private String customerLastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "customer_adress")
    private String customerAdress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "customer_phone_1")
    private String customerPhone1;
    @Size(max = 20)
    @Column(name = "customer_phone_2")
    private String customerPhone2;
    @Size(max = 100)
    @Column(name = "customer_email")
    private String customerEmail;
    @Size(max = 20)
    @Column(name = "customer_prefered_communication")
    private String customerPreferedCommunication;
    @Size(max = 250)
    @Column(name = "customer_remarks")
    private String customerRemarks;
    @Basic(optional = false)
    @NotNull
    @Column(name = "customer_status")
    private int customerStatus;
    @Column(name = "customer_delivery_mode")
    private Integer customerDeliveryMode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "create_user")
    private String createUser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "create_date")
    private String createDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "update_user")
    private String updateUser;
    @Size(max = 10)
    @Column(name = "update_date")
    private String updateDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerId")
    private Collection<TblTicket> tblTicketCollection;

    public TblCustomer() {
    }

    public TblCustomer(Integer id) {
        this.id = id;
    }

    public TblCustomer(Integer id, int customerId, String customerFirstName, String customerLastName, String customerAdress, String customerPhone1, int customerStatus, String createUser, String createDate, String updateUser) {
        this.id = id;
        this.customerId = customerId;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerAdress = customerAdress;
        this.customerPhone1 = customerPhone1;
        this.customerStatus = customerStatus;
        this.createUser = createUser;
        this.createDate = createDate;
        this.updateUser = updateUser;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getCustomerAdress() {
        return customerAdress;
    }

    public void setCustomerAdress(String customerAdress) {
        this.customerAdress = customerAdress;
    }

    public String getCustomerPhone1() {
        return customerPhone1;
    }

    public void setCustomerPhone1(String customerPhone1) {
        this.customerPhone1 = customerPhone1;
    }

    public String getCustomerPhone2() {
        return customerPhone2;
    }

    public void setCustomerPhone2(String customerPhone2) {
        this.customerPhone2 = customerPhone2;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPreferedCommunication() {
        return customerPreferedCommunication;
    }

    public void setCustomerPreferedCommunication(String customerPreferedCommunication) {
        this.customerPreferedCommunication = customerPreferedCommunication;
    }

    public String getCustomerRemarks() {
        return customerRemarks;
    }

    public void setCustomerRemarks(String customerRemarks) {
        this.customerRemarks = customerRemarks;
    }

    public int getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(int customerStatus) {
        this.customerStatus = customerStatus;
    }

    public Integer getCustomerDeliveryMode() {
        return customerDeliveryMode;
    }

    public void setCustomerDeliveryMode(Integer customerDeliveryMode) {
        this.customerDeliveryMode = customerDeliveryMode;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    @XmlTransient
    public Collection<TblTicket> getTblTicketCollection() {
        return tblTicketCollection;
    }

    public void setTblTicketCollection(Collection<TblTicket> tblTicketCollection) {
        this.tblTicketCollection = tblTicketCollection;
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
        if (!(object instanceof TblCustomer)) {
            return false;
        }
        TblCustomer other = (TblCustomer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dry.entities.TblCustomer[ id=" + id + " ]";
    }
    
}
