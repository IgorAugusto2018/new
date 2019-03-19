package com.example.pratica;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    private Conexao conexao;
    private SQLiteDatabase banco;

    public ProdutoDAO(Context context){
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }
    public long inserir(Produto produto){

        ContentValues values = new ContentValues();

        values.put("nome", produto.getNome());
        return banco.insert("lista",null, values);

    }
    public List<Produto> ObterTodos(){
        List<Produto> produtos = new ArrayList<>();
        Cursor cursor = banco.query("lista", new String[]{"id","nome"}, null, null, null, null, null);

        while (cursor.moveToNext()){
            Produto p = new Produto();

            p.setId(cursor.getInt(0));
            p.setNome(cursor.getString(1));

            produtos.add(p);

        }
        return produtos;
    }
    public void excluir(Produto p) {
        banco.delete("lista", "id = ?", new String[]{p.getId().toString()});
    }
}
