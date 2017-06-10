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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adme System
 */
@Entity
@Table(name = "Tbl_Details_Ticket")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblDetailsTicket.findAll", query = "SELECT t FROM TblDetailsTicket t"),
    @NamedQuery(name = "TblDetailsTicket.findById", query = "SELECT t FROM TblDetailsTicket t WHERE t.id = :id"),
    @NamedQuery(name = "TblDetailsTicket.findByPieceState", query = "SELECT t FROM TblDetailsTicket t WHERE t.pieceState = :pieceState"),
    @NamedQuery(name = "TblDetailsTicket.findByPieceMark", query = "SELECT t FROM TblDetailsTicket t WHERE t.pieceMark = :pieceMark"),
    @NamedQuery(name = "TblDetailsTicket.findByPrice", query = "SELECT t FROM TblDetailsTicket t WHERE t.price = :price")})
public class TblDetailsTicket implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "piece_state")
    private int pieceState;
    @Basic(optional = false)
    @NotNull
    @Column(name = "piece_mark")
    private int pieceMark;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private double price;
    @JoinColumn(name = "piece_type", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TblTypePiece pieceType;
    @JoinColumn(name = "ticke_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TblTicket tickeId;
    @JoinColumn(name = "type_service", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TblService typeService;
    @JoinColumn(name = "piece_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TblPiece pieceId;
    @JoinColumn(name = "piece_color", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TblColor pieceColor;

    public TblDetailsTicket() {
    }

    public TblDetailsTicket(Integer id) {
        this.id = id;
    }

    public TblDetailsTicket(Integer id, int pieceState, int pieceMark, double price) {
        this.id = id;
        this.pieceState = pieceState;
        this.pieceMark = pieceMark;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPieceState() {
        return pieceState;
    }

    public void setPieceState(int pieceState) {
        this.pieceState = pieceState;
    }

    public int getPieceMark() {
        return pieceMark;
    }

    public void setPieceMark(int pieceMark) {
        this.pieceMark = pieceMark;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public TblTypePiece getPieceType() {
        return pieceType;
    }

    public void setPieceType(TblTypePiece pieceType) {
        this.pieceType = pieceType;
    }

    public TblTicket getTickeId() {
        return tickeId;
    }

    public void setTickeId(TblTicket tickeId) {
        this.tickeId = tickeId;
    }

    public TblService getTypeService() {
        return typeService;
    }

    public void setTypeService(TblService typeService) {
        this.typeService = typeService;
    }

    public TblPiece getPieceId() {
        return pieceId;
    }

    public void setPieceId(TblPiece pieceId) {
        this.pieceId = pieceId;
    }

    public TblColor getPieceColor() {
        return pieceColor;
    }

    public void setPieceColor(TblColor pieceColor) {
        this.pieceColor = pieceColor;
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
        if (!(object instanceof TblDetailsTicket)) {
            return false;
        }
        TblDetailsTicket other = (TblDetailsTicket) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dry.entities.TblDetailsTicket[ id=" + id + " ]";
    }
    
}
