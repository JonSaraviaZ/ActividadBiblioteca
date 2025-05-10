package com.example.actividad;

import com.example.actividad.modelo.Usuario;
import com.example.actividad.repositorio.UsuarioRepositorio;
import com.example.actividad.servicio.UsuarioServicio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UsuarioServiceTest {
    
    @Autowired
    private UsuarioServicio usuarioServicio;

    @MockBean
    private UsuarioRepositorio usuarioRepositorio;

    @Test
    public void testFindAll() {
        // Arrange
        when(usuarioRepositorio.findAll()).thenReturn(
            List.of(new Usuario(1, "123@gmail.com", "1234"))
        );

        // Act
        List<Usuario> usuarios = usuarioServicio.getUsuarios();

        // Assert
        assertNotNull(usuarios);
        assertEquals(1, usuarios.size());
    }
}
