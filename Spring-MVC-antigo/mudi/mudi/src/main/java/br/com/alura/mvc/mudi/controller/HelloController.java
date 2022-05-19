package br.com.alura.mvc.mudi.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // Anotação que diz que essa classe é um controller
public class HelloController {
    
    @GetMapping("/hello") // Anotação que diz que esse método é um GET
    public String hello(Model model) { 
        model.addAttribute("nome", "Mundo"); 
        return "hello";
    }

}
