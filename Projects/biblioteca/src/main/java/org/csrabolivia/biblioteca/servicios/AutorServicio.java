package org.csrabolivia.biblioteca.servicios;

import jakarta.transaction.Transactional;
import org.csrabolivia.biblioteca.entidades.Autor;
import org.csrabolivia.biblioteca.repositorios.AutorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AutorServicio {

    @Autowired
    AutorRepositorio autorRepositorio;

    @Transactional
    public void crearAutor(String nombre){

        Autor autor = new Autor();
        autor.setNombre(nombre);
        autorRepositorio.save(autor);

    }

    public List<Autor> listarAutores(){

        List<Autor> autores = new ArrayList<>();

        autores = autorRepositorio.findAll();

        return autores;
    }

    public void modificarAutor(String id, String nombre){

        Optional<Autor> respuestaAutor = autorRepositorio.findById(id);

        if(respuestaAutor.isPresent()){

            Autor autor = respuestaAutor.get();
            autor.setNombre(nombre);

            autorRepositorio.save(autor);


        }




    }


}
