package com.sisnet.univali.br.beatchfoodapp.model;

import android.os.Parcelable;

import java.util.ArrayList;

import io.requery.CascadeAction;
import io.requery.Entity;
import io.requery.Generated;
import io.requery.Key;
import io.requery.OneToMany;
import io.requery.Persistable;

import static io.requery.CascadeAction.*;

@Entity
public interface Pedido extends Parcelable, Persistable  {

    @Key
    @Generated
    int getId();


    @OneToMany(mappedBy = "owner", cascade = {CascadeAction.DELETE, CascadeAction.SAVE})
    ArrayList<Produto> getListaProdutos();
}
