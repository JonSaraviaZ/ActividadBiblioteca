package com.example.actividad.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.actividad.modelo.Libro;
import com.example.actividad.repositorio.LibroRepositorio;

@Service
public class LibroService {

    @Autowired
    private LibroRepositorio libroRepositorio;

    public List<Libro> getLibros() {
        return libroRepositorio.findAll();
    }

    public Libro saveLibro(Libro libro) {
        return libroRepositorio.save(libro);
    }

    public Libro getLibroID(int id) {
        return libroRepositorio.findById(id).orElseThrow(() -> new RuntimeException("No encontrado"));
    }

    public Libro updateLibro(Libro libro) {
        return libroRepositorio.save(libro);
    }

    public String deleteLibro(int id) {
        libroRepositorio.deleteById(id);
        return "Libro eliminado con ID: " + id;
    }
}
