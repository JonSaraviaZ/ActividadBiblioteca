package com.example.actividad.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.actividad.modelo.Usuario;
import com.example.actividad.repositorio.UsuarioRepositorio;

@Service
public class UsuarioServicio {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public List<Usuario> getLibros() {
        return usuarioRepositorio.findAll();
    }

    public Usuario saveUsuario(Usuario usuario){
        return usuarioRepositorio.save(usuario);
    }

    public Usuario getUsuarioID(int id_user) {
        return usuarioRepositorio.findById(id_user).orElseThrow(() -> new RuntimeException("No encontrado"));
    }

    public Usuario updateUsuario(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    public String deleteUsuario(int id_user) {
        usuarioRepositorio.deleteById(id_user);
        return "Usuario eliminado con ID: " + id_user;
    }
}
