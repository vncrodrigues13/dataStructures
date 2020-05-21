package main.java.br.unicap.universidadedigital.colecoes.arvore;

import main.java.br.unicap.universidadedigital.colecoes.comum.NoArvore;
public class Arvore<T> {
    
    private NoArvore raiz;
    
    public Arvore(){
        raiz = null;
    }
    public Arvore (T elements[]){
        addListElement(elements);
    }
    public void addListElement(T elements[]){
        
    }
    
    public void adicionar(T element){
        NoArvore elem = new NoArvore (element);
        if (raiz == null){
            raiz = elem;
        }else{
            treeAdd(this.raiz, element);
        }
    }
    private void treeAdd(NoArvore raiz, T element){
        if (raiz == null)
            raiz = new NoArvore(element);
        
        int cmp = raiz.compareTo(element);
        
        if (cmp > 0){
            raiz.setDireita(element);
        }else if (cmp < 0){
            treeAdd(raiz.getEsquerda(), element);
        }else{
            
        }
        
            
    }
    
    
}
