/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tpi135_2023.ingenieria.occ.ues.edu.sv.delivery.delivery.entity;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.*;
/**
 *
 * @author nesto
 */
@Entity
@Table(name = "comercio")
@NamedQueries({
    @NamedQuery(name = "Comercio.findAll", query = "SELECT c FROM Comercio c"),
    @NamedQuery(name = "Comercio.findByIdComercio", query = "SELECT c FROM Comercio c WHERE c.idComercio = :idComercio"),
    @NamedQuery(name = "Comercio.findByNombre", query = "SELECT c FROM Comercio c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Comercio.findByActivo", query = "SELECT c FROM Comercio c WHERE c.activo = :activo"),
    @NamedQuery(name = "Comercio.findByDescripcion", query = "SELECT c FROM Comercio c WHERE c.descripcion = :descripcion")})
public class Comercio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_comercio")
    private Long idComercio;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "activo")
    private Boolean activo;
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comercio")
    private List<ComercioTipoComercio> comercioTipoComercioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comercio")
    private List<ProductoComercio> productoComercioList;
    @OneToMany(mappedBy = "idComercio")
    private List<Sucursal> sucursalList;

    public Comercio() {
    }

    public Comercio(Long idComercio) {
        this.idComercio = idComercio;
    }

    public Long getIdComercio() {
        return idComercio;
    }

    public void setIdComercio(Long idComercio) {
        this.idComercio = idComercio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<ComercioTipoComercio> getComercioTipoComercioList() {
        return comercioTipoComercioList;
    }

    public void setComercioTipoComercioList(List<ComercioTipoComercio> comercioTipoComercioList) {
        this.comercioTipoComercioList = comercioTipoComercioList;
    }

    public List<ProductoComercio> getProductoComercioList() {
        return productoComercioList;
    }

    public void setProductoComercioList(List<ProductoComercio> productoComercioList) {
        this.productoComercioList = productoComercioList;
    }

    public List<Sucursal> getSucursalList() {
        return sucursalList;
    }

    public void setSucursalList(List<Sucursal> sucursalList) {
        this.sucursalList = sucursalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComercio != null ? idComercio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comercio)) {
            return false;
        }
        Comercio other = (Comercio) object;
        if ((this.idComercio == null && other.idComercio != null) || (this.idComercio != null && !this.idComercio.equals(other.idComercio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tpi135_2023.ingenieria.occ.ues.edu.sv.delivery.delivery.entity.Comercio[ idComercio=" + idComercio + " ]";
    }
    
}
