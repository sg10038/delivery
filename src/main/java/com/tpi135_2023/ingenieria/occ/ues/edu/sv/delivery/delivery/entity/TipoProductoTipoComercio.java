/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tpi135_2023.ingenieria.occ.ues.edu.sv.delivery.delivery.entity;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.*;

/**
 *
 * @author nesto
 */
@Entity
@Table(name = "tipo_producto_tipo_comercio")
@NamedQueries({
    @NamedQuery(name = "TipoProductoTipoComercio.findAll", query = "SELECT t FROM TipoProductoTipoComercio t"),
    @NamedQuery(name = "TipoProductoTipoComercio.findByIdTipoProducto", query = "SELECT t FROM TipoProductoTipoComercio t WHERE t.tipoProductoTipoComercioPK.idTipoProducto = :idTipoProducto"),
    @NamedQuery(name = "TipoProductoTipoComercio.findByIdTipoComercio", query = "SELECT t FROM TipoProductoTipoComercio t WHERE t.tipoProductoTipoComercioPK.idTipoComercio = :idTipoComercio"),
    @NamedQuery(name = "TipoProductoTipoComercio.findByActivo", query = "SELECT t FROM TipoProductoTipoComercio t WHERE t.activo = :activo"),
    @NamedQuery(name = "TipoProductoTipoComercio.findByFechaCreacion", query = "SELECT t FROM TipoProductoTipoComercio t WHERE t.fechaCreacion = :fechaCreacion")})
public class TipoProductoTipoComercio implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TipoProductoTipoComercioPK tipoProductoTipoComercioPK;
    @Column(name = "activo")
    private Boolean activo;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @JoinColumn(name = "id_tipo_comercio", referencedColumnName = "id_tipo_comercio", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TipoComercio tipoComercio;
    @JoinColumn(name = "id_tipo_producto", referencedColumnName = "id_tipo_producto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TipoProducto tipoProducto;

    public TipoProductoTipoComercio() {
    }

    public TipoProductoTipoComercio(TipoProductoTipoComercioPK tipoProductoTipoComercioPK) {
        this.tipoProductoTipoComercioPK = tipoProductoTipoComercioPK;
    }

    public TipoProductoTipoComercio(int idTipoProducto, int idTipoComercio) {
        this.tipoProductoTipoComercioPK = new TipoProductoTipoComercioPK(idTipoProducto, idTipoComercio);
    }

    public TipoProductoTipoComercioPK getTipoProductoTipoComercioPK() {
        return tipoProductoTipoComercioPK;
    }

    public void setTipoProductoTipoComercioPK(TipoProductoTipoComercioPK tipoProductoTipoComercioPK) {
        this.tipoProductoTipoComercioPK = tipoProductoTipoComercioPK;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public TipoComercio getTipoComercio() {
        return tipoComercio;
    }

    public void setTipoComercio(TipoComercio tipoComercio) {
        this.tipoComercio = tipoComercio;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoProductoTipoComercioPK != null ? tipoProductoTipoComercioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoProductoTipoComercio)) {
            return false;
        }
        TipoProductoTipoComercio other = (TipoProductoTipoComercio) object;
        if ((this.tipoProductoTipoComercioPK == null && other.tipoProductoTipoComercioPK != null) || (this.tipoProductoTipoComercioPK != null && !this.tipoProductoTipoComercioPK.equals(other.tipoProductoTipoComercioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tpi135_2023.ingenieria.occ.ues.edu.sv.delivery.delivery.entity.TipoProductoTipoComercio[ tipoProductoTipoComercioPK=" + tipoProductoTipoComercioPK + " ]";
    }
    
}
