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
public class ProductoComercioPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_producto")
    private int idProducto;
    @Basic(optional = false)
    @Column(name = "id_comercio")
    private long idComercio;

    public ProductoComercioPK() {
    }

    public ProductoComercioPK(int idProducto, long idComercio) {
        this.idProducto = idProducto;
        this.idComercio = idComercio;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public long getIdComercio() {
        return idComercio;
    }

    public void setIdComercio(long idComercio) {
        this.idComercio = idComercio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idProducto;
        hash += (int) idComercio;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoComercioPK)) {
            return false;
        }
        ProductoComercioPK other = (ProductoComercioPK) object;
        if (this.idProducto != other.idProducto) {
            return false;
        }
        if (this.idComercio != other.idComercio) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tpi135_2023.ingenieria.occ.ues.edu.sv.delivery.delivery.entity.ProductoComercioPK[ idProducto=" + idProducto + ", idComercio=" + idComercio + " ]";
    }
    
}
