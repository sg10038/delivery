/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tpi135_2023.ingenieria.occ.ues.edu.sv.delivery.delivery.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import jakarta.persistence.*;

/**
 *
 * @author nesto
 */
@Entity
@Table(name = "orden")
@NamedQueries({
    @NamedQuery(name = "Orden.findAll", query = "SELECT o FROM Orden o"),
    @NamedQuery(name = "Orden.findByIdOrden", query = "SELECT o FROM Orden o WHERE o.idOrden = :idOrden"),
    @NamedQuery(name = "Orden.findByFechaOrden", query = "SELECT o FROM Orden o WHERE o.fechaOrden = :fechaOrden"),
    @NamedQuery(name = "Orden.findByObservaciones", query = "SELECT o FROM Orden o WHERE o.observaciones = :observaciones"),
    @NamedQuery(name = "Orden.findByIdDireccion", query = "SELECT o FROM Orden o WHERE o.idDireccion = :idDireccion")})
public class Orden implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_orden")
    private Long idOrden;
    @Column(name = "fecha_orden")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaOrden;
    @Column(name = "observaciones")
    private String observaciones;
    @Column(name = "id_direccion")
    private BigInteger idDireccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orden")
    private List<OrdenDetalle> ordenDetalleList;
    @OneToMany(mappedBy = "idOrden")
    private List<Factura> facturaList;
    @OneToMany(mappedBy = "idOrden")
    private List<OrdenEstado> ordenEstadoList;
    @OneToMany(mappedBy = "idOrden")
    private List<Entrega> entregaList;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne
    private Cliente idCliente;
    @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal")
    @ManyToOne
    private Sucursal idSucursal;

    public Orden() {
    }

    public Orden(Long idOrden) {
        this.idOrden = idOrden;
    }

    public Long getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Long idOrden) {
        this.idOrden = idOrden;
    }

    public Date getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(Date fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public BigInteger getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(BigInteger idDireccion) {
        this.idDireccion = idDireccion;
    }

    public List<OrdenDetalle> getOrdenDetalleList() {
        return ordenDetalleList;
    }

    public void setOrdenDetalleList(List<OrdenDetalle> ordenDetalleList) {
        this.ordenDetalleList = ordenDetalleList;
    }

    public List<Factura> getFacturaList() {
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }

    public List<OrdenEstado> getOrdenEstadoList() {
        return ordenEstadoList;
    }

    public void setOrdenEstadoList(List<OrdenEstado> ordenEstadoList) {
        this.ordenEstadoList = ordenEstadoList;
    }

    public List<Entrega> getEntregaList() {
        return entregaList;
    }

    public void setEntregaList(List<Entrega> entregaList) {
        this.entregaList = entregaList;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Sucursal getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Sucursal idSucursal) {
        this.idSucursal = idSucursal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrden != null ? idOrden.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orden)) {
            return false;
        }
        Orden other = (Orden) object;
        if ((this.idOrden == null && other.idOrden != null) || (this.idOrden != null && !this.idOrden.equals(other.idOrden))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tpi135_2023.ingenieria.occ.ues.edu.sv.delivery.delivery.entity.Orden[ idOrden=" + idOrden + " ]";
    }
    
}
