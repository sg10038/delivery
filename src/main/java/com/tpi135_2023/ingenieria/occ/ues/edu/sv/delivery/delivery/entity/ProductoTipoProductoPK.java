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
public class ProductoTipoProductoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_producto")
    private int idProducto;
    @Basic(optional = false)
    @Column(name = "id_tipo_producto")
    private int idTipoProducto;

    public ProductoTipoProductoPK() {
    }

    public ProductoTipoProductoPK(int idProducto, int idTipoProducto) {
        this.idProducto = idProducto;
        this.idTipoProducto = idTipoProducto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdTipoProducto() {
        return idTipoProducto;
    }

    public void setIdTipoProducto(int idTipoProducto) {
        this.idTipoProducto = idTipoProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idProducto;
        hash += (int) idTipoProducto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoTipoProductoPK)) {
            return false;
        }
        ProductoTipoProductoPK other = (ProductoTipoProductoPK) object;
        if (this.idProducto != other.idProducto) {
            return false;
        }
        if (this.idTipoProducto != other.idTipoProducto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tpi135_2023.ingenieria.occ.ues.edu.sv.delivery.delivery.entity.ProductoTipoProductoPK[ idProducto=" + idProducto + ", idTipoProducto=" + idTipoProducto + " ]";
    }
    
}
