package com.example.sydra.beatchfoodapp;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Configuration;
import com.activeandroid.query.Select;
import com.example.sydra.beatchfoodapp.Model.Pedido;
import com.example.sydra.beatchfoodapp.Model.Produto;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private final int ADICIONAR_PRODUTO_CODE = 1;

    private RecyclerView rvLista;
    private ProdutoAdapter adaptador;
    private TextView tvSubTotal;
    //Pedido pedidos = new Pedido();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ActiveAndroid.initialize(this);

        rvLista = findViewById(R.id.listaItens);
        adaptador = new ProdutoAdapter(ProdutoDAO.getAllProdutos());
        rvLista.setAdapter(adaptador);
        rvLista.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        rvLista.setLayoutManager(new LinearLayoutManager(this));

        Produto produto = new Produto();
        tvSubTotal = findViewById(R.id.valorSubtotal);
        tvSubTotal.setText(String.valueOf(produto.calculaSubtotal(ProdutoDAO.getAllProdutos())));

    }


    public void onClickAdicionar(View v){

        Intent abrirNovaActivity = new Intent(this, PedidoAddActivity.class);
        //abrirNovaActivity.putExtra("Pedido", pedidos);
        startActivityForResult(abrirNovaActivity, ADICIONAR_PRODUTO_CODE);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADICIONAR_PRODUTO_CODE ){
            if (resultCode == 200){
                ((ProdutoAdapter) rvLista.getAdapter()).atualizaLista(ProdutoDAO.getAllProdutos());
                Produto produto = new Produto();
                tvSubTotal = findViewById(R.id.valorSubtotal);
                tvSubTotal.setText(String.valueOf(produto.calculaSubtotal(ProdutoDAO.getAllProdutos())));
            }
        }
    }
}
