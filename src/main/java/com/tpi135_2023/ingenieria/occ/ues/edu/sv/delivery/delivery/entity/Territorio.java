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
@Table(name = "territorio")
@NamedQueries({
    @NamedQuery(name = "Territorio.findAll", query = "SELECT t FROM Territorio t"),
    @NamedQuery(name = "Territorio.findByIdTerritorio", query = "SELECT t FROM Territorio t WHERE t.idTerritorio = :idTerritorio"),
    @NamedQuery(name = "Territorio.findByNombre", query = "SELECT t FROM Territorio t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "Territorio.findByTextoVisible", query = "SELECT t FROM Territorio t WHERE t.textoVisible = :textoVisible"),
    @NamedQuery(name = "Territorio.findByHijosObligatorios", query = "SELECT t FROM Territorio t WHERE t.hijosObligatorios = :hijosObligatorios")})
public class Territorio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_territorio")
    private Integer idTerritorio;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "texto_visible")
    private String textoVisible;
    @Column(name = "hijos_obligatorios")
    private Integer hijosObligatorios;
    @OneToMany(mappedBy = "idTerritorio")
    private List<Direccion> direccionList;
    @OneToMany(mappedBy = "idTerritorioPadre")
    private List<Territorio> territorioList;
    @JoinColumn(name = "id_territorio_padre", referencedColumnName = "id_territorio")
    @ManyToOne
    private Territorio idTerritorioPadre;

    public Territorio() {
    }

    public Territorio(Integer idTerritorio) {
        this.idTerritorio = idTerritorio;
    }

    public Integer getIdTerritorio() {
        return idTerritorio;
    }

    public void setIdTerritorio(Integer idTerritorio) {
        this.idTerritorio = idTerritorio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTextoVisible() {
        return textoVisible;
    }

    public void setTextoVisible(String textoVisible) {
        this.textoVisible = textoVisible;
    }

    public Integer getHijosObligatorios() {
        return hijosObligatorios;
    }

    public void setHijosObligatorios(Integer hijosObligatorios) {
        this.hijosObligatorios = hijosObligatorios;
    }

    public List<Direccion> getDireccionList() {
        return direccionList;
    }

    public void setDireccionList(List<Direccion> direccionList) {
        this.direccionList = direccionList;
    }

    public List<Territorio> getTerritorioList() {
        return territorioList;
    }

    public void setTerritorioList(List<Territorio> territorioList) {
        this.territorioList = territorioList;
    }

    public Territorio getIdTerritorioPadre() {
        return idTerritorioPadre;
    }

    public void setIdTerritorioPadre(Territorio idTerritorioPadre) {
        this.idTerritorioPadre = idTerritorioPadre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTerritorio != null ? idTerritorio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Territorio)) {
            return false;
        }
        Territorio other = (Territorio) object;
        if ((this.idTerritorio == null && other.idTerritorio != null) || (this.idTerritorio != null && !this.idTerritorio.equals(other.idTerritorio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tpi135_2023.ingenieria.occ.ues.edu.sv.delivery.delivery.entity.Territorio[ idTerritorio=" + idTerritorio + " ]";
    }
    
}
