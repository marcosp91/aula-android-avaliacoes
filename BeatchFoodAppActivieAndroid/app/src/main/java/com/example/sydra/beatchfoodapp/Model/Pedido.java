package com.example.sydra.beatchfoodapp.Model;

import android.provider.BaseColumns;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.io.Serializable;
import java.util.List;


@Table(name = "Pedidos")
public class Pedido extends Model implements Serializable{

    public Pedido() {
        super();
    }

    @Column(name = "Nome")
    public String nome;

    public String getNome() {
        return nome;
    }






}
