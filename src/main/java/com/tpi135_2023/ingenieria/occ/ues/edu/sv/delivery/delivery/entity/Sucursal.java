/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tpi135_2023.ingenieria.occ.ues.edu.sv.delivery.delivery.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import jakarta.persistence.*;

/**
 *
 * @author nesto
 */
@Entity
@Table(name = "sucursal")
@NamedQueries({
    @NamedQuery(name = "Sucursal.findAll", query = "SELECT s FROM Sucursal s"),
    @NamedQuery(name = "Sucursal.findByIdSucursal", query = "SELECT s FROM Sucursal s WHERE s.idSucursal = :idSucursal"),
    @NamedQuery(name = "Sucursal.findByNombre", query = "SELECT s FROM Sucursal s WHERE s.nombre = :nombre"),
    @NamedQuery(name = "Sucursal.findByPathLogo", query = "SELECT s FROM Sucursal s WHERE s.pathLogo = :pathLogo"),
    @NamedQuery(name = "Sucursal.findByIdDireccion", query = "SELECT s FROM Sucursal s WHERE s.idDireccion = :idDireccion")})
public class Sucursal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sucursal")
    private Integer idSucursal;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "path_logo")
    private String pathLogo;
    @Column(name = "id_direccion")
    private BigInteger idDireccion;
    @JoinColumn(name = "id_comercio", referencedColumnName = "id_comercio")
    @ManyToOne
    private Comercio idComercio;
    @OneToMany(mappedBy = "idSucursal")
    private List<Orden> ordenList;

    public Sucursal() {
    }

    public Sucursal(Integer idSucursal) {
        this.idSucursal = idSucursal;
    }

    public Sucursal(Integer idSucursal, String nombre) {
        this.idSucursal = idSucursal;
        this.nombre = nombre;
    }

    public Integer getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Integer idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPathLogo() {
        return pathLogo;
    }

    public void setPathLogo(String pathLogo) {
        this.pathLogo = pathLogo;
    }

    public BigInteger getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(BigInteger idDireccion) {
        this.idDireccion = idDireccion;
    }

    public Comercio getIdComercio() {
        return idComercio;
    }

    public void setIdComercio(Comercio idComercio) {
        this.idComercio = idComercio;
    }

    public List<Orden> getOrdenList() {
        return ordenList;
    }

    public void setOrdenList(List<Orden> ordenList) {
        this.ordenList = ordenList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSucursal != null ? idSucursal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sucursal)) {
            return false;
        }
        Sucursal other = (Sucursal) object;
        if ((this.idSucursal == null && other.idSucursal != null) || (this.idSucursal != null && !this.idSucursal.equals(other.idSucursal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tpi135_2023.ingenieria.occ.ues.edu.sv.delivery.delivery.entity.Sucursal[ idSucursal=" + idSucursal + " ]";
    }
    
}
