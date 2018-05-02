package com.sisnet.univali.br.beatchfoodapp.model;


import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ProdutoDAO {

    private static final String FILE_NAME = "produtos.txt";

    private static ArrayList<Produto> bd;

    public static ArrayList<Produto> getLista(Context c){

        bd = new ArrayList<>();
        FileInputStream inputStream;

        try {
            inputStream = c.openFileInput(FILE_NAME);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String line;
            String[] lineSep;
            while ((line = bufferedReader.readLine()) != null) {
                lineSep = line.split(";");
                bd.add(new Produto(lineSep[0], Integer.parseInt(lineSep[1]), Double.parseDouble(lineSep[2])));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return bd;
    }

    public static void salvar(Context c, Produto p){
        bd.add(p);

        FileOutputStream outputStream;
        try {
            outputStream = c.openFileOutput(FILE_NAME, Context.MODE_APPEND);
            String line = p.getNomeProduto() + p.getQuantidadeProduto() + p.getValorProduto();
            outputStream.write( (line + System.getProperty("line.separator")).getBytes());
            outputStream.flush ();
            outputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
