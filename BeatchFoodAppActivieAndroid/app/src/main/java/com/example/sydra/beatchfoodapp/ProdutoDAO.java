package com.example.sydra.beatchfoodapp;


import android.content.Context;
import com.activeandroid.Model;
import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.example.sydra.beatchfoodapp.Model.Pedido;
import com.example.sydra.beatchfoodapp.Model.Produto;
import java.util.List;

public class ProdutoDAO {

    private static List<Produto> produtos;

    public static List<Produto> getAllProdutos() {

        return new Select().from(Produto.class).execute();
    }

    public static void deleteProduto(long id) {

        new Delete().from(Produto.class)
                .where("id = ?", id)
                .execute();
    }


    public static void deleteAll() {
        new Delete().from(Produto.class).execute();
    }

    public static void inserirProduto(Produto p){
        p.save();
    }

}
