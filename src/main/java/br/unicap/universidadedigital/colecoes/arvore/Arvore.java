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

    public void adicionar(T element) {
        if (this.raiz == null) {
            raiz = new NoArvore<T>(element);
        } else {
            treeAdd(this.raiz, element);
        }
    }

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
            if (raiz.getDireita() != null) {
                valor = raiz.clone();
                raiz = raiz.getDireita();
            }
            valor = raiz;
            return valor;
        }
    }

    public void remover(T element) {
        NoArvore<T> raizAlterada = modificandoArvore(element);
        refazerArvore(raiz, raizAlterada);

    }

    private void refazerArvore(NoArvore<T> raiz, NoArvore<T> raizAlterada) {
        if (raiz.getDireita().equals(raizAlterada)) {
            raiz.setDireita(raizAlterada.getValor());
            raiz.setDireita(raizAlterada);
        }
        if (raiz.getEsquerda().equals(raizAlterada)) {
            raiz.setEsquerda(raizAlterada.getValor());
            raiz.setEsquerda(raizAlterada);
        }

        if (raiz.compareTo(raizAlterada.getValor()) > 0) {
            refazerArvore(raiz.getDireita(), raizAlterada);
        } else {
            refazerArvore(raiz.getEsquerda(), raizAlterada);
        }
    }

    private NoArvore<T> modificandoArvore(T element) {
        NoArvore<T> NoElementoRm = buscarElemento(raiz, element);
        if (NoElementoRm != null) {
            switch (NoElementoRm.numeroDeFilhos()) {
                case 2:
                    NoElementoRm = remover(NoElementoRm, element);
                    break;
                case 1:
                    NoElementoRm = removerFolha(NoElementoRm);
                    break;
                case 0:
                    return null;
            }
        } else {
            System.out.println("Esse elemento não existe");
            return null;
        }

        return NoElementoRm;

    }

    private NoArvore<T> remover(NoArvore<T> raiz, T element) {
        T valueReplace = ultimoValoraEsquerda(raiz.getDireita()).getValor();
        raiz.setValor(valueReplace);
        return raiz;
    }

    private NoArvore<T> removerFolha(NoArvore<T> raiz) {
        if (raiz.getDireita() != null) {
            raiz.setValor(raiz.getDireita().getValor());
        } else {
            raiz.setValor(raiz.getEsquerda().getValor());
        }
        return raiz;
    }

}
