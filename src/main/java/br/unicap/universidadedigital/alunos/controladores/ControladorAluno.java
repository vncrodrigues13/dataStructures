/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.br.unicap.universidadedigital.alunos.controladores;

import br.unicap.universidadedigital.alunos.entidades.Aluno;
import main.java.br.unicap.universidadedigital.colecoes.listas.iteradores.IteradorListaSimplesmenteLigada;
import main.java.br.unicap.universidadedigital.colecoes.listas.ListaSimplesmenteLigada;

/**
 *
 * @author tj
 */
public class ControladorAluno {
    
    private ListaSimplesmenteLigada<Aluno> alunos;

    
    
    public ControladorAluno(Aluno alunos[]) {
        this.alunos = new ListaSimplesmenteLigada<>(alunos);
    }
    
    
    //CRUDI
    
    
    public void inserirFim(Aluno a){
        this.alunos.adicionaFim(a);  //By pass
    }
    
    
    public void inserirInicio(Aluno a){
        this.alunos.adicionaInicio(a); //By pass
    }

    public float totalMensalidades() {
        
       IteradorListaSimplesmenteLigada<Aluno>  iterador = this.alunos.iterador();
               
       float total = 0.0f;
        
        while (iterador.existeProximo()){
            Aluno aluno = iterador.getProximo();
            total += aluno.getMensalidade();
        }
        
        return total;
    }


    
    
}
