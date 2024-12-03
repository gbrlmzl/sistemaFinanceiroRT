package sistema;


import data.Gravador;
import entidades.*;
import exceptions.*;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class SistemaFinanceiro implements Serializable {
    private DespesaDoMes[] despesaDoMes;
    private Pessoa[] pessoas;
    private Gravador gravador;




    public SistemaFinanceiro(){
        despesaDoMes = new DespesaDoMes[12];
        pessoas = new Pessoa[2];
        pessoas[0] = new Pessoa("11965734413", "Gabriel Mizael");
        pessoas[1] = new Pessoa("", "Victor Hugo");
        gravador = new Gravador();
    }


    public void cadastrarDespesasDoMes(DespesaDoMes despesa){ //tratar exeções depois
        despesaDoMes[(despesa.getMes()-1)] = despesa;

    }

    public Pessoa pesquisaPessoaId(int Id) { //tratar exceções depois
        return pessoas[Id];
    }

    public boolean cadastrarPessoa(Pessoa novaPessoa) throws PessoaJaCadastradaException {
        if(cadastroValido(novaPessoa)){
            if(pessoas[0] == null){
                pessoas[0] = novaPessoa;
            }else if(pessoas[1] == null){
                pessoas[1] = novaPessoa;
            }
            return true;
        }
        return false;



    }
    private boolean cadastroValido(Pessoa novaPessoa){
        for(Pessoa p: pessoas){
            if(p == null){
                continue;
            }
            if(p.getCpf().equals(novaPessoa.getCpf())){
                return false;
            }
        }
        return true;
    }

    public String calcularPagamento(DespesaDoMes despesaMes){
        double gastosPagante = despesaMes.totalGastosDaPessoa(despesaMes.getNomePagante());
        double gastosRecebedor = despesaMes.totalGastosDaPessoa(despesaMes.getNomeRecebedor());

        double valor = (gastosRecebedor/2) - (gastosPagante/2);

        return         "Gastos de " + despesaMes.getNomeRecebedor() + ": " + String.format("%.2f R$", gastosRecebedor) + "\n" +
                       "Gastos de " + despesaMes.getNomePagante() + ": " + String.format("%.2f R$", gastosPagante) + "\n" +
                       "------------------------------------------------------------------------------------------\n"+
                       "Valor do pagamento a " + despesaMes.getNomeRecebedor() +": " + String.format("%.2f",valor);



    }


    public String formatarSistema(boolean confirmacao){
        if(confirmacao){
            despesaDoMes = new DespesaDoMes[12];
            pessoas = new Pessoa[2];
            return "Sistema formatado com sucesso.";
        }
        return "Falha na formatação do sistema.";
    }

    public String getInfoGastos(int mes) throws DadosNaoCadastradosException {
        if(despesaDoMes[mes] != null){
            return despesaDoMes[mes].getInfoGastos();
        }
        throw new DadosNaoCadastradosException("Não há despesas cadastradas nesse mês!");
        //lançar exceção
    }

    public String[] opcoesNome(){
        return new String[]{pessoas[0].getNome(), pessoas[1].getNome()};
    }

    public boolean despesasJaCadastradas(int mes){
        if(despesaDoMes[mes] != null){
            return true;
        }
        return false;
    }
    public boolean baixarListaDespesas(int mes, String path) throws IOException {
        File filePath = new File(path);
        String infoDespesas = despesaDoMes[mes].getInfoGastos();
        Scanner sc = new Scanner(infoDespesas);
        BufferedWriter bw = new BufferedWriter(new FileWriter(path));
        while(sc.hasNextLine()){
            bw.write(sc.nextLine());
            bw.newLine();

        }
        bw.close();
        sc.close();
        return true;
    }

    public





}
