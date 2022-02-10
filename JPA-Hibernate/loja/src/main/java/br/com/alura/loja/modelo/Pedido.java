package br.com.alura.loja.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "valor_total")
    private BigDecimal valorTotal;
    private LocalDate data = LocalDate.now();

    @ManyToOne
    private Cliente cliente;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL) // Relacionamento bidirecional
    private List<ItemPedido> itensPedido = new ArrayList<>();

    public Pedido() {} // Construtor vazio para o JPA

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }

    public void adicionaItem(ItemPedido itemPedido) { //Recomendado em relacionamentos bidirecionais
        this.itensPedido.add(itemPedido); // Adiciona o item a lista de itens do pedido
        itemPedido.setPedido(this); // Seta o pedido do item
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData() {
        this.data = LocalDate.now();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    

}
