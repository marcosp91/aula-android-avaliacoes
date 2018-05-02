package com.sisnet.univali.br.beatchfoodapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.sisnet.univali.br.beatchfoodapp.model.ProdutoAdapter;
import com.sisnet.univali.br.beatchfoodapp.model.ProdutoDAO;

public class HomeActivity extends AppCompatActivity {

    private final int ADICIONAR_PRODUTO_CODE = 1;

    private ProdutoAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        RecyclerView rvLista = findViewById(R.id.listaItens);

        adaptador = new ProdutoAdapter( ProdutoDAO.getLista(this) );
        rvLista.setAdapter(adaptador);

        rvLista.addItemDecoration(new DividerItemDecoration(this, RecyclerView.VERTICAL));
        rvLista.setLayoutManager(new LinearLayoutManager(this));
    }

    public void onClickAdicionar(View v){

        Intent abrirNovaActivity = new Intent(this, PedidoAddActivity.class);
        startActivityForResult(abrirNovaActivity, ADICIONAR_PRODUTO_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADICIONAR_PRODUTO_CODE){
            if (resultCode == Activity.RESULT_OK){
                adaptador.notifyDataSetChanged();
            }
        }

    }

}
