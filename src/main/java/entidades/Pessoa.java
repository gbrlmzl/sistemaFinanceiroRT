package entidades;

import java.io.Serializable;
import java.util.Objects;

public class Pessoa implements Serializable {
    private String numeroTelefone;
    private String nome;


     public Pessoa(String numeroTelefone, String nome){
         this.numeroTelefone = numeroTelefone;
         this.nome = nome;
     }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
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
        return Objects.equals(getNumeroTelefone(), pessoa.getNumeroTelefone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumeroTelefone());
    }
}
