package main.java.br.unicap.universidadedigital.colecoes.arvore;

import main.java.br.unicap.universidadedigital.colecoes.comum.NoArvore;
import br.unicap.universidadedigital.colecoes.exceptions.ItemNaoEncontradoException;
import main.java.br.unicap.universidadedigital.colecoes.listas.ListaSimplesmenteLigada;

public class Arvore<T extends Comparable<T>> {

    private NoArvore<T> raiz;
    private ListaSimplesmenteLigada<T> listaAuxiliar = new ListaSimplesmenteLigada<>();

    public Arvore() {
        raiz = null;
    }

    public Arvore(T elements[]) {
        addListElement(elements);
    }

    public NoArvore<T> getRaiz() {
        return raiz;
    }

    public void addListElement(T elements[]) {
        for (T element : elements) {
            adicionar(element);
        }
    }

    /*
    public void adicionar(T element) {
        if (this.raiz == null) {
            raiz = new NoArvore<T>(element);
        } else {
            treeAdd(this.raiz, element);
        }
    }
    */
    public void adicionar(T element){
        if (this.raiz == null){
            raiz = new NoArvore<T>(element);
        }else{
            this.raiz = treeAdd(raiz,element);
        }
        
    }
    
    /*
    private void treeAdd(NoArvore<T> raiz, T element) {
        int comparableValue = raiz.compareTo(element);
        if (comparableValue >= 0) {
            if (raiz.getDireita() != null) {
                treeAdd(raiz.getDireita(), element);
            } else {
                raiz.setDireita(element);
            }
        } else {
            if (raiz.getEsquerda() != null) {
                treeAdd(raiz.getEsquerda(), element);
            } else {
                raiz.setEsquerda(element);
            }
        }
    }
    */
    
    private NoArvore<T> treeAdd(NoArvore<T> raiz, T element){
        int comparableValue = raiz.compareTo(element);
        if (comparableValue >= 0){
            if (raiz.getDireita() != null){
                return treeAdd(raiz.getDireita(),element);
            }else{
                raiz.setDireita(element);
            }
        }else{
            if (raiz.getEsquerda() != null){
                return treeAdd(raiz.getEsquerda(),element);
            }else{
                raiz.setEsquerda(element);
            }
        }
        
        if (fatorDeBalanceamento(raiz) > 1 || fatorDeBalanceamento(raiz) < 1){
            balance(raiz);
        }
        
        
        return raiz;
    }
      
    
    public int fatorDeBalanceamento(NoArvore<T> raiz){
        if (raiz.getEsquerda() != null && raiz.getDireita() != null){
            //in case that have 2 chilrens
            return fatorDeBalanceamento(raiz.getEsquerda()) - fatorDeBalanceamento(raiz.getDireita());
        }
        else if (raiz.getEsquerda() != null && raiz.getDireita() == null){
            //left children only
            return fatorDeBalanceamento(raiz.getEsquerda()) + 1; 
            //if i don't have the right children, we put a -1 in place, and continue the recursion
        }
        else if (raiz.getEsquerda() == null && raiz.getDireita() != null){
            //right children only
            return 1 - fatorDeBalanceamento(raiz.getDireita());
        }else{
            return 0;
        }
    }
    
    
    private NoArvore<T> balance(NoArvore<T> raiz){
        NoArvore<T> aux;
        if (raiz.getDireita() != null){
            //se houver nó a direita, só pode ser apenas RR ou RL
            if (raiz.getDireita().getDireita()!= null) //se houver no a direita, após a direita, significa que ela é um RR
                return rotationRR(raiz);
            else //se houver no a esquerda, após a direita, significa que ela é um RL
                return rotationRL(raiz);
        }else{
            //se houver nó a esquerda, só pode ser LL ou LR
            if (raiz.getEsquerda().getEsquerda() != null) //se houver no a esquerda, após a esquerda, significa que ela é um LL
                return rotationLL(raiz);
            else //se houver nó a direita, após a esquerda, significa que ela é um LR
                return rotationLR(raiz);
        }
            
    }
    
    
    private NoArvore<T> rotationRR(NoArvore<T> raiz){
        NoArvore<T> x = raiz.getDireita();
        raiz.setDireita(x.getEsquerda());
        x.setEsquerda(raiz);
        return x;
    }
    
    private NoArvore<T> rotationRL(NoArvore<T> raiz){
        raiz.setDireita(rotationLL(raiz.getDireita()));
        return rotationRR(raiz);
    }
    private NoArvore<T> rotationLL(NoArvore<T> raiz){
        NoArvore<T> x = raiz.getEsquerda();
        raiz.setEsquerda(x.getDireita());
        x.setDireita(raiz);
        return x;
    }
    private NoArvore<T> rotationLR(NoArvore<T> raiz){
        raiz.setEsquerda(rotationRR(raiz.getEsquerda()));
        return rotationLL(raiz);
    }

    public NoArvore<T> getElement(T element) throws ItemNaoEncontradoException {
        return buscarElemento(raiz, element);
    }

    private NoArvore<T> buscarElemento(NoArvore<T> raiz, T element) {
        if (raiz == null) {
            return null;
        }

        int comparableValue = raiz.compareTo(element);

        if (comparableValue > 0) {
            return buscarElemento(raiz.getDireita(), element);
        } else if (comparableValue < 0) {
            return buscarElemento(raiz.getEsquerda(), element);
        } else {
            return raiz;
        }
    }

    public void traverseInOrder(NoArvore<T> raiz) {

        if (raiz != null) {
            traverseInOrder(raiz.getEsquerda());
            System.out.println(" " + raiz.getValor().toString());
            traverseInOrder(raiz.getDireita());
        }
    }

    public ListaSimplesmenteLigada<T> preOrder() {
        listaAuxiliar = new ListaSimplesmenteLigada<>();
        preOrder(raiz);
        return this.listaAuxiliar;
    }

    private void preOrder(NoArvore<T> raiz) {
        listaAuxiliar.adicionaFim(raiz.getValor());
        if (raiz.getEsquerda() != null) {
            preOrder(raiz.getEsquerda());
        }
        if (raiz.getDireita() != null) {
            preOrder(raiz.getDireita());
        }
    }

    public ListaSimplesmenteLigada<T> order() {
        listaAuxiliar = new ListaSimplesmenteLigada<>();
        order(raiz);
        return this.listaAuxiliar;
    }

    public void order(NoArvore<T> raiz) {
        if (raiz.getEsquerda() != null) {
            order(raiz.getEsquerda());
        }
        listaAuxiliar.adicionaFim(raiz.getValor());
        if (raiz.getDireita() != null) {
            order(raiz.getDireita());
        }
    }

    public ListaSimplesmenteLigada<T> posOrder() {
        listaAuxiliar = new ListaSimplesmenteLigada<>();
        posOrder(raiz);
        return this.listaAuxiliar;
    }

    public void posOrder(NoArvore<T> raiz) {
        if (raiz.getEsquerda() != null) {
            order(raiz.getEsquerda());
        }
        if (raiz.getDireita() != null) {
            order(raiz.getDireita());
        }
        listaAuxiliar.adicionaFim(raiz.getValor());
    }

    private NoArvore<T> ultimoValoraEsquerda(NoArvore<T> raiz) {
        NoArvore<T> valor;
        if (raiz.getEsquerda() != null) {
            return ultimoValoraEsquerda(raiz.getEsquerda());
        } else {
            valor = raiz.clone();
            if (raiz.getDireita() != null) {
                raiz = raiz.getDireita();
            }
            valor = raiz;
            return valor;
        }
    }

    public void remover(T element) {
        if (buscarElemento(raiz, element) != null) {
            NoArvore<T> raizAlterada = refatorandoNo(element);
            refatorandoArvore(raiz, raizAlterada);
        } else {
            System.out.println("Elemento não existe na árvore");
        }

    }

    private void refatorandoArvore(NoArvore<T> raiz, NoArvore<T> raizAlterada) {
        if (raiz.getDireita().equals(raizAlterada)) {
            raiz.setDireita(raizAlterada);
        }
        if (raiz.getEsquerda().equals(raizAlterada)) {
            raiz.setEsquerda(raizAlterada);
        }

        if (raiz.compareTo(raizAlterada.getValor()) > 0) {
            refatorandoArvore(raiz.getDireita(), raizAlterada);
        } else {
            refatorandoArvore(raiz.getEsquerda(), raizAlterada);
        }
    }

    private NoArvore<T> refatorandoNo(T element) {
        NoArvore<T> NoElementoRm = buscarElemento(raiz, element);

        switch (NoElementoRm.numeroDeFilhos()) {
            case 2:
                NoElementoRm = removerDoisFilhos(NoElementoRm);
                break;
            case 1:
                NoElementoRm = removerUmFilho(NoElementoRm);
                break;
            case 0:
                return null;

        }
        return NoElementoRm;

    }

    private NoArvore<T> removerDoisFilhos(NoArvore<T> raiz) {
        T valueReplace = ultimoValoraEsquerda(raiz.getDireita()).getValor();
        raiz.setValor(valueReplace);
        return raiz;
    }

    private NoArvore<T> removerUmFilho(NoArvore<T> raiz) {
        if (raiz.getDireita() != null) {
            raiz = raiz.getDireita();
        } else {
            raiz = raiz.getEsquerda();
        }
        return raiz;
    }
    
    
    
       
      
    
    
    

}
