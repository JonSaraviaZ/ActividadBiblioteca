package com.example.actividad.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.actividad.modelo.Usuario;
import com.example.actividad.servicio.UsuarioServicio;


@RestController
@RequestMapping("/usuario")
public class UsuarioControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping
    public List<Usuario> listaUsuarios(){
        return usuarioServicio.getUsuarios();
    }

    @PostMapping
    public Usuario agregarUsuario(@RequestBody Usuario usuario){
        return usuarioServicio.saveUsuario(usuario);
    }

    @GetMapping("{id_user}")
    public Usuario buscarUsuario(@PathVariable int id_user){
        return usuarioServicio.getUsuarioID(id_user);
    }

    @PutMapping("{id_user}")
    public Usuario actualizarUsuario(@PathVariable int id_user, @RequestBody Usuario usuario) {
        return usuarioServicio.updateUsuario(usuario);
    }

    @DeleteMapping("{id_user}")
    public String eliminarUsuario(@PathVariable int id_user){
        return usuarioServicio.deleteUsuario(id_user);
    }

    

}
