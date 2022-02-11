package br.com.alura.loja.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
// import javax.persistence.EntityManagerFactory;
// import javax.persistence.Persistence;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

public class CadastroDeProdutos {

    public static void main(String[] args) {
        cadastrarProduto();
        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);

        Produto produto = produtoDao.buscarPorId(1L);
        System.out.println(produto.getPreco());

        List<Produto> todosProdutos = produtoDao.buscarTodos();
        todosProdutos.forEach(prod -> System.out.println(prod.getPreco()));

        List<Produto> produtoPorNome = produtoDao.buscarPorNome("Xiomi");
        produtoPorNome .forEach(prod -> System.out.println(prod.getPreco()));

        List<Produto> produtoPorCategoria = produtoDao.buscarPorNomeDaCategoria("CELULARES");
        produtoPorCategoria .forEach(prod -> System.out.println(prod.getPreco()));
    
        BigDecimal produtoPreco = produtoDao.buscarPrecoDoProdutoComNome("Xiomi Redmi");
        System.out.println(produtoPreco);
    }


    private static void cadastrarProduto() {
        Categoria celulares = new Categoria("CELULARES");
        Produto celular = new Produto("Xiomi Redmi", "Celular de marca Xiaomi",new BigDecimal("999.99"), celulares);

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);
                
        em.getTransaction().begin(); // inicia a transação
        
        categoriaDao.cadastrar(celulares);
        produtoDao.cadastrar(celular);
        
        em.getTransaction().commit(); // finaliza a transação
        em.close();
    }
}
