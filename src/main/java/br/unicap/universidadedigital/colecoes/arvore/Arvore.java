package main.java.br.unicap.universidadedigital.colecoes.arvore;

import main.java.br.unicap.universidadedigital.colecoes.comum.NoArvore;
import br.unicap.universidadedigital.colecoes.exceptions.ItemNaoEncontradoException;

import main.java.br.unicap.universidadedigital.colecoes.listas.ListaSimplesmenteLigada;

public class Arvore<T extends Comparable<T>> {

    private NoArvore raiz;

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

    public void adicionar(T element) {
        NoArvore elem = new NoArvore(element);
        if (raiz == null) {
            raiz = elem;
        } else {
            treeAdd(this.raiz, element);
        }
    }

    private NoArvore<T> treeAdd(NoArvore raiz, T element) {
        if (raiz == null) {
            return new NoArvore<T>(element);
        }
        int cmp = raiz.compareTo(element);

        if (cmp     > 0) {
            raiz.setDireita(treeAdd(raiz.getDireita(), element));
        } else if (cmp < 0) {
            raiz.setEsquerda(treeAdd(raiz.getEsquerda(), element));
        }else{
            return raiz;
        }
        return raiz;
    }

    /*
    
    private Node addRecursive(Node current, int value) {
    if (current == null) {
        return new Node(value);
    }
 
    if (value < current.value) {
        current.left = addRecursive(current.left, value);
    } else if (value > current.value) {
        current.right = addRecursive(current.right, value);
    } else {
        // value already exists
        return current;
    }
 
    return current;
}
     */
    public NoArvore<T> getElement(T element) throws ItemNaoEncontradoException {
        return buscarElemento(raiz, element);
    }

    private NoArvore<T> buscarElemento(NoArvore<T> raiz, T element) throws ItemNaoEncontradoException {
        if (raiz == null) {
            throw new ItemNaoEncontradoException();
        }

        int aux = raiz.compareTo(element);

        if (aux > 0) {
            return buscarElemento(raiz.getDireita(), element);
        } else if (aux < 0) {
            return buscarElemento(raiz.getEsquerda(), element);
        } else {
            return raiz;
        }
    }

    public ListaSimplesmenteLigada<T> getPreOrdem() {
        ListaSimplesmenteLigada<T> listaauxiliar = new ListaSimplesmenteLigada<>();
        return listaauxiliar;
    }

    public void traverseInOrder(NoArvore<T> raiz) {

        if (raiz != null) {
            traverseInOrder(raiz.getEsquerda());
            System.out.print(" " + raiz.getValor());
            traverseInOrder(raiz.getDireita());
        }
    }

}
