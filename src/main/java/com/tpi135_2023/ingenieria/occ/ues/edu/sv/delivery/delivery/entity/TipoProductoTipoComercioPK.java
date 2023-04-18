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
public class TipoProductoTipoComercioPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_tipo_producto")
    private int idTipoProducto;
    @Basic(optional = false)
    @Column(name = "id_tipo_comercio")
    private int idTipoComercio;

    public TipoProductoTipoComercioPK() {
    }

    public TipoProductoTipoComercioPK(int idTipoProducto, int idTipoComercio) {
        this.idTipoProducto = idTipoProducto;
        this.idTipoComercio = idTipoComercio;
    }

    public int getIdTipoProducto() {
        return idTipoProducto;
    }

    public void setIdTipoProducto(int idTipoProducto) {
        this.idTipoProducto = idTipoProducto;
    }

    public int getIdTipoComercio() {
        return idTipoComercio;
    }

    public void setIdTipoComercio(int idTipoComercio) {
        this.idTipoComercio = idTipoComercio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idTipoProducto;
        hash += (int) idTipoComercio;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoProductoTipoComercioPK)) {
            return false;
        }
        TipoProductoTipoComercioPK other = (TipoProductoTipoComercioPK) object;
        if (this.idTipoProducto != other.idTipoProducto) {
            return false;
        }
        if (this.idTipoComercio != other.idTipoComercio) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tpi135_2023.ingenieria.occ.ues.edu.sv.delivery.delivery.entity.TipoProductoTipoComercioPK[ idTipoProducto=" + idTipoProducto + ", idTipoComercio=" + idTipoComercio + " ]";
    }
    
}
