/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tpi135_2023.ingenieria.occ.ues.edu.sv.delivery.delivery.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import jakarta.persistence.*;
/**
 *
 * @author nesto
 */
@Entity
@Table(name = "direccion")
@NamedQueries({
    @NamedQuery(name = "Direccion.findAll", query = "SELECT d FROM Direccion d"),
    @NamedQuery(name = "Direccion.findByIdDireccion", query = "SELECT d FROM Direccion d WHERE d.idDireccion = :idDireccion"),
    @NamedQuery(name = "Direccion.findByDireccion", query = "SELECT d FROM Direccion d WHERE d.direccion = :direccion"),
    @NamedQuery(name = "Direccion.findByReferencias", query = "SELECT d FROM Direccion d WHERE d.referencias = :referencias"),
    @NamedQuery(name = "Direccion.findByLongitud", query = "SELECT d FROM Direccion d WHERE d.longitud = :longitud"),
    @NamedQuery(name = "Direccion.findByLatitud", query = "SELECT d FROM Direccion d WHERE d.latitud = :latitud")})
public class Direccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_direccion")
    private Long idDireccion;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "referencias")
    private String referencias;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "longitud")
    private BigDecimal longitud;
    @Column(name = "latitud")
    private BigDecimal latitud;
    @JoinColumn(name = "id_territorio", referencedColumnName = "id_territorio")
    @ManyToOne
    private Territorio idTerritorio;

    public Direccion() {
    }

    public Direccion(Long idDireccion) {
        this.idDireccion = idDireccion;
    }

    public Long getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Long idDireccion) {
        this.idDireccion = idDireccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getReferencias() {
        return referencias;
    }

    public void setReferencias(String referencias) {
        this.referencias = referencias;
    }

    public BigDecimal getLongitud() {
        return longitud;
    }

    public void setLongitud(BigDecimal longitud) {
        this.longitud = longitud;
    }

    public BigDecimal getLatitud() {
        return latitud;
    }

    public void setLatitud(BigDecimal latitud) {
        this.latitud = latitud;
    }

    public Territorio getIdTerritorio() {
        return idTerritorio;
    }

    public void setIdTerritorio(Territorio idTerritorio) {
        this.idTerritorio = idTerritorio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDireccion != null ? idDireccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Direccion)) {
            return false;
        }
        Direccion other = (Direccion) object;
        if ((this.idDireccion == null && other.idDireccion != null) || (this.idDireccion != null && !this.idDireccion.equals(other.idDireccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tpi135_2023.ingenieria.occ.ues.edu.sv.delivery.delivery.entity.Direccion[ idDireccion=" + idDireccion + " ]";
    }
    
}
