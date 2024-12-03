package controller;

import entidades.Gasto;
import entidades.Pessoa;
import sistema.DespesaDoMes;
import sistema.SistemaFinanceiro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddGastosController implements ActionListener {
    private SistemaFinanceiro sistema;
    private JFrame janelaPrincipal;
    private final String[] mesesOpt = new String[]{"1","2","3","4","5","6","7","8","9","10","11","12"};
    private final String[] umDoisOpt = new String[]{"1", "2"};
    private final String[] despesasOpt = new String[]{"Adicionar outra despesa", "Finalizar"};

    public AddGastosController(SistemaFinanceiro sistema, JFrame janela){
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }
    @Override
    public void actionPerformed(ActionEvent e){
        boolean sair = false;
        int mes = JOptionPane.showOptionDialog(janelaPrincipal,"Selecione o mês:","Cadastro de gastos",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,null, mesesOpt,null);

        //pessoas
        //int recebedorId = JOptionPane.showOptionDialog(janelaPrincipal,"Selecione o recebedor:","Cadastro de gastos",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, sistema.opcoesNome(), null);
        //String cpfRecebe = JOptionPane.showInputDialog(janelaPrincipal,"CPF do recebedor(Apenas números):","Cadastro de gastos",JOptionPane.INFORMATION_MESSAGE);


        Pessoa pessoaUm = sistema.pesquisaPessoaId(0);
        Pessoa pessoaDois = sistema.pesquisaPessoaId(1);

        DespesaDoMes despesaDoMes = new DespesaDoMes((mes+1));
        double subtotalPessoaUm = 0;
        double subtotalPessoaDois = 0;
        int quantDespesasPessoaUm = 0;
        int quantDespesasPessoaDois = 0;
        while(!sair){
            String identificacaoDoGasto = JOptionPane.showInputDialog(janelaPrincipal,"Identificação:","Cadastro de gastos de " + pessoaUm.getNome(),JOptionPane.INFORMATION_MESSAGE);
            double valorDoGasto = Double.parseDouble(JOptionPane.showInputDialog(janelaPrincipal,"Valor:","Cadastro de gastos de " + pessoaUm.getNome(),JOptionPane.INFORMATION_MESSAGE));
            String nomeDoResponsavel = pessoaUm.getNome();
            subtotalPessoaUm+=valorDoGasto;
            quantDespesasPessoaUm++;

            despesaDoMes.adicionarGasto(new Gasto(identificacaoDoGasto, valorDoGasto, nomeDoResponsavel));

            int opt = JOptionPane.showOptionDialog(janelaPrincipal,"Quantidade de despesas cadastradas: " + quantDespesasPessoaUm + "\nSubtotal: " + subtotalPessoaUm,"Cadastro de gastos de " + pessoaUm.getNome(), JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, despesasOpt, despesasOpt[0]);
            if(opt == 1) sair = true;


        }
        sair = false;
        while(!sair){
            String identificacaoDoGasto = JOptionPane.showInputDialog(janelaPrincipal,"Identificação:","Cadastro de gastos de " + pessoaDois.getNome(),JOptionPane.INFORMATION_MESSAGE);
            double valorDoGasto = Double.parseDouble(JOptionPane.showInputDialog(janelaPrincipal,"Valor:","Cadastro de gastos de " + pessoaDois.getNome(),JOptionPane.INFORMATION_MESSAGE));
            String nomeDoResponsavel = pessoaDois.getNome();
            subtotalPessoaDois += valorDoGasto;
            quantDespesasPessoaDois++;

            despesaDoMes.adicionarGasto(new Gasto(identificacaoDoGasto, valorDoGasto, nomeDoResponsavel));

            int opt = JOptionPane.showOptionDialog(janelaPrincipal,"Quantidade de despesas cadastradas: " + quantDespesasPessoaDois + "\nSubtotal: " + subtotalPessoaDois,"Cadastro de gastos de " + pessoaDois.getNome(), JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, despesasOpt,despesasOpt[0]);
            if(opt == 1) sair = true;


        }
        if(subtotalPessoaUm > subtotalPessoaDois){
            despesaDoMes.setPaganteERecebedor(pessoaDois.getNome(), pessoaUm.getNome());
        }else{
            despesaDoMes.setPaganteERecebedor(pessoaUm.getNome(), pessoaDois.getNome());
        }

        sistema.cadastrarDespesasDoMes(despesaDoMes);
        JOptionPane.showMessageDialog(janelaPrincipal,sistema.calcularPagamento(despesaDoMes),"Valor do pagamento", JOptionPane.INFORMATION_MESSAGE);




    }
}
