package com.sisnet.univali.br.beatchfoodapp.model;

import io.requery.Entity;
import io.requery.Generated;
import io.requery.Key;
import io.requery.OneToMany;

@Entity
public abstract class Produto {

    @Key
    @Generated
    int id;

    @OneToMany
    Pedido getOwner() { return null; }

    void setOwner(Pedido pedido) { }

    abstract double getSubtotal();

    abstract String getNome();

    abstract int getQuantidade();

    abstract double getValor();

}


    /*public Produto (String nomeProduto, int quantidadeProduto, double valorProduto){

        this.nomeProduto = nomeProduto;
        this.quantidadeProduto = quantidadeProduto;
        this.valorProduto = valorProduto;
    }

    public double buscaSubTotal(int quantidadeProduto, double valorProduto){

        return subtotal = quantidadeProduto * valorProduto;
    }

    public void decrementaQuantidade(int quantidadeProduto){

        this.quantidadeProduto = quantidadeProduto - 1;
    }*/

