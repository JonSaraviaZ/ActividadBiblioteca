package com.example.actividad;

import com.example.actividad.modelo.Prestamo;
import com.example.actividad.repositorio.PrestamoRepositorio;
import com.example.actividad.servicio.PrestamoServicio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PrestamoServiceTest {

    @Autowired
    private PrestamoServicio prestamoServicio;

    @MockBean
    private PrestamoRepositorio prestamoRepositorio;

    @Test
    public void testFindAll(){

        when(prestamoRepositorio.findAll()).thenReturn(
            List.of(new Prestamo(3,3,3,"2025-04-11"))
        );

        List<Prestamo> prestamos = prestamoServicio.getPrestamo();

        assertNotNull(prestamos);
        assertEquals(1, prestamos.size());
    }

}
