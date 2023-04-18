/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tpi135_2023.ingenieria.occ.ues.edu.sv.delivery.delivery.control;

import com.tpi135_2023.ingenieria.occ.ues.edu.sv.delivery.delivery.entity.Producto;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nesto
 */

@Stateless
public class ProductoBean extends AbstractDataAccess<Producto> implements Serializable {

public ProductoBean() {
        super(Producto.class, "DeliveryTpiUnitPersistence");
    }

    
    public Producto traerPorIdProducto(int id) throws Exception {
        List<Producto> p = new ArrayList<>();
        EntityManager em = this.getEntityManager();
        
        if (em != null) {
            TypedQuery<Producto> query = em.createNamedQuery("Producto.findByIdProducto", Producto.class);
            query.setParameter("idProducto",id);
            
            return query.getSingleResult();
        }
        return null;
    }
    
    public List<Producto> buscarPorNombre(String nombre) throws Exception{
        List<Producto> p = new ArrayList<>();
        EntityManager em = this.getEntityManager();
        if(em != null){
            TypedQuery<Producto> query  = em.createNamedQuery("Producto.findByNombre",Producto.class);
            query.setParameter("nombre", nombre);
            p = query.getResultList();
           
            return  p;
        }
        return p;
    }
    
    public List<Producto> buscarPorActivo(boolean estado) throws Exception{
        List<Producto> p = new ArrayList<>();
        EntityManager em = this.getEntityManager();
        if(em != null){
            TypedQuery<Producto> query = em.createNamedQuery("Producto.findByActivo", Producto.class);
            query.setParameter("activo", estado);
            p = query.getResultList();
            return p;
        }
        return p;
    }
    
    public List<Producto> buscarPorDescripcion(String descripcion) throws Exception{
        List<Producto> p = new ArrayList<>();
        EntityManager em = this.getEntityManager();
        if(em != null){
            TypedQuery<Producto> query = em.createNamedQuery("Producto.findByDescripcion", Producto.class);
            query.setParameter("activo", descripcion);
            p = query.getResultList();
            return p;
        }
        return p;
    }
    
}
