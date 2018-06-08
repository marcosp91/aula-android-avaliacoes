package com.example.sydra.beatchfoodapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickStartApp (View view){
        Intent abrirNovaActivity = new Intent(this, HomeActivity.class);
        startActivity(abrirNovaActivity);
    }
}
