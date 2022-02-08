package br.com.alura.loja.testes;

import java.math.BigDecimal;

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
