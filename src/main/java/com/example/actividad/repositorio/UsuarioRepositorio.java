package com.example.actividad.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.actividad.modelo.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer>{

}
