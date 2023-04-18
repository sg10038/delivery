/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tpi135_2023.ingenieria.occ.ues.edu.sv.delivery.delivery.control;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nesto
 * @param <T>
 */
public class AbstractDataAccess <T> implements Serializable{
    private final Class<T> classEntidad;
    protected final EntityManagerFactory emf;    
    
    /**
     * Resive la unidad de persistencia 
     * @param entityClassPrincipal
     * @param persistenUnitName 
     */
    public AbstractDataAccess(Class<T> entityClassPrincipal,String persistenUnitName){
        this.classEntidad = entityClassPrincipal;
        this.emf = Persistence.createEntityManagerFactory(persistenUnitName);
    }
    
    //Inicializamos el emf
    public EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
    
    public T crearEntidad() throws NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
            return this.classEntidad.getDeclaredConstructor().newInstance();
    }
    
    
    /**
     * Implementa de traer todo los datos
     * @return una lista con los datos segun la tabla
     */
    public List<T> traerTodos(){
        List<T> datosEntity = new ArrayList<>();
        EntityManager em =  this.getEntityManager();
        try{
            Query query =  em.createNamedQuery(classEntidad.getSimpleName()+".findAll");
            datosEntity =  query.getResultList();
        }catch(Exception e){
            throw new NullPointerException("El em es null");
        }finally{
             if(em != null) em.close();
        }
        return datosEntity;
    }


    /**
     *
     * @param entidad
     * @return
     * @throws Exception
     */
    public T Ingresar(T entidad) throws Exception {
        EntityManager em = this.getEntityManager();
            em.persist(entidad);
            em.flush();
        return entidad;
    }
    
    /**
     * 
     * @param entidad
     * @throws IllegalArgumentException 
     */
    public void Actualiza(T entidad) throws IllegalArgumentException{
        if(entidad != null){
            this.getEntityManager().merge(entidad);
        }
    }
    
//    public void Eliminar(T entidad ){
//        if(entidad != null){
//            this.getEntityManager().remove(entidad);
//        }
//    }
    
    /**
     * Cierra la conexion que estable el entityManagerFactory
     */
    public void close(){
        emf.close();
    
}
}
