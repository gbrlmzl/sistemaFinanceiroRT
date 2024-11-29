package sistema;

import entidades.Gasto;
import entidades.Pessoa;

import java.util.ArrayList;

public class DespesaDoMes {
    private ArrayList<Gasto> listaDeGastos;
    private String nomePagante;
    private String nomeRecebedor;
    private int mes;


    public DespesaDoMes(int mes, String nomePagante, String nomeRecebedor){
        listaDeGastos = new ArrayList<>();
        this.mes = mes;
        this.nomePagante = nomePagante;
        this.nomeRecebedor = nomeRecebedor;

    }
    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public String getNomePagante() {
        return nomePagante;
    }

    public String getNomeRecebedor() {
        return nomeRecebedor;
    }

    public void adicionarGasto(Gasto gasto){
        listaDeGastos.add(gasto);
    }

    public double totalGastosDaPessoa(Pessoa pessoa){
        double gastos = 0;
        for(Gasto g : listaDeGastos){
            if(g.getNomeDoResponsavel().equals(pessoa.getNome())){
                gastos += g.getValor();
            }
        }
        return gastos;
    }
    public String getInfoGastos(){
        StringBuilder gastosPagante = new StringBuilder();
        StringBuilder gastosRecebedor = new StringBuilder();
        gastosPagante.append("Gastos de " + nomePagante + ":" + "\n");
        for(Gasto gas : listaDeGastos){
            if(gas.getNomeDoResponsavel().equals(nomePagante)){
                gastosPagante.append(gas).append("\n");
            }else{
                gastosRecebedor.append(gas).append("\n");
            }
        }
        gastosPagante.append("\nGastos de " + nomeRecebedor + ":" +  "\n").append(gastosRecebedor);
        return gastosPagante.toString();
    }


    public ArrayList<Gasto> getListaDeGastos(){
        return listaDeGastos;
    }


}
