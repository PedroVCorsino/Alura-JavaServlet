package br.com.alura.mvc.mudi.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.alura.mvc.mudi.model.Pedido;

@Controller
public class HomeController {
    
    @GetMapping("/home")
    public String home(Model model) {
        Pedido pedido = new Pedido();
        pedido.setNomeProduto("Kindle");
        pedido.setUrlProduto("https://www.amazon.com.br/Kindle-10a-gera%C3%A7%C3%A3o-ilumina%C3%A7%C3%A3o-embutida/dp/B07FQK1TS9/ref=asc_df_B07FQK1TS9/?tag=googleshopp00-20&linkCode=df0&hvadid=432951822456&hvpos=&hvnetw=g&hvrand=1325854999721414824&hvpone=&hvptwo=&hvqmt=&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=1031944&hvtargid=pla-901759904091&psc=1");
        pedido.setUrlImagem("https://m.media-amazon.com/images/I/61X0ISBpD-L._AC_SY450_.jpg");
        pedido.setDescricao("É um kindle pô");

        List<Pedido> pedidos = Arrays.asList(pedido);
        model.addAttribute("pedidos", pedidos);
        return "home";
    }
}
