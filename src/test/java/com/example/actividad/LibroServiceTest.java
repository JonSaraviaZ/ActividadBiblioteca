package com.example.actividad;

import com.example.actividad.modelo.Libro;
import com.example.actividad.repositorio.LibroRepositorio;
import com.example.actividad.servicio.LibroService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class LibroServiceTest {

    @Autowired
    private LibroService libroService;

    @MockBean
    private LibroRepositorio libroRepositorio;

    @Test
    public void testFindAll(){

        when(libroRepositorio.findAll()).thenReturn(
            List.of(new Libro(3,"9780808551737", "Terrible Swift Sword", "Holt McDougal",1997, "Jc Huel"))
        );
        
        List<Libro> libros = libroService.getLibros();

        assertNotNull(libros);
        assertEquals(1, libros.size());

    }

}
