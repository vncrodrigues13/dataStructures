import main.java.br.unicap.universidadedigital.colecoes.comum.No;

public class IteradorListaDuplamenteLigada<T> {
    No<T> posAtual;

    public boolean existeProximo(){
        return this.posAtual.getProximo() != null;
    }
    
}