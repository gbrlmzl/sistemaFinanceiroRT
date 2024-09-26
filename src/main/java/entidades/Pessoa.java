package entidades;

import java.util.Objects;

public class Pessoa {
    private Integer cpf;
    private String nome;
    private Funcao funcao;

     public Pessoa(Integer cpf, String nome, int funcao){
         this.cpf = cpf;
         this.nome = nome;
         if(funcao == 0){
             this.funcao = Funcao.PAGA;
         }else{
             this.funcao = Funcao.RECEBE;
         }

     }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Funcao getFuncao() {
        return funcao;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(getCpf(), pessoa.getCpf());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCpf());
    }
}
