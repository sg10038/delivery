/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tpi135_2023.ingenieria.occ.ues.edu.sv.delivery.delivery.control;

import com.tpi135_2023.ingenieria.occ.ues.edu.sv.delivery.delivery.entity.TipoComercio;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
/**
 *
 * @author nesto
 */

@Stateless
public class TipoComercioBean extends AbstractDataAccess<TipoComercio>{
    
    public TipoComercioBean() {
        super(TipoComercio.class, "DeliveryTpiUnitPersistence");
    }
    
    public TipoComercio traerPorIdComercio(int id) throws Exception {
        EntityManager em = this.getEntityManager();
            TypedQuery<TipoComercio> query = em.createNamedQuery("TipoComercio.findByIdTipoComercio", TipoComercio.class);
            query.setParameter("idComercio",id);
            TipoComercio comercio = query.getSingleResult();
            if(comercio.getIdTipoComercio()  != id){
                throw new Exception("No se encontro");
            }
        return  query.getSingleResult();
    }
}
