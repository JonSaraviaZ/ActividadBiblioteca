package com.example.actividad.repositorio;

import com.example.actividad.modelo.Libro;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LibroRepositorio {

    //Arreglo que guardará todos los libros
    private List<Libro> listaLibros = new ArrayList<>();

    //Arreglo que retornara todos los libros
    public List<Libro> obtenerLibros() {
        return listaLibros;
    }

    //Buscar libro por su ID
    public Libro buscarPorID(int id){
        for(Libro libro : listaLibros ){
            if (libro.getId() == id){
                return libro;
            }
        }
        throw new RuntimeException("Libro con ID: " + id + " no encontrado.");
    }

    //Guardar libro por su ID
    public Libro guardar(Libro lib){
        listaLibros.add(lib);
        return lib;
    }

    //Actualizar libro por su ID
    public Libro actualizar(Libro lib){
        int id = 0;
        int idPosicion = 0;

        for(int i = 0; i < listaLibros.size(); i ++){
            if(listaLibros.get(i).getId() == lib.getId()){
                id = lib.getId();
                idPosicion = i;
            }
        }

        Libro libro1 = new Libro();
        libro1.setId(id);
        libro1.setTitulo(lib.getTitulo());
        libro1.setAutor(lib.getAutor());
        libro1.setFechaPublicacion(lib.getFechaPublicacion());
        libro1.setEditorial(lib.getEditorial());
        libro1.setIsbn(lib.getIsbn());

        listaLibros.set(idPosicion, libro1);
        return libro1;
    }

    //Eliminar libro por su ID
    public void eliminar(int id){
        Libro libro = buscarPorID(id);
        if(libro != null){
            listaLibros.remove(libro);
        }
    }






}
