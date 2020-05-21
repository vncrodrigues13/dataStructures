/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.br.unicap.universidadedigital;

import main.java.br.unicap.universidadedigital.alunos.entidades.Aluno;
import main.java.br.unicap.universidadedigital.alunos.controladores.ControladorAluno;


/**
 *
 * @author tj
 */
public class Main {
    
    static Aluno[] alunos = {
        new Aluno("Catapóbio",  "00000000000", 22, "000000", 600.00f, 0.00f),
        new Aluno("Saponácio",  "11111111111", 23, "111111", 300.00f, 0.00f),
        new Aluno("Fulustreco", "22222222222", 20, "222222", 1500.00f, 10.00f),
        new Aluno("Coníglio",   "33333333333", 17, "333333", 4400.00f, 30.00f),
        new Aluno("Austin",     "44444444444", 22, "444444", 3000.00f, 30.00f),
        new Aluno("Antonio",    "55555555555", 22, "555555", 400.00f, 0.00f),
        new Aluno("Tj",         "66666666666", 40, "666666", 545.00f, 0.00f),
        new Aluno("Márcio",     "77777777777", 12, "777777", 560.00f, 10.00f),
        new Aluno("Ana",        "88888888888", 20, "888888", 800.00f, 15.00f),
        new Aluno("Maria",      "99999999999", 15, "999999", 1500.00f, 100.00f),
    
    };
      
    
    
    //Camada de Integracao -> Controlador -> Coleção
      
    public static void main(String[] args) {
        
        ControladorAluno alunoControler = new ControladorAluno(alunos);

        System.out.println("Soma das mensalidades: R$ " + alunoControler.totalMensalidades());
    } 
    
}