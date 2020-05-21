package main.java.br.unicap.universidadedigital.colecoes.arvore;
import main.java.br.unicap.universidadedigital.colecoes.comum.NoArvore;
import br.unicap.universidadedigital.colecoes.exceptions.ItemNaoEncontradoException;
        
public class Arvore <T extends Comparable<T> > {
    
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
            treeAdd(raiz.getDireita(), element);
        }else if (cmp < 0){
            treeAdd(raiz.getEsquerda(), element);
        }
    }
    
    
    public NoArvore<T> getElement(T element) throws ItemNaoEncontradoException{
        return buscarElemento(raiz, element);
    }
    
    
    private NoArvore<T> buscarElemento(NoArvore<T> raiz,T element) throws ItemNaoEncontradoException{
        if (raiz == null)
            throw new ItemNaoEncontradoException();
        
        int aux = raiz.compareTo(element);
        
        if (aux > 0){
            return buscarElemento(raiz.getDireita(), element);
        }else if (aux < 0){
            return buscarElemento(raiz.getEsquerda(), element);
        }else{
            return raiz;
        }
        
        
    }
    
    
}
