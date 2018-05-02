package com.sisnet.univali.br.beatchfoodapp.model;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sisnet.univali.br.beatchfoodapp.R;

import java.util.ArrayList;

public class ProdutoAdapter extends RecyclerView.Adapter{

    private ArrayList<Produto> listaProduto;

    public ProdutoAdapter(ArrayList<Produto> listaInicial){

        this.listaProduto = listaInicial;
    }

    public void setNovaLista(ArrayList<Produto> listaInicial){
        this.listaProduto = listaInicial;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View elementoPrincipalXml = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pedido, parent, false);
        ProdutoHolder gaveta = new ProdutoHolder(elementoPrincipalXml);
        return gaveta;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ProdutoHolder gaveta = (ProdutoHolder) holder;
        Produto daVez = this.listaProduto.get(position);
        gaveta.apresentaOProduto( daVez );

    }

    @Override
    public int getItemCount() {
        return this.listaProduto.size();
    }

}
