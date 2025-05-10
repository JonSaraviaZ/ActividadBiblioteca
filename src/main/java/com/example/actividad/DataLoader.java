package com.example.actividad;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.example.actividad.modelo.Libro;
import com.example.actividad.modelo.Prestamo;
import com.example.actividad.modelo.Usuario;
import com.example.actividad.repositorio.LibroRepositorio;
import com.example.actividad.repositorio.PrestamoRepositorio;
import com.example.actividad.repositorio.UsuarioRepositorio;

import net.datafaker.Faker;

@Profile("dev")
@Component

public class DataLoader implements CommandLineRunner {

    @Autowired
    private LibroRepositorio libroRepositorio;

    @Autowired
    private PrestamoRepositorio prestamoRepositorio;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;


    @Override
    public void run(String... args) throws Exception {
    Faker faker = new Faker();
    Random random = new Random();

        // Crear 10 usuarios
        for (int i = 0; i < 10; i++) {
            Usuario usuario = new Usuario();
            usuario.setEmail(faker.internet().emailAddress());
            usuario.setPassword(faker.internet().password());
            usuarioRepositorio.save(usuario);
        }

        // Crear 10 libros
        for (int i = 0; i < 10; i++) {
            Libro libro = new Libro();
            libro.setIsbn(faker.code().isbn13());
            libro.setTitulo(faker.book().title());
            libro.setEditorial(faker.book().publisher());
            libro.setFechaPublicacion(faker.number().numberBetween(1950, 2024));
            libro.setAutor(faker.book().author());
            libroRepositorio.save(libro);
        }

        // Obtener todos los usuarios y libros guardados
        List<Usuario> usuarios = usuarioRepositorio.findAll();
        List<Libro> libros = libroRepositorio.findAll();

        // Crear 10 préstamos con referencias a libros y usuarios existentes
        for (int i = 0; i < 10; i++) {
            Prestamo prestamo = new Prestamo();
            prestamo.setId_usuario(usuarios.get(random.nextInt(usuarios.size())).getId_user());
            prestamo.setIdLibro(libros.get(random.nextInt(libros.size())).getId());
            prestamo.setFechaPrestamo(faker.date().past(30, java.util.concurrent.TimeUnit.DAYS).toString());
            prestamoRepositorio.save(prestamo);
        }

        System.out.println("Datos de prueba cargados correctamente.");
    }

}
