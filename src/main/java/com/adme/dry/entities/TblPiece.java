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
@Table(name = "Tbl_Piece")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblPiece.findAll", query = "SELECT t FROM TblPiece t"),
    @NamedQuery(name = "TblPiece.findById", query = "SELECT t FROM TblPiece t WHERE t.id = :id"),
    @NamedQuery(name = "TblPiece.findByPieceDescription", query = "SELECT t FROM TblPiece t WHERE t.pieceDescription = :pieceDescription"),
    @NamedQuery(name = "TblPiece.findByPiecePrice", query = "SELECT t FROM TblPiece t WHERE t.piecePrice = :piecePrice"),
    @NamedQuery(name = "TblPiece.findByPieceStatus", query = "SELECT t FROM TblPiece t WHERE t.pieceStatus = :pieceStatus"),
    @NamedQuery(name = "TblPiece.findByCreateUser", query = "SELECT t FROM TblPiece t WHERE t.createUser = :createUser"),
    @NamedQuery(name = "TblPiece.findByCreateDate", query = "SELECT t FROM TblPiece t WHERE t.createDate = :createDate"),
    @NamedQuery(name = "TblPiece.findByUpdateUser", query = "SELECT t FROM TblPiece t WHERE t.updateUser = :updateUser"),
    @NamedQuery(name = "TblPiece.findByUpdateDate", query = "SELECT t FROM TblPiece t WHERE t.updateDate = :updateDate")})
public class TblPiece implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "piece_description")
    private String pieceDescription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "piece_price")
    private double piecePrice;
    @Column(name = "piece_status")
    private Integer pieceStatus;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pieceId")
    private Collection<TblDetailsTicket> tblDetailsTicketCollection;

    public TblPiece() {
    }

    public TblPiece(Integer id) {
        this.id = id;
    }

    public TblPiece(Integer id, String pieceDescription, double piecePrice, int createUser, String createDate) {
        this.id = id;
        this.pieceDescription = pieceDescription;
        this.piecePrice = piecePrice;
        this.createUser = createUser;
        this.createDate = createDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPieceDescription() {
        return pieceDescription;
    }

    public void setPieceDescription(String pieceDescription) {
        this.pieceDescription = pieceDescription;
    }

    public double getPiecePrice() {
        return piecePrice;
    }

    public void setPiecePrice(double piecePrice) {
        this.piecePrice = piecePrice;
    }

    public Integer getPieceStatus() {
        return pieceStatus;
    }

    public void setPieceStatus(Integer pieceStatus) {
        this.pieceStatus = pieceStatus;
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
        if (!(object instanceof TblPiece)) {
            return false;
        }
        TblPiece other = (TblPiece) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dry.entities.TblPiece[ id=" + id + " ]";
    }
    
}
