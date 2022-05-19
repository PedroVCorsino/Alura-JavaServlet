package br.com.alura.mvc.mudi.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloControler {
    
    @GetMapping("/hello")
    public String hello(HttpServletRequest request) { // Actions são metodos de classes controllers
        request.setAttribute("nome", "Mundo");
        return "hello"; // O retorno será o nome da view que será renderizada
    }

}