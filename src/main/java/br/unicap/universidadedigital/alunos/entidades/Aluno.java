package main.java.br.unicap.universidadedigital.alunos.entidades;

public class Aluno implements Comparable{

    private String nome;
    private String CPF;
    private int idade;
    public String matricula;
    public float mensalidade;
    public float desconto;

    
    public Aluno(String nome, String CPF, 
                   int idade, String matricula, 
                   float mensalidade, float desconto) {
        this.nome = nome;
        this.CPF = CPF;
        this.idade = idade;
        this.matricula = matricula;
        this.mensalidade = mensalidade;
        this.desconto = desconto;
    }

    public Aluno(String nome) {
        this.nome = nome;
    }

    public Aluno(String vinicius, int i, int i0, int i1, int i2, int i3, float f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String cPF) {
        CPF = cPF;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public float getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(float mensalidade) {
        this.mensalidade = mensalidade;
    }
    
    public float atualizar(float percentual) {
        this.mensalidade = mensalidade + (mensalidade * percentual) ;
        return mensalidade;
    }
    

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    
    @Override
    public boolean equals(Object obj) {
        return (this.matricula.equals(
                    ((Aluno)obj).matricula)                
                );
    }
    
    @Override
    public String toString() {
        return matricula + " : " + nome;
    }

    @Override
    public int compareTo(Object o) {
        Aluno temp = (Aluno)o;
        return this.matricula.compareTo(temp.matricula);
    }

}