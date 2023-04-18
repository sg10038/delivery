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
@Table(name = "producto_tipo_producto")
@NamedQueries({
    @NamedQuery(name = "ProductoTipoProducto.findAll", query = "SELECT p FROM ProductoTipoProducto p"),
    @NamedQuery(name = "ProductoTipoProducto.findByIdProducto", query = "SELECT p FROM ProductoTipoProducto p WHERE p.productoTipoProductoPK.idProducto = :idProducto"),
    @NamedQuery(name = "ProductoTipoProducto.findByIdTipoProducto", query = "SELECT p FROM ProductoTipoProducto p WHERE p.productoTipoProductoPK.idTipoProducto = :idTipoProducto"),
    @NamedQuery(name = "ProductoTipoProducto.findByActivo", query = "SELECT p FROM ProductoTipoProducto p WHERE p.activo = :activo"),
    @NamedQuery(name = "ProductoTipoProducto.findByFechaCreacion", query = "SELECT p FROM ProductoTipoProducto p WHERE p.fechaCreacion = :fechaCreacion")})
public class ProductoTipoProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductoTipoProductoPK productoTipoProductoPK;
    @Column(name = "activo")
    private Boolean activo;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto;
    @JoinColumn(name = "id_tipo_producto", referencedColumnName = "id_tipo_producto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TipoProducto tipoProducto;

    public ProductoTipoProducto() {
    }

    public ProductoTipoProducto(ProductoTipoProductoPK productoTipoProductoPK) {
        this.productoTipoProductoPK = productoTipoProductoPK;
    }

    public ProductoTipoProducto(int idProducto, int idTipoProducto) {
        this.productoTipoProductoPK = new ProductoTipoProductoPK(idProducto, idTipoProducto);
    }

    public ProductoTipoProductoPK getProductoTipoProductoPK() {
        return productoTipoProductoPK;
    }

    public void setProductoTipoProductoPK(ProductoTipoProductoPK productoTipoProductoPK) {
        this.productoTipoProductoPK = productoTipoProductoPK;
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

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
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
        hash += (productoTipoProductoPK != null ? productoTipoProductoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoTipoProducto)) {
            return false;
        }
        ProductoTipoProducto other = (ProductoTipoProducto) object;
        if ((this.productoTipoProductoPK == null && other.productoTipoProductoPK != null) || (this.productoTipoProductoPK != null && !this.productoTipoProductoPK.equals(other.productoTipoProductoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tpi135_2023.ingenieria.occ.ues.edu.sv.delivery.delivery.entity.ProductoTipoProducto[ productoTipoProductoPK=" + productoTipoProductoPK + " ]";
    }
    
}
