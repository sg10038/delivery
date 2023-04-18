/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tpi135_2023.ingenieria.occ.ues.edu.sv.delivery.delivery.control;

import com.tpi135_2023.ingenieria.occ.ues.edu.sv.delivery.delivery.entity.Comercio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.io.Serializable;

/**
 *
 * @author nesto
 */
public class ComercioBean extends AbstractDataAccess<Comercio>  implements Serializable{
    
    public ComercioBean() {
        super(Comercio.class, "DeliveryTpiUnitPersistence");
    }
    
    public Comercio traerPorIdComercio(int id) throws Exception {
        EntityManager em = this.getEntityManager();
            TypedQuery<Comercio> query = em.createNamedQuery("Comercio.findByIdComercio", Comercio.class);
            query.setParameter("idComercio",id);
            Comercio comercio = query.getSingleResult();
            if(comercio.getIdComercio()  != id){
                throw new Exception("No se encontro");
            }
        return  query.getSingleResult();
    }
    
}
