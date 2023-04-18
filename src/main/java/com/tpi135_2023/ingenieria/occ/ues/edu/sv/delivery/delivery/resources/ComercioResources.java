/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tpi135_2023.ingenieria.occ.ues.edu.sv.delivery.delivery.resources;

import com.tpi135_2023.ingenieria.occ.ues.edu.sv.delivery.delivery.boundary.RestResourcePattern;
import com.tpi135_2023.ingenieria.occ.ues.edu.sv.delivery.delivery.control.AbstractDataAccess;
import com.tpi135_2023.ingenieria.occ.ues.edu.sv.delivery.delivery.control.ComercioBean;
import com.tpi135_2023.ingenieria.occ.ues.edu.sv.delivery.delivery.entity.Comercio;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


/**
 *
 * @author nesto
 */
public class ComercioResources extends AbstracRestResources<Comercio>{
    
    @Inject ComercioBean cb;
    
    /**
     *
     * @return
     */
    @Override
    protected AbstractDataAccess<Comercio> getDataAccesBean() {
        return this.cb;
    }
    

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response ingresar(Comercio entidad) {
        
        Response.ResponseBuilder rb;
        if(entidad == null){
            rb = Response.status(Response.Status.BAD_GATEWAY);
            rb.header("Content-Type", MediaType.APPLICATION_JSON);
            rb.header("deny", MediaType.APPLICATION_JSON);
            rb.entity(entidad);
            return rb.build();   
        }
        try {
            Comercio entidadCreada = this.getDataAccesBean().Ingresar(entidad);
            rb = Response.status(Response.Status.CREATED);
            rb.header("Content-Type", MediaType.APPLICATION_JSON);
            rb.header("location", "comercio/"+entidadCreada.getIdComercio());
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
    
    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") int id){
        Comercio cEntity = null;
        Response.ResponseBuilder rb;
        try{
            cEntity = cb.traerPorIdComercio(id);
            rb = Response.ok();
            rb.header("Content-Type", MediaType.APPLICATION_JSON);
            rb.entity(cEntity);
            return rb.build();
        }catch(Exception e){
            rb = Response.status(Response.Status.NOT_FOUND);
            rb.header("Content-Type", MediaType.APPLICATION_JSON);
            rb.header(RestResourcePattern.ID_NOT_FOUND, id);
            return rb.build();
        }
    }
    
}
