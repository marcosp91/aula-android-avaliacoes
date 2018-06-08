package com.example.sydra.beatchfoodapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.sydra.beatchfoodapp.Model.ItemClickListener;
import com.example.sydra.beatchfoodapp.Model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoAdapter extends RecyclerView.Adapter{

    private List<Produto> listaProduto;
    ProdutoHolder gaveta;

    public ProdutoAdapter(List<Produto> listaInicial){

        this.listaProduto = listaInicial;
    }

    public void atualizaLista(List<Produto> listaInicial){

        this.listaProduto = listaInicial;
        this.notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View elementoPrincipalXml = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pedido, parent, false);
        ProdutoHolder gaveta = new ProdutoHolder(this, elementoPrincipalXml);
        return gaveta;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        gaveta = (ProdutoHolder) holder;
        Produto daVez = this.listaProduto.get(position);
        gaveta.apresentaOProduto( daVez );

    }

    @Override
    public int getItemCount() {
        return this.listaProduto.size();
    }

}
