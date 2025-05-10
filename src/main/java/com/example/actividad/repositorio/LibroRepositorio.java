package com.example.actividad.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.actividad.modelo.Libro;

@Repository
public interface LibroRepositorio extends JpaRepository<Libro, Integer> {
    
}
