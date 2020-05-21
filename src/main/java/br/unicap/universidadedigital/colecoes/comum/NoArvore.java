package main.java.br.unicap.universidadedigital.colecoes.comum;
import main.java.br.unicap.universidadedigital.alunos.entidades.Aluno;
public class NoArvore <T> implements Comparable<T>{
    
    private T valor;    
    private NoArvore esquerda;
    private NoArvore direita;
    
      
    public NoArvore(T valor){
        this.valor = valor;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public NoArvore getEsquerda(){
        return this.esquerda;
    }
    public void setEsquerda(T element){
        this.esquerda = (new NoArvore(element));
    }
    public NoArvore getDireita(){
        return this.direita;
    }
    public void setDireita(T element){
        this.direita = (new NoArvore(element));
    }
    
    
    @Override
    public String toString() {
        return valor.toString();
    }
 
    @Override
    public NoArvore<T> clone() {
        NoArvore<T> novo = new NoArvore<>(valor);
        return novo;
    }

    @Override
    public int compareTo(T o) {
        Aluno value = (Aluno)valor;
        NoArvore valueCompareAux = (NoArvore)o;
        Aluno valueCompare = (Aluno) valueCompareAux.getValor();
        return value.compareTo(valueCompare);
    }
}
