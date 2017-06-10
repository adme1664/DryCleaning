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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Tbl_Ticket")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblTicket.findAll", query = "SELECT t FROM TblTicket t"),
    @NamedQuery(name = "TblTicket.findById", query = "SELECT t FROM TblTicket t WHERE t.id = :id"),
    @NamedQuery(name = "TblTicket.findByTicketPrice", query = "SELECT t FROM TblTicket t WHERE t.ticketPrice = :ticketPrice"),
    @NamedQuery(name = "TblTicket.findByTicketDueDate", query = "SELECT t FROM TblTicket t WHERE t.ticketDueDate = :ticketDueDate"),
    @NamedQuery(name = "TblTicket.findByTicketDeliveryDate", query = "SELECT t FROM TblTicket t WHERE t.ticketDeliveryDate = :ticketDeliveryDate"),
    @NamedQuery(name = "TblTicket.findByTicketStatusPay", query = "SELECT t FROM TblTicket t WHERE t.ticketStatusPay = :ticketStatusPay"),
    @NamedQuery(name = "TblTicket.findByTicketStatusDelivered", query = "SELECT t FROM TblTicket t WHERE t.ticketStatusDelivered = :ticketStatusDelivered"),
    @NamedQuery(name = "TblTicket.findByCreateUser", query = "SELECT t FROM TblTicket t WHERE t.createUser = :createUser"),
    @NamedQuery(name = "TblTicket.findByCreateDate", query = "SELECT t FROM TblTicket t WHERE t.createDate = :createDate"),
    @NamedQuery(name = "TblTicket.findByUpdateUser", query = "SELECT t FROM TblTicket t WHERE t.updateUser = :updateUser"),
    @NamedQuery(name = "TblTicket.findByUpdateDate", query = "SELECT t FROM TblTicket t WHERE t.updateDate = :updateDate")})
public class TblTicket implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ticket_price")
    private double ticketPrice;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ticket_due_date")
    private String ticketDueDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ticket_delivery_date")
    private String ticketDeliveryDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ticket_status_pay")
    private boolean ticketStatusPay;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ticket_status_delivered")
    private boolean ticketStatusDelivered;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tickeId")
    private Collection<TblDetailsTicket> tblDetailsTicketCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ticketId")
    private Collection<TblPayment> tblPaymentCollection;
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TblCustomer customerId;

    public TblTicket() {
    }

    public TblTicket(Integer id) {
        this.id = id;
    }

    public TblTicket(Integer id, double ticketPrice, String ticketDueDate, String ticketDeliveryDate, boolean ticketStatusPay, boolean ticketStatusDelivered, int createUser, String createDate) {
        this.id = id;
        this.ticketPrice = ticketPrice;
        this.ticketDueDate = ticketDueDate;
        this.ticketDeliveryDate = ticketDeliveryDate;
        this.ticketStatusPay = ticketStatusPay;
        this.ticketStatusDelivered = ticketStatusDelivered;
        this.createUser = createUser;
        this.createDate = createDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getTicketDueDate() {
        return ticketDueDate;
    }

    public void setTicketDueDate(String ticketDueDate) {
        this.ticketDueDate = ticketDueDate;
    }

    public String getTicketDeliveryDate() {
        return ticketDeliveryDate;
    }

    public void setTicketDeliveryDate(String ticketDeliveryDate) {
        this.ticketDeliveryDate = ticketDeliveryDate;
    }

    public boolean getTicketStatusPay() {
        return ticketStatusPay;
    }

    public void setTicketStatusPay(boolean ticketStatusPay) {
        this.ticketStatusPay = ticketStatusPay;
    }

    public boolean getTicketStatusDelivered() {
        return ticketStatusDelivered;
    }

    public void setTicketStatusDelivered(boolean ticketStatusDelivered) {
        this.ticketStatusDelivered = ticketStatusDelivered;
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

    @XmlTransient
    public Collection<TblPayment> getTblPaymentCollection() {
        return tblPaymentCollection;
    }

    public void setTblPaymentCollection(Collection<TblPayment> tblPaymentCollection) {
        this.tblPaymentCollection = tblPaymentCollection;
    }

    public TblCustomer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(TblCustomer customerId) {
        this.customerId = customerId;
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
        if (!(object instanceof TblTicket)) {
            return false;
        }
        TblTicket other = (TblTicket) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dry.entities.TblTicket[ id=" + id + " ]";
    }
    
}
