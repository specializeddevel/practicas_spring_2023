package org.csrabolivia.biblioteca.servicios;

import jakarta.transaction.Transactional;
import org.csrabolivia.biblioteca.entidades.Autor;
import org.csrabolivia.biblioteca.entidades.Editorial;
import org.csrabolivia.biblioteca.entidades.Libro;
import org.csrabolivia.biblioteca.excepciones.MiException;
import org.csrabolivia.biblioteca.repositorios.AutorRepositorio;
import org.csrabolivia.biblioteca.repositorios.EditoriaRepositorio;
import org.csrabolivia.biblioteca.repositorios.LibroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LibroServicio {

    @Autowired
    private LibroRepositorio libroRepositorio;
    @Autowired
    private AutorRepositorio autorRepositorio;
    @Autowired
    private EditoriaRepositorio editoriaRepositorio;

    @Transactional
    public void crearLibro(Long isbn, String titulo, Integer ejemplares, String idAutor, String idEditorial) throws MiException {


        validar(isbn, titulo, idAutor, idEditorial, ejemplares);

        Autor autor = autorRepositorio.findById(idAutor).get();
        Editorial editorial = editoriaRepositorio.findById(idEditorial).get();
        Libro libro = new Libro();

        libro.setIsbn(isbn);
        libro.setTitulo(titulo);
        libro.setEjemplares(ejemplares);
        libro.setAlta(new Date());
        libro.setAutor(autor);
        libro.setEditorial(editorial);

        libroRepositorio.save(libro);

    }


    public List<Libro> listarLibros(){

        List<Libro> libros = new ArrayList<>();

        libros = libroRepositorio.findAll();

        return libros;

    }

    @Transactional
    public void modificarLibro(Long isbn, String titulo, String idAutor, String idEditorial, Integer ejemplares) throws MiException{

        validar(isbn, titulo, idAutor, idEditorial, ejemplares);

        Optional<Libro> respuestaLibro = libroRepositorio.findById(isbn);
        Optional<Autor> respuestaAutor = autorRepositorio.findById(idAutor);
        Optional<Editorial> respuestaEditorial = editoriaRepositorio.findById(idEditorial);

        Autor autor = new Autor();
        Editorial editorial = new Editorial();


        if(respuestaAutor.isPresent()){

            autor = respuestaAutor.get();

        }

        if(respuestaEditorial.isPresent()){

            editorial = respuestaEditorial.get();

        }


        if(respuestaLibro.isPresent()){
            Libro libro = respuestaLibro.get();
            libro.setTitulo(titulo);
            libro.setAutor(autor);
            libro.setEditorial(editorial);
            libro.setEjemplares(ejemplares);

            libroRepositorio.save(libro);

        }
    }

    private void validar(Long isbn, String titulo, String idAutor, String idEditorial, Integer ejemplares) throws MiException{
        if(isbn == null){

            throw new MiException("Debe otorgarse el ISBN");

        }

        if(titulo.isEmpty() || titulo == null){

            throw new MiException("Debe otorgarse el Titulo del libro");

        }

        if(ejemplares == null){

            throw new MiException("Debe otorgarse la cantidad de libros");

        }

        if(idAutor.isEmpty() || idAutor == null){

            throw new MiException("Debe otorgarse el ID del autor");

        }

        if(idEditorial.isEmpty() || idEditorial == null){

            throw new MiException("Debe otorgarse el ID de la editorial");

        }
    }



}
