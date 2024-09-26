package sistema;

import entidades.Gasto;
import entidades.Pessoa;

import java.util.ArrayList;

public class DespesaDoMes {
    private ArrayList<Gasto> listaDeGastos;
    private int mes;


    public DespesaDoMes(int mes){
        listaDeGastos = new ArrayList<>();
        this.mes = mes;
    }
    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void adicionarGasto(Gasto gasto){
        listaDeGastos.add(gasto);
    }

    public double gastosDaPessoa(Pessoa pessoa){
        double gastos = 0;
        for(Gasto g : listaDeGastos){
            if(g.getNomeDoResponsavel().equals(pessoa.getNome())){
                gastos += g.getValor();
            }
        }
        return gastos;
    }

    public ArrayList<Gasto> getListaDeGastos(){
        return listaDeGastos;
    }


}
