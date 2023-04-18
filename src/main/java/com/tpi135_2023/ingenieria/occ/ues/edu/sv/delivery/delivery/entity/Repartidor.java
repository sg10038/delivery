/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tpi135_2023.ingenieria.occ.ues.edu.sv.delivery.delivery.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import jakarta.persistence.*;

/**
 *
 * @author nesto
 */
@Entity
@Table(name = "repartidor")
@NamedQueries({
    @NamedQuery(name = "Repartidor.findAll", query = "SELECT r FROM Repartidor r"),
    @NamedQuery(name = "Repartidor.findByIdRepartidor", query = "SELECT r FROM Repartidor r WHERE r.idRepartidor = :idRepartidor"),
    @NamedQuery(name = "Repartidor.findByNombres", query = "SELECT r FROM Repartidor r WHERE r.nombres = :nombres"),
    @NamedQuery(name = "Repartidor.findByApellidos", query = "SELECT r FROM Repartidor r WHERE r.apellidos = :apellidos"),
    @NamedQuery(name = "Repartidor.findByTipoLicencia", query = "SELECT r FROM Repartidor r WHERE r.tipoLicencia = :tipoLicencia"),
    @NamedQuery(name = "Repartidor.findByFechaNacimiento", query = "SELECT r FROM Repartidor r WHERE r.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Repartidor.findByActivo", query = "SELECT r FROM Repartidor r WHERE r.activo = :activo"),
    @NamedQuery(name = "Repartidor.findByObservaciones", query = "SELECT r FROM Repartidor r WHERE r.observaciones = :observaciones")})
public class Repartidor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_repartidor")
    private Long idRepartidor;
    @Column(name = "nombres")
    private String nombres;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "tipo_licencia")
    private String tipoLicencia;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Column(name = "activo")
    private Boolean activo;
    @Column(name = "observaciones")
    private String observaciones;
    @OneToMany(mappedBy = "idRepartidor")
    private List<Entrega> entregaList;

    public Repartidor() {
    }

    public Repartidor(Long idRepartidor) {
        this.idRepartidor = idRepartidor;
    }

    public Long getIdRepartidor() {
        return idRepartidor;
    }

    public void setIdRepartidor(Long idRepartidor) {
        this.idRepartidor = idRepartidor;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTipoLicencia() {
        return tipoLicencia;
    }

    public void setTipoLicencia(String tipoLicencia) {
        this.tipoLicencia = tipoLicencia;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public List<Entrega> getEntregaList() {
        return entregaList;
    }

    public void setEntregaList(List<Entrega> entregaList) {
        this.entregaList = entregaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRepartidor != null ? idRepartidor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Repartidor)) {
            return false;
        }
        Repartidor other = (Repartidor) object;
        if ((this.idRepartidor == null && other.idRepartidor != null) || (this.idRepartidor != null && !this.idRepartidor.equals(other.idRepartidor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tpi135_2023.ingenieria.occ.ues.edu.sv.delivery.delivery.entity.Repartidor[ idRepartidor=" + idRepartidor + " ]";
    }
    
}
