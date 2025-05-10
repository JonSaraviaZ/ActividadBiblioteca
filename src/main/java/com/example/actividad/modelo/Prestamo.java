package com.example.actividad.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "gestion_prestamo")
public class Prestamo {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id_prestamo;
    private int idLibro;
    private int id_usuario;
    private String fechaPrestamo;
}
