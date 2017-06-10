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
@Table(name = "Tbl_Type_Employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblTypeEmployee.findAll", query = "SELECT t FROM TblTypeEmployee t"),
    @NamedQuery(name = "TblTypeEmployee.findById", query = "SELECT t FROM TblTypeEmployee t WHERE t.id = :id"),
    @NamedQuery(name = "TblTypeEmployee.findByTypeName", query = "SELECT t FROM TblTypeEmployee t WHERE t.typeName = :typeName"),
    @NamedQuery(name = "TblTypeEmployee.findByCanAddCustomer", query = "SELECT t FROM TblTypeEmployee t WHERE t.canAddCustomer = :canAddCustomer"),
    @NamedQuery(name = "TblTypeEmployee.findByCanAddPiece", query = "SELECT t FROM TblTypeEmployee t WHERE t.canAddPiece = :canAddPiece"),
    @NamedQuery(name = "TblTypeEmployee.findByCanAddTicket", query = "SELECT t FROM TblTypeEmployee t WHERE t.canAddTicket = :canAddTicket"),
    @NamedQuery(name = "TblTypeEmployee.findByCanAddColor", query = "SELECT t FROM TblTypeEmployee t WHERE t.canAddColor = :canAddColor"),
    @NamedQuery(name = "TblTypeEmployee.findByCanAddService", query = "SELECT t FROM TblTypeEmployee t WHERE t.canAddService = :canAddService"),
    @NamedQuery(name = "TblTypeEmployee.findByCanAddPayment", query = "SELECT t FROM TblTypeEmployee t WHERE t.canAddPayment = :canAddPayment"),
    @NamedQuery(name = "TblTypeEmployee.findByCanAddTypePiece", query = "SELECT t FROM TblTypeEmployee t WHERE t.canAddTypePiece = :canAddTypePiece"),
    @NamedQuery(name = "TblTypeEmployee.findByCanAddEmployee", query = "SELECT t FROM TblTypeEmployee t WHERE t.canAddEmployee = :canAddEmployee"),
    @NamedQuery(name = "TblTypeEmployee.findByCanUpdateCustomer", query = "SELECT t FROM TblTypeEmployee t WHERE t.canUpdateCustomer = :canUpdateCustomer"),
    @NamedQuery(name = "TblTypeEmployee.findByCanUpdateTicket", query = "SELECT t FROM TblTypeEmployee t WHERE t.canUpdateTicket = :canUpdateTicket"),
    @NamedQuery(name = "TblTypeEmployee.findByCanUpdatePiece", query = "SELECT t FROM TblTypeEmployee t WHERE t.canUpdatePiece = :canUpdatePiece"),
    @NamedQuery(name = "TblTypeEmployee.findByCanUpdateColor", query = "SELECT t FROM TblTypeEmployee t WHERE t.canUpdateColor = :canUpdateColor"),
    @NamedQuery(name = "TblTypeEmployee.findByCanUpdateEmployee", query = "SELECT t FROM TblTypeEmployee t WHERE t.canUpdateEmployee = :canUpdateEmployee"),
    @NamedQuery(name = "TblTypeEmployee.findByCanUpdateTypePiece", query = "SELECT t FROM TblTypeEmployee t WHERE t.canUpdateTypePiece = :canUpdateTypePiece"),
    @NamedQuery(name = "TblTypeEmployee.findByCanSearchCustomer", query = "SELECT t FROM TblTypeEmployee t WHERE t.canSearchCustomer = :canSearchCustomer"),
    @NamedQuery(name = "TblTypeEmployee.findByCanSearchPiece", query = "SELECT t FROM TblTypeEmployee t WHERE t.canSearchPiece = :canSearchPiece"),
    @NamedQuery(name = "TblTypeEmployee.findByCanSearchTicket", query = "SELECT t FROM TblTypeEmployee t WHERE t.canSearchTicket = :canSearchTicket"),
    @NamedQuery(name = "TblTypeEmployee.findByCanSearchColor", query = "SELECT t FROM TblTypeEmployee t WHERE t.canSearchColor = :canSearchColor"),
    @NamedQuery(name = "TblTypeEmployee.findByCanSearchTypePiece", query = "SELECT t FROM TblTypeEmployee t WHERE t.canSearchTypePiece = :canSearchTypePiece"),
    @NamedQuery(name = "TblTypeEmployee.findByCanSearchEmployee", query = "SELECT t FROM TblTypeEmployee t WHERE t.canSearchEmployee = :canSearchEmployee"),
    @NamedQuery(name = "TblTypeEmployee.findByCanSearchPayment", query = "SELECT t FROM TblTypeEmployee t WHERE t.canSearchPayment = :canSearchPayment"),
    @NamedQuery(name = "TblTypeEmployee.findByCanDeleteCustomer", query = "SELECT t FROM TblTypeEmployee t WHERE t.canDeleteCustomer = :canDeleteCustomer"),
    @NamedQuery(name = "TblTypeEmployee.findByCanDeleteTicket", query = "SELECT t FROM TblTypeEmployee t WHERE t.canDeleteTicket = :canDeleteTicket"),
    @NamedQuery(name = "TblTypeEmployee.findByCanDeletePiece", query = "SELECT t FROM TblTypeEmployee t WHERE t.canDeletePiece = :canDeletePiece"),
    @NamedQuery(name = "TblTypeEmployee.findByCanDeleteColor", query = "SELECT t FROM TblTypeEmployee t WHERE t.canDeleteColor = :canDeleteColor"),
    @NamedQuery(name = "TblTypeEmployee.findByCanDeleteTypeService", query = "SELECT t FROM TblTypeEmployee t WHERE t.canDeleteTypeService = :canDeleteTypeService"),
    @NamedQuery(name = "TblTypeEmployee.findByCanDeleteEmployee", query = "SELECT t FROM TblTypeEmployee t WHERE t.canDeleteEmployee = :canDeleteEmployee")})
public class TblTypeEmployee implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "type_name")
    private String typeName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "can_add_customer")
    private boolean canAddCustomer;
    @Basic(optional = false)
    @NotNull
    @Column(name = "can_add_piece")
    private boolean canAddPiece;
    @Basic(optional = false)
    @NotNull
    @Column(name = "can_add_ticket")
    private boolean canAddTicket;
    @Basic(optional = false)
    @NotNull
    @Column(name = "can_add_color")
    private boolean canAddColor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "can_add_service")
    private boolean canAddService;
    @Basic(optional = false)
    @NotNull
    @Column(name = "can_add_payment")
    private boolean canAddPayment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "can_add_type_piece")
    private boolean canAddTypePiece;
    @Basic(optional = false)
    @NotNull
    @Column(name = "can_add_employee")
    private boolean canAddEmployee;
    @Basic(optional = false)
    @NotNull
    @Column(name = "can_update_customer")
    private boolean canUpdateCustomer;
    @Column(name = "can_update_ticket")
    private Boolean canUpdateTicket;
    @Basic(optional = false)
    @NotNull
    @Column(name = "can_update_piece")
    private boolean canUpdatePiece;
    @Column(name = "can_update_color")
    private Boolean canUpdateColor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "can_update_employee")
    private boolean canUpdateEmployee;
    @Basic(optional = false)
    @NotNull
    @Column(name = "can_update_type_piece")
    private boolean canUpdateTypePiece;
    @Basic(optional = false)
    @NotNull
    @Column(name = "can_search_customer")
    private boolean canSearchCustomer;
    @Basic(optional = false)
    @NotNull
    @Column(name = "can_search_piece")
    private boolean canSearchPiece;
    @Basic(optional = false)
    @NotNull
    @Column(name = "can_search_ticket")
    private boolean canSearchTicket;
    @Basic(optional = false)
    @NotNull
    @Column(name = "can_search_color")
    private boolean canSearchColor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "can_search_type_piece")
    private boolean canSearchTypePiece;
    @Basic(optional = false)
    @NotNull
    @Column(name = "can_search_employee")
    private boolean canSearchEmployee;
    @Basic(optional = false)
    @NotNull
    @Column(name = "can_search_payment")
    private boolean canSearchPayment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "can_delete_customer")
    private boolean canDeleteCustomer;
    @Basic(optional = false)
    @NotNull
    @Column(name = "can_delete_ticket")
    private boolean canDeleteTicket;
    @Basic(optional = false)
    @NotNull
    @Column(name = "can_delete_piece")
    private boolean canDeletePiece;
    @Basic(optional = false)
    @NotNull
    @Column(name = "can_delete_color")
    private boolean canDeleteColor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "can_delete_type_service")
    private boolean canDeleteTypeService;
    @Basic(optional = false)
    @NotNull
    @Column(name = "can_delete_employee")
    private boolean canDeleteEmployee;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeType")
    private Collection<TblEmployee> tblEmployeeCollection;

    public TblTypeEmployee() {
    }

    public TblTypeEmployee(Integer id) {
        this.id = id;
    }

    public TblTypeEmployee(Integer id, String typeName, boolean canAddCustomer, boolean canAddPiece, boolean canAddTicket, boolean canAddColor, boolean canAddService, boolean canAddPayment, boolean canAddTypePiece, boolean canAddEmployee, boolean canUpdateCustomer, boolean canUpdatePiece, boolean canUpdateEmployee, boolean canUpdateTypePiece, boolean canSearchCustomer, boolean canSearchPiece, boolean canSearchTicket, boolean canSearchColor, boolean canSearchTypePiece, boolean canSearchEmployee, boolean canSearchPayment, boolean canDeleteCustomer, boolean canDeleteTicket, boolean canDeletePiece, boolean canDeleteColor, boolean canDeleteTypeService, boolean canDeleteEmployee) {
        this.id = id;
        this.typeName = typeName;
        this.canAddCustomer = canAddCustomer;
        this.canAddPiece = canAddPiece;
        this.canAddTicket = canAddTicket;
        this.canAddColor = canAddColor;
        this.canAddService = canAddService;
        this.canAddPayment = canAddPayment;
        this.canAddTypePiece = canAddTypePiece;
        this.canAddEmployee = canAddEmployee;
        this.canUpdateCustomer = canUpdateCustomer;
        this.canUpdatePiece = canUpdatePiece;
        this.canUpdateEmployee = canUpdateEmployee;
        this.canUpdateTypePiece = canUpdateTypePiece;
        this.canSearchCustomer = canSearchCustomer;
        this.canSearchPiece = canSearchPiece;
        this.canSearchTicket = canSearchTicket;
        this.canSearchColor = canSearchColor;
        this.canSearchTypePiece = canSearchTypePiece;
        this.canSearchEmployee = canSearchEmployee;
        this.canSearchPayment = canSearchPayment;
        this.canDeleteCustomer = canDeleteCustomer;
        this.canDeleteTicket = canDeleteTicket;
        this.canDeletePiece = canDeletePiece;
        this.canDeleteColor = canDeleteColor;
        this.canDeleteTypeService = canDeleteTypeService;
        this.canDeleteEmployee = canDeleteEmployee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public boolean getCanAddCustomer() {
        return canAddCustomer;
    }

    public void setCanAddCustomer(boolean canAddCustomer) {
        this.canAddCustomer = canAddCustomer;
    }

    public boolean getCanAddPiece() {
        return canAddPiece;
    }

    public void setCanAddPiece(boolean canAddPiece) {
        this.canAddPiece = canAddPiece;
    }

    public boolean getCanAddTicket() {
        return canAddTicket;
    }

    public void setCanAddTicket(boolean canAddTicket) {
        this.canAddTicket = canAddTicket;
    }

    public boolean getCanAddColor() {
        return canAddColor;
    }

    public void setCanAddColor(boolean canAddColor) {
        this.canAddColor = canAddColor;
    }

    public boolean getCanAddService() {
        return canAddService;
    }

    public void setCanAddService(boolean canAddService) {
        this.canAddService = canAddService;
    }

    public boolean getCanAddPayment() {
        return canAddPayment;
    }

    public void setCanAddPayment(boolean canAddPayment) {
        this.canAddPayment = canAddPayment;
    }

    public boolean getCanAddTypePiece() {
        return canAddTypePiece;
    }

    public void setCanAddTypePiece(boolean canAddTypePiece) {
        this.canAddTypePiece = canAddTypePiece;
    }

    public boolean getCanAddEmployee() {
        return canAddEmployee;
    }

    public void setCanAddEmployee(boolean canAddEmployee) {
        this.canAddEmployee = canAddEmployee;
    }

    public boolean getCanUpdateCustomer() {
        return canUpdateCustomer;
    }

    public void setCanUpdateCustomer(boolean canUpdateCustomer) {
        this.canUpdateCustomer = canUpdateCustomer;
    }

    public Boolean getCanUpdateTicket() {
        return canUpdateTicket;
    }

    public void setCanUpdateTicket(Boolean canUpdateTicket) {
        this.canUpdateTicket = canUpdateTicket;
    }

    public boolean getCanUpdatePiece() {
        return canUpdatePiece;
    }

    public void setCanUpdatePiece(boolean canUpdatePiece) {
        this.canUpdatePiece = canUpdatePiece;
    }

    public Boolean getCanUpdateColor() {
        return canUpdateColor;
    }

    public void setCanUpdateColor(Boolean canUpdateColor) {
        this.canUpdateColor = canUpdateColor;
    }

    public boolean getCanUpdateEmployee() {
        return canUpdateEmployee;
    }

    public void setCanUpdateEmployee(boolean canUpdateEmployee) {
        this.canUpdateEmployee = canUpdateEmployee;
    }

    public boolean getCanUpdateTypePiece() {
        return canUpdateTypePiece;
    }

    public void setCanUpdateTypePiece(boolean canUpdateTypePiece) {
        this.canUpdateTypePiece = canUpdateTypePiece;
    }

    public boolean getCanSearchCustomer() {
        return canSearchCustomer;
    }

    public void setCanSearchCustomer(boolean canSearchCustomer) {
        this.canSearchCustomer = canSearchCustomer;
    }

    public boolean getCanSearchPiece() {
        return canSearchPiece;
    }

    public void setCanSearchPiece(boolean canSearchPiece) {
        this.canSearchPiece = canSearchPiece;
    }

    public boolean getCanSearchTicket() {
        return canSearchTicket;
    }

    public void setCanSearchTicket(boolean canSearchTicket) {
        this.canSearchTicket = canSearchTicket;
    }

    public boolean getCanSearchColor() {
        return canSearchColor;
    }

    public void setCanSearchColor(boolean canSearchColor) {
        this.canSearchColor = canSearchColor;
    }

    public boolean getCanSearchTypePiece() {
        return canSearchTypePiece;
    }

    public void setCanSearchTypePiece(boolean canSearchTypePiece) {
        this.canSearchTypePiece = canSearchTypePiece;
    }

    public boolean getCanSearchEmployee() {
        return canSearchEmployee;
    }

    public void setCanSearchEmployee(boolean canSearchEmployee) {
        this.canSearchEmployee = canSearchEmployee;
    }

    public boolean getCanSearchPayment() {
        return canSearchPayment;
    }

    public void setCanSearchPayment(boolean canSearchPayment) {
        this.canSearchPayment = canSearchPayment;
    }

    public boolean getCanDeleteCustomer() {
        return canDeleteCustomer;
    }

    public void setCanDeleteCustomer(boolean canDeleteCustomer) {
        this.canDeleteCustomer = canDeleteCustomer;
    }

    public boolean getCanDeleteTicket() {
        return canDeleteTicket;
    }

    public void setCanDeleteTicket(boolean canDeleteTicket) {
        this.canDeleteTicket = canDeleteTicket;
    }

    public boolean getCanDeletePiece() {
        return canDeletePiece;
    }

    public void setCanDeletePiece(boolean canDeletePiece) {
        this.canDeletePiece = canDeletePiece;
    }

    public boolean getCanDeleteColor() {
        return canDeleteColor;
    }

    public void setCanDeleteColor(boolean canDeleteColor) {
        this.canDeleteColor = canDeleteColor;
    }

    public boolean getCanDeleteTypeService() {
        return canDeleteTypeService;
    }

    public void setCanDeleteTypeService(boolean canDeleteTypeService) {
        this.canDeleteTypeService = canDeleteTypeService;
    }

    public boolean getCanDeleteEmployee() {
        return canDeleteEmployee;
    }

    public void setCanDeleteEmployee(boolean canDeleteEmployee) {
        this.canDeleteEmployee = canDeleteEmployee;
    }

    @XmlTransient
    public Collection<TblEmployee> getTblEmployeeCollection() {
        return tblEmployeeCollection;
    }

    public void setTblEmployeeCollection(Collection<TblEmployee> tblEmployeeCollection) {
        this.tblEmployeeCollection = tblEmployeeCollection;
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
        if (!(object instanceof TblTypeEmployee)) {
            return false;
        }
        TblTypeEmployee other = (TblTypeEmployee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dry.entities.TblTypeEmployee[ id=" + id + " ]";
    }
    
}
