package main.java.br.unicap.universidadedigital.colecoes.comum;
import main.java.br.unicap.universidadedigital.alunos.entidades.Aluno;
public class NoArvore <T extends Comparable> implements Comparable<T> {
    
    private T valor;    
    private NoArvore esquerda;
    private NoArvore direita;
    
    public NoArvore(){}      
    public NoArvore(T valor){
        this.valor = valor;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public NoArvore<T> getEsquerda(){
        return this.esquerda;
    }
    public void setEsquerda(T element){
        this.esquerda = (new NoArvore(element));
    }
    public NoArvore<T> getDireita(){
        return this.direita;
    }
    public void setDireita(T element){
        this.direita = (new NoArvore(element));
    }
    
    
    @Override
    public String toString() {
        return ((Aluno)this.valor).toString();
    }
 
    @Override
    public NoArvore<T> clone() {
        NoArvore<T> novo = new NoArvore<>(valor);
        return novo;
    }
    
    @Override
    public int compareTo(T o){
        Aluno value = (Aluno) this.valor;
        Aluno comparableValue = (Aluno)o;
        return comparableValue.compareTo(value);
    }
    
}
