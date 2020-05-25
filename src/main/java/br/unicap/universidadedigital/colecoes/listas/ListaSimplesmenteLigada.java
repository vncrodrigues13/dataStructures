/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.br.unicap.universidadedigital.colecoes.listas;
import main.java.br.unicap.universidadedigital.colecoes.listas.iteradores.IteradorListaSimplesmenteLigada;
import br.unicap.universidadedigital.colecoes.exceptions.ItemNaoEncontradoException;
import main.java.br.unicap.universidadedigital.colecoes.comum.No;
import main.java.br.unicap.universidadedigital.colecoes.exceptions.PosicaoInvalidaException;

/**
 *
 * @author tj
 */
public class ListaSimplesmenteLigada <T>{
    
    private No<T> inicio;
    private No<T> fim;
    
    public ListaSimplesmenteLigada() {
        inicio = null;
        fim = null;
    }

    public ListaSimplesmenteLigada(T elementos[]) {
         for (T a : elementos) {
            this.adicionaFim(a);
        }
    }

    public No<T> getInicio() {
        return inicio;
    }
    
    public void adicionaFim(T novo) {
        
        No<T> no = new No<>(novo);
        
        if (inicio == null){
            inicio = no;
        } else {
            fim.setProximo(no);
        }
        fim = no;
    }
    
    public void adicionaInicio(T novo) {
        No<T> no = new No<>(novo);
        no.setProximo(inicio);
        inicio = no;
        
        if (fim == null){
            fim = no;
        }

    }
    
    public void adicionaPos(No<T> novo,int pos) throws PosicaoInvalidaException{
        if (pos==0){
           novo.setProximo(inicio.getProximo());
           inicio = novo;
        } else {
            No iterador = inicio;
            for(int count=0; count < (pos-1); count++){
                iterador = iterador.getProximo();
            } 
            novo.setProximo(iterador.getProximo());
            iterador.setProximo(novo);
        }
    }
    
    /**
     * Esse método devolve o elemento da i-ésima posição.
     * 
     * @para i Posição do elemento a ser recuperado na lista
     * 
     * @return Elemento da posição i ou null caso a posição não exista na lista.
     * 
    */
    public No<T> elementoEm(int i){
        
        No<T> iterador = inicio;
        int count =0;
        No<T> retorno = null;
        
        while (iterador != null){
        
            if(count == i){
                retorno = iterador;
                break;
            }
            
            count++;
            iterador = iterador.getProximo();
        
        }
        
 
        return retorno;    
    }
    
    /**
     * Esse método os elementos de posição par da lista.
     * 
     * @return A lista de elementos de posição par, incluindo o elemento da posição zero.
     * Ou seja os elementos 0, 2, 4, 6, 8 ...
     * 
    */
    public ListaSimplesmenteLigada<T> elementosDePosicaoPar(){
        
        ListaSimplesmenteLigada<T> auxiliar = new ListaSimplesmenteLigada<T>();
        No<T> iterador = inicio;
        int count = 0;
        
        while (iterador != null){
            
            if(count % 2 == 0){
                auxiliar.adicionaFim(iterador.getValor());
            }    
            
            count++;
            iterador = iterador.getProximo();
        
        }
        
        return auxiliar;      
    }
    
    
    /**
     * Esse método devolve a lista invertida.
     * 
     * @return A lista de elementos invertida. O último elemento passa a ser o primeiro,
     * o penúltimo o segundo, o antepenúltipo o terceiro e assim sucessivamente.
     * 
    */
    public ListaSimplesmenteLigada<T> inverte(){
        
        ListaSimplesmenteLigada<T> auxiliar = new ListaSimplesmenteLigada<>();
        No<T> iterador = inicio;
        
        while (iterador != null){
            
            auxiliar.adicionaInicio(iterador.getValor());
            
            iterador = iterador.getProximo();
        
        }
        
        return auxiliar;
    }
    

    public boolean existe(No no) {
        No<T> iterador = inicio;
        
        do{
            if(iterador.getValor().equals(no.getValor())){
                return true;
            }
            
            iterador = iterador.getProximo();
        }while(iterador!=null);
            
        return false;
    }

    public void atualizar(No<T> no) throws ItemNaoEncontradoException {
        No<T> anterior = null; 
        No<T> iterador = inicio;
        
        do{
            if(iterador.getValor().equals(no.getValor())){
               if(anterior!=null){ 
                   anterior.setProximo(no);
               }else{
                   inicio = no;
               } 
               no.setProximo(iterador.getProximo());
               return;
            }
            
            anterior = iterador;
            iterador = iterador.getProximo();
        }while(iterador!=null);
            
        throw new ItemNaoEncontradoException();
    }

    public No<T> consultar(No<T> no) {
        return null;
    }

    public void remover(No<T> no)  throws ItemNaoEncontradoException {
        No<T> anterior = null; 
        No<T> iterador = inicio;
        
        do{
            if(iterador.getValor().equals(no)){
                
               if (anterior!=null)
                   anterior.setProximo(iterador.getProximo());
               else
                   inicio = iterador.getProximo();
               
               iterador.setProximo(null);
               return;
            }
            anterior = iterador;
            iterador = iterador.getProximo();
        }while(iterador!=null);
            
        throw new ItemNaoEncontradoException();
    }
    
    public No<T> removerInicio()  throws ItemNaoEncontradoException {
        if(inicio == null ){
            throw new ItemNaoEncontradoException();
        }
            
        No<T> retorno = inicio;
        
        inicio = inicio.getProximo();
        
        retorno.setProximo(null);
        
        return retorno;
    }
    
    public No<T> removerFim()  throws ItemNaoEncontradoException {
        No<T> anterior = null; 
        No<T> iterador = fim;
        
        if(iterador == null ){
            throw new ItemNaoEncontradoException();
        }
            
        
        while (iterador != null){
            
            
            if(iterador == fim){
                
                anterior.setProximo(null);
                fim = anterior;
                
                return iterador;
            }
            
            anterior = iterador;
            iterador = iterador.getProximo();
        }
        return null;
    }

    public int tamanho() {
        int count;
        
        if (inicio == null){
            count = 0;
        } else {
            count = 1;
            No<T> ultimoNo = inicio;
            while(ultimoNo.getProximo() != null){
                count++;
                ultimoNo = ultimoNo.getProximo();
            }
        }
        return count;
    }

    
    
    public IteradorListaSimplesmenteLigada<T> iterador() {
        return new IteradorListaSimplesmenteLigada<>(this.inicio);
    }
    
    
    @Override
    public String toString() {
        //Uso de string para concatenações não é recomendado. Veremos uma melhor forma em breve
        String lista;

        No<T> interador = inicio;

        lista = "";
        while(interador != null){
            lista = lista+ " " + interador.getValor() + " \n";
            interador = interador.getProximo();
        }    
    

        return lista;
    }


   
}
