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
import main.java.br.unicap.universidadedigital.colecoes.comum.NoDuplamenteLigado;

/*
 *
 * @author tj
 */
public class ListaDuplamenteLigada <T>{
    
    private NoDuplamenteLigado<T> inicio;
    private NoDuplamenteLigado<T> fim;
    
    public ListaDuplamenteLigada() {
        inicio = null;
        fim = null;
    }

    public ListaDuplamenteLigada(T elementos[]) {
         for (T a : elementos) {
            this.adicionaFim(a);
        }
    }

    public NoDuplamenteLigado<T> getInicio() {
        return inicio;
    }
    
    public void adicionaFim(T novo) {
        
        NoDuplamenteLigado<T> no = new NoDuplamenteLigado<>(novo);
        
        if (inicio == null){
            inicio = no;
        } else {
            no.setAnterior(fim);
            fim.setProximo(no);
        }
        fim = no;
    }
    
    public void adicionaInicio(T novo) {
        NoDuplamenteLigado<T> no = new NoDuplamenteLigado<T>(novo);
        no.setProximo(inicio);
        inicio.setAnterior(no);
        inicio = no;
        
        if (fim == null){
            fim = no;
        }

    }
    
    public void adicionaPos(NoDuplamenteLigado<T> novo,int pos) throws PosicaoInvalidaException{
        if (pos==0){
           novo.setProximo(inicio);
           inicio = novo;
        } else {
            NoDuplamenteLigado<T> iterador = inicio;
            NoDuplamenteLigado<T> anterior = null;
            int cont = 0;
            
            while (iterador != null){
                
                if (cont == pos){
                    anterior.setProximo(novo);
                    iterador.setAnterior(novo);
                    novo.setAnterior(anterior);
                    novo.setProximo(iterador);
                }
                anterior = iterador;
                iterador = iterador.getProximo();
                cont++;
            }
        }
    }
    
    /*
     * Esse método devolve o elemento da i-ésima posição.
     * 
     * @para i Posição do elemento a ser recuperado na lista
     * 
     * @return Elemento da posição i ou null caso a posição não exista na lista.
     * 
    */
    public NoDuplamenteLigado<T> elementoEm(int i){
        NoDuplamenteLigado<T> iterador = inicio;
        NoDuplamenteLigado<T> retorno = null;
        int count =0;
        
        while (iterador != null){
        
            if(count == i){
                return iterador;
            }
            count++;
            iterador = iterador.getProximo();
        }
        return null;
    }
    
    /*
     * Esse método os elementos de posição par da lista.
     * 
     * @return A lista de elementos de posição par, incluindo o elemento da posição zero.
     * Ou seja os elementos 0, 2, 4, 6, 8 ...
     * 
    */
    public ListaDuplamenteLigada<T> elementosDePosicaoPar(){
        
        ListaDuplamenteLigada<T> auxiliar = new ListaDuplamenteLigada<T>();
        NoDuplamenteLigado<T> iterador = inicio;
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
    
    
    /*
     * Esse método devolve a lista invertida.
     * 
     * @return A lista de elementos invertida. O último elemento passa a ser o primeiro,
     * o penúltimo o segundo, o antepenúltipo o terceiro e assim sucessivamente.
     * 
    */
    public ListaDuplamenteLigada<T> inverte(){
        
        ListaDuplamenteLigada<T> auxiliar = new ListaDuplamenteLigada<>();
        NoDuplamenteLigado<T> iterador = inicio;
        
        while (iterador != null){
            
            auxiliar.adicionaInicio(iterador.getValor());
            
            iterador = iterador.getProximo();
        
        }
        
        return auxiliar;
    }
    

    public boolean existe(No no) {
        NoDuplamenteLigado<T> iterador = inicio;
        
        do{
            if(iterador.getValor().equals(no.getValor())){
                return true;
            }
            
            iterador = iterador.getProximo();
        }while(iterador!=null);
            
        return false;
    }

    public void atualizar(NoDuplamenteLigado<T> no) throws ItemNaoEncontradoException {
        NoDuplamenteLigado<T> anterior = null; 
        NoDuplamenteLigado<T> iterador = inicio;
        
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

    public void remover(NoDuplamenteLigado<T> no)  throws ItemNaoEncontradoException {
        NoDuplamenteLigado<T> anterior = null; 
        NoDuplamenteLigado<T> iterador = inicio;
        
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
    
    public NoDuplamenteLigado<T> removerInicio()  throws ItemNaoEncontradoException {
        
        
        if(inicio == null ){
            throw new ItemNaoEncontradoException();
        }
            
        NoDuplamenteLigado<T> retorno = inicio;
        
        inicio = inicio.getProximo();
        
        retorno.setProximo(null);
        
        return retorno;
    }
    
    public NoDuplamenteLigado<T> removerFim()  throws ItemNaoEncontradoException {
        NoDuplamenteLigado<T> anterior = null; 
        NoDuplamenteLigado<T> iterador = fim;
        
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
            NoDuplamenteLigado<T> ultimoNo = inicio;
            while(ultimoNo.getProximo() != null){
                count++;
                ultimoNo = ultimoNo.getProximo();
            }
        }
        return count;
    }
    @Override
    public String toString() {
        //Uso de string para concatenações não é recomendado. Veremos uma melhor forma em breve
        String lista;
        NoDuplamenteLigado<T> interador = inicio;
        lista = "";
        while(interador != null){
            lista = lista+ " " + interador.getValor() + " \n";
            interador = interador.getProximo();
        }    
        return lista;
    }


   
}
