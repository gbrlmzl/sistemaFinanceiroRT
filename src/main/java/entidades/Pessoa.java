package entidades;

import java.io.Serializable;
import java.util.Objects;

public class Pessoa implements Serializable {
    private String cpf;
    private String nome;


     public Pessoa(String cpf, String nome){
         this.cpf = cpf;
         this.nome = nome;
     }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
