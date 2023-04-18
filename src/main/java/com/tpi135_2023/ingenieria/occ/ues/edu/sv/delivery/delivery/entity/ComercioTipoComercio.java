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
@Table(name = "comercio_tipo_comercio")
@NamedQueries({
    @NamedQuery(name = "ComercioTipoComercio.findAll", query = "SELECT c FROM ComercioTipoComercio c"),
    @NamedQuery(name = "ComercioTipoComercio.findByIdComercio", query = "SELECT c FROM ComercioTipoComercio c WHERE c.comercioTipoComercioPK.idComercio = :idComercio"),
    @NamedQuery(name = "ComercioTipoComercio.findByIdTipoComercio", query = "SELECT c FROM ComercioTipoComercio c WHERE c.comercioTipoComercioPK.idTipoComercio = :idTipoComercio"),
    @NamedQuery(name = "ComercioTipoComercio.findByActivo", query = "SELECT c FROM ComercioTipoComercio c WHERE c.activo = :activo"),
    @NamedQuery(name = "ComercioTipoComercio.findByFechaCreacion", query = "SELECT c FROM ComercioTipoComercio c WHERE c.fechaCreacion = :fechaCreacion")})
public class ComercioTipoComercio implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ComercioTipoComercioPK comercioTipoComercioPK;
    @Column(name = "activo")
    private Boolean activo;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @JoinColumn(name = "id_comercio", referencedColumnName = "id_comercio", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Comercio comercio;
    @JoinColumn(name = "id_tipo_comercio", referencedColumnName = "id_tipo_comercio", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TipoComercio tipoComercio;

    public ComercioTipoComercio() {
    }

    public ComercioTipoComercio(ComercioTipoComercioPK comercioTipoComercioPK) {
        this.comercioTipoComercioPK = comercioTipoComercioPK;
    }

    public ComercioTipoComercio(int idComercio, int idTipoComercio) {
        this.comercioTipoComercioPK = new ComercioTipoComercioPK(idComercio, idTipoComercio);
    }

    public ComercioTipoComercioPK getComercioTipoComercioPK() {
        return comercioTipoComercioPK;
    }

    public void setComercioTipoComercioPK(ComercioTipoComercioPK comercioTipoComercioPK) {
        this.comercioTipoComercioPK = comercioTipoComercioPK;
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

    public Comercio getComercio() {
        return comercio;
    }

    public void setComercio(Comercio comercio) {
        this.comercio = comercio;
    }

    public TipoComercio getTipoComercio() {
        return tipoComercio;
    }

    public void setTipoComercio(TipoComercio tipoComercio) {
        this.tipoComercio = tipoComercio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (comercioTipoComercioPK != null ? comercioTipoComercioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComercioTipoComercio)) {
            return false;
        }
        ComercioTipoComercio other = (ComercioTipoComercio) object;
        if ((this.comercioTipoComercioPK == null && other.comercioTipoComercioPK != null) || (this.comercioTipoComercioPK != null && !this.comercioTipoComercioPK.equals(other.comercioTipoComercioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tpi135_2023.ingenieria.occ.ues.edu.sv.delivery.delivery.entity.ComercioTipoComercio[ comercioTipoComercioPK=" + comercioTipoComercioPK + " ]";
    }
    
}
