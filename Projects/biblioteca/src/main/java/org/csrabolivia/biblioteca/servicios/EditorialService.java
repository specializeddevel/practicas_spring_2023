package org.csrabolivia.biblioteca.servicios;

import jakarta.transaction.Transactional;
import org.csrabolivia.biblioteca.entidades.Editorial;
import org.csrabolivia.biblioteca.repositorios.EditoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EditorialService {

    @Autowired
    EditoriaRepositorio editoriaRepositorio;

    @Transactional
    public void crearEditorial(String nombre){

        Editorial editorial = new Editorial();
        editorial.setNombre(nombre);
        editoriaRepositorio.save(editorial);

    }

    public List<Editorial> listaEditoriales(){

        List<Editorial> editoriales = new ArrayList<>();

        editoriales = editoriaRepositorio.findAll();

        return editoriales;

    }

    public void modificarEditorial(String id, String nombre){

        Optional<Editorial> respuestaEditorial = editoriaRepositorio.findById(id);

        if(respuestaEditorial.isPresent()){

            Editorial editorial = respuestaEditorial.get();
            editorial.setNombre(nombre);

            editoriaRepositorio.save(editorial);

        }

    }


}
