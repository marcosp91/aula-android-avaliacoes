package com.example.sydra.beatchfoodapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sydra.beatchfoodapp.Model.Pedido;
import com.example.sydra.beatchfoodapp.Model.Produto;

public class PedidoAddActivity extends AppCompatActivity {

    EditText etNome, etValor;
    TextView aumentarQtd;
    int quantidade = 0;
    //double valorItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido_add);
    }

    public void onClickAumentar(View v){

        if (quantidade >= 9 ){

            Toast.makeText(this, "Quantidade Máxima!", Toast.LENGTH_LONG).show();
            return;
        }

        TextView aumentarQtd = findViewById(R.id.incrementaQtd);
        quantidade = quantidade + 1;
        aumentarQtd.setText("0" + String.valueOf( quantidade ));
    }

    public void onClickDiminuir(View v){

        if (quantidade <= 0 ){

            Toast.makeText(this, "Valor inválido", Toast.LENGTH_LONG).show();
            return;
        }

        TextView aumentarQtd = findViewById(R.id.incrementaQtd);
        quantidade = quantidade - 1;
        aumentarQtd.setText("0" + String.valueOf( quantidade ));
    }

     public void onClickSalvar(View v){

        //Intent i = getIntent();
        //Pedido pedido = i.getParcelableExtra("Pedido");
        //Pedido pedido = (Pedido) i.getSerializableExtra("Pedido");

         etNome = findViewById(R.id.labelNome);
         aumentarQtd = findViewById(R.id.incrementaQtd);
         etValor = findViewById(R.id.labelValor);

         Produto produto = new Produto();
         produto.nome = etNome.getText().toString();
         produto.quantidade = Integer.parseInt(aumentarQtd.getText().toString());
         produto.valor = Double.parseDouble(etValor.getText().toString());

         //try {
             ProdutoDAO.inserirProduto(produto);
         //}catch (Exception e) {
             setResult(200);
             finish();
         //}
    }
}
