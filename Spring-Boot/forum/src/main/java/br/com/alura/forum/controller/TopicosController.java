package br.com.alura.forum.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.controller.dto.TopicoDTO;
import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.modelo.Topico;

@RestController // A anotação @RestController é uma abreviação para @Controller + @ResponseBody
public class TopicosController {
    
    @RequestMapping("/topicos")
   // @ResponseBody //Anotação que indica que o retorno do método será o corpo da resposta
    public List<TopicoDTO> lista() {
        Topico topico = new Topico("Dúvida", "Dúvida com Spring", new Curso("Spring", "Programação"));
        return TopicoDTO.converter(Arrays.asList(topico, topico, topico));
    }

}
