/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tpi135_2023.ingenieria.occ.ues.edu.sv.delivery.delivery.entity;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 *
 * @author nesto
 */
@Embeddable
public class OrdenDetallePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_orden")
    private long idOrden;
    @Basic(optional = false)
    @Column(name = "id_menu")
    private long idMenu;

    public OrdenDetallePK() {
    }

    public OrdenDetallePK(long idOrden, long idMenu) {
        this.idOrden = idOrden;
        this.idMenu = idMenu;
    }

    public long getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(long idOrden) {
        this.idOrden = idOrden;
    }

    public long getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(long idMenu) {
        this.idMenu = idMenu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idOrden;
        hash += (int) idMenu;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenDetallePK)) {
            return false;
        }
        OrdenDetallePK other = (OrdenDetallePK) object;
        if (this.idOrden != other.idOrden) {
            return false;
        }
        if (this.idMenu != other.idMenu) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tpi135_2023.ingenieria.occ.ues.edu.sv.delivery.delivery.entity.OrdenDetallePK[ idOrden=" + idOrden + ", idMenu=" + idMenu + " ]";
    }
    
}
