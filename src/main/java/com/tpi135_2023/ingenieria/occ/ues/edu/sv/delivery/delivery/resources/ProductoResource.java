/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tpi135_2023.ingenieria.occ.ues.edu.sv.delivery.delivery.resources;


import com.tpi135_2023.ingenieria.occ.ues.edu.sv.delivery.delivery.control.AbstractDataAccess;
import com.tpi135_2023.ingenieria.occ.ues.edu.sv.delivery.delivery.control.ProductoBean;
import com.tpi135_2023.ingenieria.occ.ues.edu.sv.delivery.delivery.entity.Producto;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

/**
 *
 * @author nesto
 */

@Path("/producto")

public class ProductoResource extends AbstracRestResources<Producto>{

    @Inject ProductoBean pb;
    @Override
    protected AbstractDataAccess<Producto> getDataAccesBean() {
        return this.pb;
    }
    
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response ingresar(Producto entidad) {
        Response.ResponseBuilder rb;

        try {
            Producto entidadCreada = this.getDataAccesBean().Ingresar(entidad);
            rb = Response.status(Response.Status.CREATED);
            rb.header("Content-Type", MediaType.APPLICATION_JSON);
            rb.header("location", "/producto"+entidadCreada.getIdProducto());
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
    @Path("/id/{id}")
    public Response traerPorId(@PathParam("id") int id) {
        Producto lp = null;
        Response.ResponseBuilder rb;
        try{
                lp = pb.traerPorIdProducto(id);
                rb = Response.ok();
                rb.header("Content-Type", MediaType.APPLICATION_JSON);
                rb.entity(lp);
                return rb.build();
        }catch(Exception e){
               e.printStackTrace();

        }
        
        rb = Response.status(Response.Status.NO_CONTENT);
        rb.header("Content-Type", MediaType.TEXT_HTML);
        return rb.build();
    }
    
    @GET
    @Path("nombre/{nombre}")
    public Response buscarPorNombre(@PathParam("nombre") String nombre){
        List<Producto> lp = null;
        Response.ResponseBuilder rb;
        try{
            lp = pb.buscarPorNombre(nombre);
            rb = Response.ok();
            rb.header("Content-Type", MediaType.APPLICATION_JSON);
            rb.entity(lp);
            return rb.build();
        }catch(Exception e){
            e.printStackTrace();
        }
        rb = Response.status(Response.Status.NO_CONTENT);
        rb.header("Content-Type", MediaType.TEXT_HTML); 
        return rb.build();
    }
    
    @GET
    @Path("activo/{estado}")
    public Response buscarPorEstado(@PathParam("nombre") boolean estado){
        List<Producto> lp = null;
        Response.ResponseBuilder rb;
        try{
            lp = pb.buscarPorActivo(estado);
            rb = Response.ok();
            rb.header("Content-Type", MediaType.APPLICATION_JSON);
            rb.entity(lp);
            return rb.build();
        }catch(Exception e){
            e.printStackTrace();
        }
        rb = Response.status(Response.Status.NO_CONTENT);
        rb.header("Content-Type", MediaType.TEXT_HTML); 
        return rb.build();
    }
    
      @GET
    @Path("descripcion/{descripcion}")
    public Response buscarPorDescripcion(@PathParam("descripcion") String descripcion){
        List<Producto> lp = null;
        Response.ResponseBuilder rb;
        try{
            lp = pb.buscarPorDescripcion(descripcion);
            rb = Response.ok();
            rb.header("Content-Type", MediaType.APPLICATION_JSON);
            rb.entity(lp);
            return rb.build();
        }catch(Exception e){
            e.printStackTrace();
        }
        rb = Response.status(Response.Status.NO_CONTENT);
        rb.header("Content-Type", MediaType.TEXT_HTML); 
        return rb.build();
    }
}