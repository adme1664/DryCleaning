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
@Table(name = "Tbl_Type_Piece")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblTypePiece.findAll", query = "SELECT t FROM TblTypePiece t"),
    @NamedQuery(name = "TblTypePiece.findById", query = "SELECT t FROM TblTypePiece t WHERE t.id = :id"),
    @NamedQuery(name = "TblTypePiece.findByPieceName", query = "SELECT t FROM TblTypePiece t WHERE t.pieceName = :pieceName"),
    @NamedQuery(name = "TblTypePiece.findByCreateUser", query = "SELECT t FROM TblTypePiece t WHERE t.createUser = :createUser"),
    @NamedQuery(name = "TblTypePiece.findByCreateDate", query = "SELECT t FROM TblTypePiece t WHERE t.createDate = :createDate"),
    @NamedQuery(name = "TblTypePiece.findByUpdateUser", query = "SELECT t FROM TblTypePiece t WHERE t.updateUser = :updateUser"),
    @NamedQuery(name = "TblTypePiece.findByUpdateDate", query = "SELECT t FROM TblTypePiece t WHERE t.updateDate = :updateDate")})
public class TblTypePiece implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "piece_name")
    private String pieceName;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pieceType")
    private Collection<TblDetailsTicket> tblDetailsTicketCollection;

    public TblTypePiece() {
    }

    public TblTypePiece(Integer id) {
        this.id = id;
    }

    public TblTypePiece(Integer id, String pieceName, int createUser, String createDate) {
        this.id = id;
        this.pieceName = pieceName;
        this.createUser = createUser;
        this.createDate = createDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPieceName() {
        return pieceName;
    }

    public void setPieceName(String pieceName) {
        this.pieceName = pieceName;
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
        if (!(object instanceof TblTypePiece)) {
            return false;
        }
        TblTypePiece other = (TblTypePiece) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dry.entities.TblTypePiece[ id=" + id + " ]";
    }
    
}
