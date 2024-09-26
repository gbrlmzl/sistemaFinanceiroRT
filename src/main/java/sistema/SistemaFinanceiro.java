package sistema;


import entidades.*;
import exceptions.*;

import java.util.ArrayList;
import java.util.HashMap;

public class SistemaFinanceiro {
    private DespesaDoMes[] despesaDoMes;
    private HashMap<Integer, Pessoa> pessoas;


    public SistemaFinanceiro(){
        despesaDoMes = new DespesaDoMes[12];
        pessoas = new HashMap<>();
    }


    public void cadastrarDespesasDoMes(DespesaDoMes despesa){ //tratar exeções depois
        despesaDoMes[(despesa.getMes()-1)] = despesa;

    }

    public Pessoa pesquisaPessoaCpf(Integer Cpf){ //tratar exceções depois
        return pessoas.get(Cpf);
    }

    public boolean cadastrarPessoa(Pessoa novaPessoa) throws PessoaJaCadastradaException {
        if(pessoas.containsValue(novaPessoa)) throw new PessoaJaCadastradaException("Já existe uma pessoa cadastrada com esse CPF!");
        pessoas.put(novaPessoa.getCpf(), novaPessoa);
        return true;


    }

    public String calcularPagamento(DespesaDoMes despesaMes, Pessoa pagante, Pessoa recebedor){
        double gastosPagante = despesaMes.gastosDaPessoa(pagante);
        double gastosRecebedor = despesaMes.gastosDaPessoa(recebedor);

        double valor = (gastosRecebedor/2) - (gastosPagante/2);

        return         "Gastos de " + recebedor.getNome() + ": " + String.format("%.2f R$", gastosRecebedor) + "\n" +
                       "Gastos de " + pagante.getNome() + ": " + String.format("%.2f R$", gastosPagante) + "\n" +
                       "------------------------------------------------------------------------------------------\n"+
                       "Valor do pagamento ao recebedor: " + String.format("%.2f",valor);



    }


    public String formatarSistema(boolean confirmacao){
        if(confirmacao){
            despesaDoMes = new DespesaDoMes[12];
            pessoas = new HashMap<>();
            return "Sistema formatado com sucesso.";
        }
        return "Falha na formatação do sistema.";
    }

}
