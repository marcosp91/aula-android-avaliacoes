package com.sisnet.univali.br.beatchfoodapp.model;


import android.view.View;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.sisnet.univali.br.beatchfoodapp.R;


public class ProdutoHolder extends ViewHolder {

    private TextView tvNome;
    private TextView tvQtd;
    private TextView tvValor;

    public ProdutoHolder(View itemView) {
        super(itemView);

        tvNome = itemView.findViewById(R.id.tvNome);
        tvQtd = itemView.findViewById(R.id.tvQtd);
        tvValor = itemView.findViewById(R.id.tvValor);
    }

    public void apresentaOProduto(Produto daVez){

        tvNome.setText(daVez.getNomeProduto());
        tvQtd.setText(String.valueOf(daVez.getQuantidadeProduto()));
        tvValor.setText(String.valueOf(daVez.getValorProduto()));
    }
}
