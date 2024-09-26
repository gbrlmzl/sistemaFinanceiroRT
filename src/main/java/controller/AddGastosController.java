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

    public AddGastosController(SistemaFinanceiro sistema, JFrame janela){
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }
    @Override
    public void actionPerformed(ActionEvent e){
        boolean sair = false;
        int mes = JOptionPane.showOptionDialog(janelaPrincipal,"Selecione o mês:","Cadastro de gastos",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,null, mesesOpt,null);
        DespesaDoMes despesaDoMes = new DespesaDoMes((mes+1));

        //pessoas
        Integer cpfPaga = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal,"CPF do pagante(Apenas números):","Cadastro de gastos",JOptionPane.INFORMATION_MESSAGE));
        Integer cpfRecebe = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal,"CPF do recebedor(Apenas números):","Cadastro de gastos",JOptionPane.INFORMATION_MESSAGE));
        Pessoa pagante = sistema.pesquisaPessoaCpf(cpfPaga);
        Pessoa recebedor = sistema.pesquisaPessoaCpf(cpfRecebe);
        while(!sair){
            String identificacaoDoGasto = JOptionPane.showInputDialog(janelaPrincipal,"Identificação:","Cadastro de gastos do pagante",JOptionPane.INFORMATION_MESSAGE);
            double valorDoGasto = Double.parseDouble(JOptionPane.showInputDialog(janelaPrincipal,"Valor:","Cadastro de gastos do pagante",JOptionPane.INFORMATION_MESSAGE));
            String nomeDoResponsavel = pagante.getNome();

            despesaDoMes.adicionarGasto(new Gasto(identificacaoDoGasto, valorDoGasto, nomeDoResponsavel));

            int opt = JOptionPane.showOptionDialog(janelaPrincipal,"1 - Adicionar outra despesa \n2 - Finalizar e cadastrar despesas do recebedor","Cadastro de gastos do pagante", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, umDoisOpt,null);
            if(opt == 1) sair = true;


        }
        sair = false;
        while(!sair){
            String identificacaoDoGasto = JOptionPane.showInputDialog(janelaPrincipal,"Identificação:","Cadastro de gastos do recebedor",JOptionPane.INFORMATION_MESSAGE);
            double valorDoGasto = Double.parseDouble(JOptionPane.showInputDialog(janelaPrincipal,"Valor:","Cadastro de gastos do recebedor",JOptionPane.INFORMATION_MESSAGE));
            String nomeDoResponsavel = recebedor.getNome();

            despesaDoMes.adicionarGasto(new Gasto(identificacaoDoGasto, valorDoGasto, nomeDoResponsavel));

            int opt = JOptionPane.showOptionDialog(janelaPrincipal,"1 - Adicionar outra despesa \n2 - Finalizar","Cadastro de gastos do recebedor", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, umDoisOpt,null);
            if(opt == 1) sair = true;


        }

        sistema.cadastrarDespesasDoMes(despesaDoMes);
        JOptionPane.showMessageDialog(janelaPrincipal,sistema.calcularPagamento(despesaDoMes,sistema.pesquisaPessoaCpf(cpfPaga),sistema.pesquisaPessoaCpf(cpfRecebe)),"Valor do pagamento", JOptionPane.INFORMATION_MESSAGE);




    }
}
