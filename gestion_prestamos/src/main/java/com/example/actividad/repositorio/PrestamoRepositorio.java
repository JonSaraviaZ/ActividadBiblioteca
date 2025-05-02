package com.example.actividad.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.actividad.modelo.Prestamo;
import java.util.List;




@Repository
public interface PrestamoRepositorio extends JpaRepository<Prestamo, Integer>{
    Optional<Prestamo> findByIdLibro(int idLibro);

}
