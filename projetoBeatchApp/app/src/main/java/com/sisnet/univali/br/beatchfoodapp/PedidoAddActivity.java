package com.sisnet.univali.br.beatchfoodapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import com.sisnet.univali.br.beatchfoodapp.model.Produto;
import com.sisnet.univali.br.beatchfoodapp.model.ProdutoDAO;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class PedidoAddActivity extends AppCompatActivity {

    int quantidade = 0;
//  double valorItem = 0 ;

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

        EditText etNome = findViewById(R.id.labelNome);
        TextView aumentarQtd = findViewById(R.id.incrementaQtd);
        EditText etValor = findViewById(R.id.labelValor);

        Produto produto = new Produto(

                etNome.getText().toString(),
                Integer.parseInt(aumentarQtd.getText().toString()),
                Double.parseDouble(etValor.getText().toString())
        );

        ProdutoDAO.salvar(this, produto);

        setResult(Activity.RESULT_OK);
        finish();

        // ****** NÃO IMPLEMENTADO ****** \\

        /*
            quantidade = Integer.parseInt(aumentarQtd.getText().toString());

            valorItem = Double.parseDouble(etValor.getText().toString());

              //produto.buscaSubTotal(quantidade, valorItem));

            Log.d("BANCO_DE_DADOS", "Valor "+ valorItem +  "Quantidade "+ quantidade);



            Intent intencaoMorte = new Intent();
            intencaoMorte.putExtra("valorSubtotal", produto.buscaSubTotal(quantidade, valorItem));

            setResult(200, intencaoMorte);
            finish();
                                                */

    }

}
