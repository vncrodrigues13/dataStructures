/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.br.unicap.universidadedigital.colecoes.listas.iteradores;

import main.java.br.unicap.universidadedigital.colecoes.comum.No;

/**
 *
 * @author tj
 */
public class IteradorListaSimplesmenteLigada<T> {
    
    private No<T> posicaoAtual;
    
    public IteradorListaSimplesmenteLigada(No<T> inicio){
        No<T> dummy = new No<T>(null);
        dummy.setProximo(inicio);
        this.posicaoAtual = dummy;
    }
    
    public boolean existeProximo(){
        return this.posicaoAtual.getProximo() != null;
    }
    
    public T getProximo(){
        posicaoAtual = posicaoAtual.getProximo();
        return posicaoAtual.getValor();
    }
    
    
}
