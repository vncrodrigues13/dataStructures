/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.br.unicap.universidadedigital.colecoes.filas;

import br.unicap.universidadedigital.colecoes.exceptions.ItemNaoEncontradoException;
import main.java.br.unicap.universidadedigital.colecoes.listas.ListaSimplesmenteLigada;
import main.java.br.unicap.universidadedigital.colecoes.comum.No;

/**
 *
 * @author tj
 */
public class Fila {
    
    
    ListaSimplesmenteLigada elementos = new ListaSimplesmenteLigada();
    
    
    
    public void inserir(No no){
        this.elementos.adicionaFim(no); //by pass
    }
    
    
    public No remover() throws ItemNaoEncontradoException{
        return this.elementos.removerInicio();
    }
    
    
    
}
