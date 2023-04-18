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
@Table(name = "entrega")
@NamedQueries({
    @NamedQuery(name = "Entrega.findAll", query = "SELECT e FROM Entrega e"),
    @NamedQuery(name = "Entrega.findByIdEntrega", query = "SELECT e FROM Entrega e WHERE e.idEntrega = :idEntrega"),
    @NamedQuery(name = "Entrega.findByFechaCreacion", query = "SELECT e FROM Entrega e WHERE e.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "Entrega.findByObservaciones", query = "SELECT e FROM Entrega e WHERE e.observaciones = :observaciones")})
public class Entrega implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_entrega")
    private Long idEntrega;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "observaciones")
    private String observaciones;
    @OneToMany(mappedBy = "idEntrega")
    private List<EntregaHistorial> entregaHistorialList;
    @JoinColumn(name = "id_orden", referencedColumnName = "id_orden")
    @ManyToOne
    private Orden idOrden;
    @JoinColumn(name = "id_repartidor", referencedColumnName = "id_repartidor")
    @ManyToOne
    private Repartidor idRepartidor;
    @JoinColumn(name = "id_vehiculo", referencedColumnName = "id_vehiculo")
    @ManyToOne
    private Vehiculo idVehiculo;

    public Entrega() {
    }

    public Entrega(Long idEntrega) {
        this.idEntrega = idEntrega;
    }

    public Long getIdEntrega() {
        return idEntrega;
    }

    public void setIdEntrega(Long idEntrega) {
        this.idEntrega = idEntrega;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public List<EntregaHistorial> getEntregaHistorialList() {
        return entregaHistorialList;
    }

    public void setEntregaHistorialList(List<EntregaHistorial> entregaHistorialList) {
        this.entregaHistorialList = entregaHistorialList;
    }

    public Orden getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Orden idOrden) {
        this.idOrden = idOrden;
    }

    public Repartidor getIdRepartidor() {
        return idRepartidor;
    }

    public void setIdRepartidor(Repartidor idRepartidor) {
        this.idRepartidor = idRepartidor;
    }

    public Vehiculo getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Vehiculo idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEntrega != null ? idEntrega.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entrega)) {
            return false;
        }
        Entrega other = (Entrega) object;
        if ((this.idEntrega == null && other.idEntrega != null) || (this.idEntrega != null && !this.idEntrega.equals(other.idEntrega))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tpi135_2023.ingenieria.occ.ues.edu.sv.delivery.delivery.entity.Entrega[ idEntrega=" + idEntrega + " ]";
    }
    
}
