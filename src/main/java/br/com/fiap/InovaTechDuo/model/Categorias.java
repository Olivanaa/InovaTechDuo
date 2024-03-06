package br.com.fiap.InovaTechDuo.model;

import java.util.Random;

public record Categorias(Long id, String nome, String icone) {
    public Categorias(Long id, String nome, String icone){
        this.id = Math.abs( new Random().nextLong() );
        this.nome = nome;
        this.icone = icone;
    }
} 
    

