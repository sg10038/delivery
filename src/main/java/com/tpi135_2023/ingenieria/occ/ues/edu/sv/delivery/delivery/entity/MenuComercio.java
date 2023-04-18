/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tpi135_2023.ingenieria.occ.ues.edu.sv.delivery.delivery.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import jakarta.persistence.*;

/**
 *
 * @author nesto
 */
@Entity
@Table(name = "menu_comercio")
@NamedQueries({
    @NamedQuery(name = "MenuComercio.findAll", query = "SELECT m FROM MenuComercio m"),
    @NamedQuery(name = "MenuComercio.findByIdMenu", query = "SELECT m FROM MenuComercio m WHERE m.idMenu = :idMenu"),
    @NamedQuery(name = "MenuComercio.findByNombre", query = "SELECT m FROM MenuComercio m WHERE m.nombre = :nombre"),
    @NamedQuery(name = "MenuComercio.findByDescripcion", query = "SELECT m FROM MenuComercio m WHERE m.descripcion = :descripcion"),
    @NamedQuery(name = "MenuComercio.findByPrecioBase", query = "SELECT m FROM MenuComercio m WHERE m.precioBase = :precioBase")})
public class MenuComercio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_menu")
    private Long idMenu;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio_base")
    private BigDecimal precioBase;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menuComercio")
    private List<OrdenDetalle> ordenDetalleList;
    @JoinColumns({
        @JoinColumn(name = "id_comercio", referencedColumnName = "id_comercio"),
        @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")})
    @ManyToOne
    private ProductoComercio productoComercio;

    public MenuComercio() {
    }

    public MenuComercio(Long idMenu) {
        this.idMenu = idMenu;
    }

    public Long getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Long idMenu) {
        this.idMenu = idMenu;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(BigDecimal precioBase) {
        this.precioBase = precioBase;
    }

    public List<OrdenDetalle> getOrdenDetalleList() {
        return ordenDetalleList;
    }

    public void setOrdenDetalleList(List<OrdenDetalle> ordenDetalleList) {
        this.ordenDetalleList = ordenDetalleList;
    }

    public ProductoComercio getProductoComercio() {
        return productoComercio;
    }

    public void setProductoComercio(ProductoComercio productoComercio) {
        this.productoComercio = productoComercio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMenu != null ? idMenu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MenuComercio)) {
            return false;
        }
        MenuComercio other = (MenuComercio) object;
        if ((this.idMenu == null && other.idMenu != null) || (this.idMenu != null && !this.idMenu.equals(other.idMenu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tpi135_2023.ingenieria.occ.ues.edu.sv.delivery.delivery.entity.MenuComercio[ idMenu=" + idMenu + " ]";
    }
    
}
