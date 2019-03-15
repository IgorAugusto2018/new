package com.example.pratica;

import java.io.Serializable;

public class Produto implements Serializable {
    private Integer id;
    private String nome;


    public Integer getId() {return id;}

    public void setId(Integer id) {
        this.id = id;
    }

    public  String getNome() {return nome;}

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String toString(){
        return "Nome: "+nome  ;

    }
}
