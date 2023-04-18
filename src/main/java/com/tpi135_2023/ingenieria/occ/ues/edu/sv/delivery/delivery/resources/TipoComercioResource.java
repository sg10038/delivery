/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tpi135_2023.ingenieria.occ.ues.edu.sv.delivery.delivery.resources;

import com.tpi135_2023.ingenieria.occ.ues.edu.sv.delivery.delivery.control.AbstractDataAccess;
import com.tpi135_2023.ingenieria.occ.ues.edu.sv.delivery.delivery.control.TipoComercioBean;
import com.tpi135_2023.ingenieria.occ.ues.edu.sv.delivery.delivery.entity.TipoComercio;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 *
 * @author nesto
 */
public class TipoComercioResource extends AbstracRestResources<TipoComercio> {

    @Inject
    TipoComercioBean tcb;

    @Override
    protected AbstractDataAccess<TipoComercio> getDataAccesBean() {
        return this.tcb;
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response ingresar(TipoComercio entidad) {
        
        Response.ResponseBuilder rb;
        if (entidad == null) {
            rb = Response.status(Response.Status.BAD_REQUEST);
            rb.header("Content-Type", MediaType.APPLICATION_JSON);
            rb.header("deny", MediaType.APPLICATION_JSON);
            rb.entity(entidad);
            return rb.build();
        }
        try {
            TipoComercio entidadCreada = this.getDataAccesBean().Ingresar(entidad);
            rb = Response.status(Response.Status.CREATED);
            rb.header("Content-Type", MediaType.APPLICATION_JSON);
            rb.header("location", "comercio/" + entidadCreada.getIdTipoComercio());
            rb.entity(entidadCreada);
            return rb.build();

        } catch (Exception e) {
            rb = Response.noContent();
            rb.header("Content-Type", MediaType.APPLICATION_JSON);
            rb.header("deny", MediaType.APPLICATION_JSON);
            rb.entity(entidad);
        }
        return rb.build();
    }

}
