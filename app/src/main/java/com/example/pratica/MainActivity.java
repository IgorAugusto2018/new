package com.example.pratica;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nome;


    private ProdutoDAO dao;
    private Produto produto = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = findViewById(R.id.editNome);
        dao = new ProdutoDAO(this);


    }

    public void inserir(View view) {

        Produto p = new Produto();

        p.setNome(nome.getText().toString());
        long id = dao.inserir(p);

          Toast.makeText(MainActivity.this, " inserido com sucesso!!!",Toast.LENGTH_LONG).show();

        Intent it = new Intent(MainActivity.this, Lista.class);
        startActivity(it);

    }

    public void Lista(View view) {
        Intent it = new Intent(this, Lista.class);
        startActivity(it);
    }

}
