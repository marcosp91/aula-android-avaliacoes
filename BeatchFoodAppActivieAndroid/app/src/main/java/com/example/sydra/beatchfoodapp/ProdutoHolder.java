package com.example.sydra.beatchfoodapp;

import android.content.Intent;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.activeandroid.query.Select;
import com.example.sydra.beatchfoodapp.Model.ItemClickListener;
import com.example.sydra.beatchfoodapp.Model.Produto;

import java.util.List;

public class ProdutoHolder extends ViewHolder  implements View.OnClickListener{

    private TextView tvNome;
    private TextView tvQtd;
    private TextView tvValor;
    private Button btnDeletar;
    private ItemClickListener mItemClickListener;
    ProdutoAdapter adapter;
    Produto teste;

    public ProdutoHolder(ProdutoAdapter adapter, View itemView) {
        super(itemView);
        this.adapter = adapter;
        tvNome = itemView.findViewById(R.id.tvNome);
        tvQtd = itemView.findViewById(R.id.tvQtd);
        tvValor = itemView.findViewById(R.id.tvValor);
        btnDeletar = itemView.findViewById(R.id.btnDeleteItem);

        btnDeletar.setOnClickListener(this);
        itemView.setOnClickListener(this);
        btnDeletar.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View view) {
                if (mItemClickListener  != null) {

                    mItemClickListener.onItemClick(view, getAdapterPosition());
                }
                return false;
            }
        });

        itemView.setOnClickListener(this);
    }

    public void apresentaOProduto(Produto daVez){
        teste = daVez;
        tvNome.setText(daVez.getNome());
        tvQtd.setText(String.valueOf(daVez.getQuantidade()));
        tvValor.setText(String.valueOf(daVez.getValor()));

    }

    @Override
    public void onClick(View v) {
        teste.delete();
    }

    public void setOnItemClickListener(final ItemClickListener mItemClickListener) {

        this.mItemClickListener = mItemClickListener;
    }

    public void removeAt(int position) {

        List<Produto> p = ProdutoDAO.getAllProdutos();

        ProdutoDAO.deleteProduto(p.get(position).getId());

        adapter.atualizaLista(ProdutoDAO.getAllProdutos());
    }

}
