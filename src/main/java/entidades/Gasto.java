package entidades;

import java.io.Serializable;

public class Gasto implements Serializable {
    private String identificacao;
    private double valor;
    private String nomeDoResponsavel;

    public Gasto(String identificacao, double valor, String nomeDoResponsavel){
        this.identificacao = identificacao;
        this.valor = valor;
        this.nomeDoResponsavel = nomeDoResponsavel;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getNomeDoResponsavel() {
        return nomeDoResponsavel;
    }

    public void setNomeDoResponsavel(String nomeDoResponsavel) {
        this.nomeDoResponsavel = nomeDoResponsavel;
    }

    @Override
    public String toString(){
        return identificacao + "  ->  " + valor + " R$";
    }

}
