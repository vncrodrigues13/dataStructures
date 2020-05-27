package main.java.br.unicap.universidadedigital.colecoes.arvore;
import main.java.br.unicap.universidadedigital.alunos.entidades.Aluno;
public class testarvor {
    public static void main(String[] args) {
        
        /*
        Aluno[] alunos = {
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
        */
        Aluno a1 = new Aluno("Catapóbio",  "00000000000", 22, "000000", 600.00f, 0.00f);
        Aluno a2 = new Aluno("Maria",      "99999999999", 15, "999999", 1500.00f, 100.00f);
        Arvore test = new Arvore();
        test.adicionar(a2);
        test.adicionar(a1);
        System.out.println(test.getRaiz());
        System.out.println(test.getRaiz().getEsquerda());
        System.out.println(test.getRaiz().getDireita());
    }
}
