/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adme.dry.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Adme System
 */
@Entity
@Table(name = "Tbl_Color")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblColor.findAll", query = "SELECT t FROM TblColor t"),
    @NamedQuery(name = "TblColor.findById", query = "SELECT t FROM TblColor t WHERE t.id = :id"),
    @NamedQuery(name = "TblColor.findByColorName", query = "SELECT t FROM TblColor t WHERE t.colorName = :colorName"),
    @NamedQuery(name = "TblColor.findByColorCode", query = "SELECT t FROM TblColor t WHERE t.colorCode = :colorCode"),
    @NamedQuery(name = "TblColor.findByCreateUser", query = "SELECT t FROM TblColor t WHERE t.createUser = :createUser"),
    @NamedQuery(name = "TblColor.findByCreateDate", query = "SELECT t FROM TblColor t WHERE t.createDate = :createDate"),
    @NamedQuery(name = "TblColor.findByUpdateUser", query = "SELECT t FROM TblColor t WHERE t.updateUser = :updateUser"),
    @NamedQuery(name = "TblColor.findByUpdateDate", query = "SELECT t FROM TblColor t WHERE t.updateDate = :updateDate")})
public class TblColor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "color_name")
    private String colorName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "color_code")
    private String colorCode;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pieceColor")
    private Collection<TblDetailsTicket> tblDetailsTicketCollection;

    public TblColor() {
    }

    public TblColor(Integer id) {
        this.id = id;
    }

    public TblColor(Integer id, String colorName, String colorCode, int createUser, String createDate) {
        this.id = id;
        this.colorName = colorName;
        this.colorCode = colorCode;
        this.createUser = createUser;
        this.createDate = createDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
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
        if (!(object instanceof TblColor)) {
            return false;
        }
        TblColor other = (TblColor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dry.entities.TblColor[ id=" + id + " ]";
    }
    
}
