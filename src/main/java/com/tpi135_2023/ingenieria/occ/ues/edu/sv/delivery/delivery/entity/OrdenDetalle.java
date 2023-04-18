/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tpi135_2023.ingenieria.occ.ues.edu.sv.delivery.delivery.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import jakarta.persistence.*;

/**
 *
 * @author nesto
 */
@Entity
@Table(name = "orden_detalle")
@NamedQueries({
    @NamedQuery(name = "OrdenDetalle.findAll", query = "SELECT o FROM OrdenDetalle o"),
    @NamedQuery(name = "OrdenDetalle.findByIdOrden", query = "SELECT o FROM OrdenDetalle o WHERE o.ordenDetallePK.idOrden = :idOrden"),
    @NamedQuery(name = "OrdenDetalle.findByIdMenu", query = "SELECT o FROM OrdenDetalle o WHERE o.ordenDetallePK.idMenu = :idMenu"),
    @NamedQuery(name = "OrdenDetalle.findByCantidad", query = "SELECT o FROM OrdenDetalle o WHERE o.cantidad = :cantidad"),
    @NamedQuery(name = "OrdenDetalle.findByPrecio", query = "SELECT o FROM OrdenDetalle o WHERE o.precio = :precio"),
    @NamedQuery(name = "OrdenDetalle.findByObservaciones", query = "SELECT o FROM OrdenDetalle o WHERE o.observaciones = :observaciones")})
public class OrdenDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrdenDetallePK ordenDetallePK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cantidad")
    private BigDecimal cantidad;
    @Column(name = "precio")
    private BigDecimal precio;
    @Column(name = "observaciones")
    private String observaciones;
    @JoinColumn(name = "id_menu", referencedColumnName = "id_menu", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private MenuComercio menuComercio;
    @JoinColumn(name = "id_orden", referencedColumnName = "id_orden", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Orden orden;

    public OrdenDetalle() {
    }

    public OrdenDetalle(OrdenDetallePK ordenDetallePK) {
        this.ordenDetallePK = ordenDetallePK;
    }

    public OrdenDetalle(long idOrden, long idMenu) {
        this.ordenDetallePK = new OrdenDetallePK(idOrden, idMenu);
    }

    public OrdenDetallePK getOrdenDetallePK() {
        return ordenDetallePK;
    }

    public void setOrdenDetallePK(OrdenDetallePK ordenDetallePK) {
        this.ordenDetallePK = ordenDetallePK;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public MenuComercio getMenuComercio() {
        return menuComercio;
    }

    public void setMenuComercio(MenuComercio menuComercio) {
        this.menuComercio = menuComercio;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ordenDetallePK != null ? ordenDetallePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenDetalle)) {
            return false;
        }
        OrdenDetalle other = (OrdenDetalle) object;
        if ((this.ordenDetallePK == null && other.ordenDetallePK != null) || (this.ordenDetallePK != null && !this.ordenDetallePK.equals(other.ordenDetallePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tpi135_2023.ingenieria.occ.ues.edu.sv.delivery.delivery.entity.OrdenDetalle[ ordenDetallePK=" + ordenDetallePK + " ]";
    }
    
}
