/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.br.unicap.universidadedigital.colecoes.comum;

/**
 *
 * @author tj 
 */
public class NoDuplamenteLigado <T> {
    
    private T valor;    
    private NoDuplamenteLigado<T> proximo;
    private NoDuplamenteLigado<T> anteror;
      
    public NoDuplamenteLigado(T valor) {
        this.valor = valor;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public NoDuplamenteLigado<T> getProximo() {
        return proximo;
    }

    public void setProximo(NoDuplamenteLigado<T> proximo) {
        this.proximo = proximo;
    }
    
    public NoDuplamenteLigado<T> getAnterior(){
        return this.proximo;
    }
    public void setAnterior(NoDuplamenteLigado<T> anterior){
        this.anteror = anterior;
    }

    @Override
    public String toString() {
        return valor.toString();
    }
 
    @Override
    public NoDuplamenteLigado<T> clone() {
        NoDuplamenteLigado<T> novo = new NoDuplamenteLigado<>(valor);
        return novo;
    }
}
