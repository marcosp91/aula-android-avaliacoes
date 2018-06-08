package com.example.sydra.beatchfoodapp.Model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.util.List;

@Table(name = "Produtos")
public class Produto extends Model {

    public Produto() {
        super();
    }

    @Column(name = "nome_produto")
    public String nome;

    @Column(name = "quantidade_produto")
    public int quantidade;

    @Column(name = "valor_produto")
    public double valor;

    /*@Column(name = "Pedido")
    public Pedido pedido;*/

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double calculaSubtotal(List<Produto> produtos){
        double subtotal = 0;
        double um = 0;
        for (int i = 0; i < produtos.size(); i++) {
            um = produtos.get(i).getQuantidade() * produtos.get(i).getValor();
            subtotal = subtotal + um;

        }
        return subtotal;
    }

}
