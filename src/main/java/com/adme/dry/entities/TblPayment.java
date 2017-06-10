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
@Table(name = "Tbl_Payment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblPayment.findAll", query = "SELECT t FROM TblPayment t"),
    @NamedQuery(name = "TblPayment.findById", query = "SELECT t FROM TblPayment t WHERE t.id = :id"),
    @NamedQuery(name = "TblPayment.findByTicketPrice", query = "SELECT t FROM TblPayment t WHERE t.ticketPrice = :ticketPrice"),
    @NamedQuery(name = "TblPayment.findByPaymentDate", query = "SELECT t FROM TblPayment t WHERE t.paymentDate = :paymentDate"),
    @NamedQuery(name = "TblPayment.findByPaymentAmountTendered", query = "SELECT t FROM TblPayment t WHERE t.paymentAmountTendered = :paymentAmountTendered"),
    @NamedQuery(name = "TblPayment.findByPaymentChange", query = "SELECT t FROM TblPayment t WHERE t.paymentChange = :paymentChange"),
    @NamedQuery(name = "TblPayment.findByPaymentMode", query = "SELECT t FROM TblPayment t WHERE t.paymentMode = :paymentMode"),
    @NamedQuery(name = "TblPayment.findByPaymentBalance", query = "SELECT t FROM TblPayment t WHERE t.paymentBalance = :paymentBalance"),
    @NamedQuery(name = "TblPayment.findByCreateUser", query = "SELECT t FROM TblPayment t WHERE t.createUser = :createUser"),
    @NamedQuery(name = "TblPayment.findByCreateDate", query = "SELECT t FROM TblPayment t WHERE t.createDate = :createDate"),
    @NamedQuery(name = "TblPayment.findByUpdateUser", query = "SELECT t FROM TblPayment t WHERE t.updateUser = :updateUser"),
    @NamedQuery(name = "TblPayment.findByUpdateDate", query = "SELECT t FROM TblPayment t WHERE t.updateDate = :updateDate")})
public class TblPayment implements Serializable {
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
    @Column(name = "payment_date")
    private String paymentDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "payment_amount_tendered")
    private double paymentAmountTendered;
    @Basic(optional = false)
    @NotNull
    @Column(name = "payment_change")
    private double paymentChange;
    @Basic(optional = false)
    @NotNull
    @Column(name = "payment_mode")
    private int paymentMode;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "payment_balance")
    private Double paymentBalance;
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
    @JoinColumn(name = "ticket_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TblTicket ticketId;

    public TblPayment() {
    }

    public TblPayment(Integer id) {
        this.id = id;
    }

    public TblPayment(Integer id, double ticketPrice, String paymentDate, double paymentAmountTendered, double paymentChange, int paymentMode, int createUser, String createDate) {
        this.id = id;
        this.ticketPrice = ticketPrice;
        this.paymentDate = paymentDate;
        this.paymentAmountTendered = paymentAmountTendered;
        this.paymentChange = paymentChange;
        this.paymentMode = paymentMode;
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

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public double getPaymentAmountTendered() {
        return paymentAmountTendered;
    }

    public void setPaymentAmountTendered(double paymentAmountTendered) {
        this.paymentAmountTendered = paymentAmountTendered;
    }

    public double getPaymentChange() {
        return paymentChange;
    }

    public void setPaymentChange(double paymentChange) {
        this.paymentChange = paymentChange;
    }

    public int getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(int paymentMode) {
        this.paymentMode = paymentMode;
    }

    public Double getPaymentBalance() {
        return paymentBalance;
    }

    public void setPaymentBalance(Double paymentBalance) {
        this.paymentBalance = paymentBalance;
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

    public TblTicket getTicketId() {
        return ticketId;
    }

    public void setTicketId(TblTicket ticketId) {
        this.ticketId = ticketId;
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
        if (!(object instanceof TblPayment)) {
            return false;
        }
        TblPayment other = (TblPayment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dry.entities.TblPayment[ id=" + id + " ]";
    }
    
}
