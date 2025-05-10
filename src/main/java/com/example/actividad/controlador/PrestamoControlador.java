package com.example.actividad.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.actividad.modelo.Prestamo;
import com.example.actividad.servicio.PrestamoServicio;

@RestController
@RequestMapping("/prestamo")
public class PrestamoControlador {

    @Autowired
    private PrestamoServicio prestamoServicio;

    @GetMapping
    public List<Prestamo> listaPrestamos(){
        return prestamoServicio.getPrestamo();
    }

    @PostMapping
    public Prestamo agregarPrestamo(@RequestBody Prestamo prestamo){
        return prestamoServicio.savePrestamo(prestamo);
    }

    @GetMapping("{id}")
    public Prestamo buscarPrestamo(@PathVariable int id){
        return prestamoServicio.getPrestamoID(id);
    }

    @PutMapping("{id}")
    public Prestamo actualizarPrestamo(@PathVariable int id, @RequestBody Prestamo prestamo){
        return prestamoServicio.updatePrestamo(prestamo);
    }

    @DeleteMapping("{id}")
    public String eliminarPrestamo(@PathVariable int id){
        return prestamoServicio.deletePrestamo(id);
    }


}
