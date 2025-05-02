package com.example.actividad.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.actividad.modelo.Prestamo;
import com.example.actividad.repositorio.PrestamoRepositorio;

@Service
public class PrestamoServicio {

   @Autowired
   private PrestamoRepositorio prestamoRepositorio;
   
   public List<Prestamo> getPrestamo(){
    return prestamoRepositorio.findAll();
   }

   public Prestamo savePrestamo(Prestamo prestamo){
    Optional<Prestamo> prestado = prestamoRepositorio.findByIdLibro(prestamo.getIdLibro());
    if(prestado.isPresent()){
        throw new RuntimeException("El libro ya está prestado.");
    }
    return prestamoRepositorio.save(prestamo);
   }

   public Prestamo getPrestamoID(int id){
    return prestamoRepositorio.findById(id).orElseThrow(() -> new RuntimeException("No encontrado"));
   }

   public Prestamo updatePrestamo(Prestamo prestamo){
    return prestamoRepositorio.save(prestamo);
   }

    public String deletePrestamo(int id) {
        prestamoRepositorio.deleteById(id);
        return "Préstamo eliminado con ID: " + id;
    }
}
