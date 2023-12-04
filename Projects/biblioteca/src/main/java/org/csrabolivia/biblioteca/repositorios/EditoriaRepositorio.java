package org.csrabolivia.biblioteca.repositorios;

import org.csrabolivia.biblioteca.entidades.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditoriaRepositorio extends JpaRepository<Editorial, String> {
}
