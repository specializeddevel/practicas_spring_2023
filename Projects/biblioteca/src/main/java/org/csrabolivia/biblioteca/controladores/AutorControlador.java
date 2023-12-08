package org.csrabolivia.biblioteca.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/autor")
public class AutorControlador {

    @GetMapping("/registrar")
    public String registrar(){

        return "autor_form.html";

    }


}
