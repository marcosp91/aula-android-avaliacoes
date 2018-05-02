package com.sisnet.univali.br.beatchfoodapp.model;


public class Produto {

    private String nomeProduto;
    private int quantidadeProduto;
    private double valorProduto;
    private double subtotal;

    public Produto (String nomeProduto, int quantidadeProduto, double valorProduto){

        this.nomeProduto = nomeProduto;
        this.quantidadeProduto = quantidadeProduto;
        this.valorProduto = valorProduto;
    }

    public double buscaSubTotal(int quantidadeProduto, double valorProduto){

        return subtotal = quantidadeProduto * valorProduto;
    }

    public void decrementaQuantidade(int quantidadeProduto){

        this.quantidadeProduto = quantidadeProduto - 1;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }
}
