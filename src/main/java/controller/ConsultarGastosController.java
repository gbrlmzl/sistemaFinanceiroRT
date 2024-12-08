package controller;

import exceptions.DadosNaoCadastradosException;
import sistema.SistemaFinanceiro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsultarGastosController implements ActionListener {
    private SistemaFinanceiro sistema;
    private JFrame janelaPrincipal;
    private final String[] mesesOpt = new String[]{"1","2","3","4","5","6","7","8","9","10","11","12"};
    private final String[] mesesExtenso = new String[]{"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
    private final ImageIcon consultarIcon = new ImageIcon("./imgs/icons/consultarIconBig.png");

    public ConsultarGastosController(SistemaFinanceiro sistema, JFrame janelaPrincipal){
        this.sistema = sistema;
        this.janelaPrincipal = janelaPrincipal;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        int mes = JOptionPane.showOptionDialog(janelaPrincipal,"Selecione o mês:","Consultar despesas",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,consultarIcon, mesesOpt,JOptionPane.DEFAULT_OPTION);
        if(mes >= 0){
            try{
                sistema.getInfoGastos(mes); //Verifica se existem despesas cadastras no mês selecionado pelo usuário




                JTextArea gastosPagante = new JTextArea(20,30);
                JTextArea gastosRecebedor = new JTextArea(20,30);
                gastosPagante.setFont(new Font("Calibri",Font.BOLD,20));
                gastosRecebedor.setFont(new Font("Calibri",Font.BOLD,20));

                gastosRecebedor.setEditable(false);
                gastosRecebedor.setLineWrap(true);

                gastosPagante.setEditable(false);
                gastosPagante.setLineWrap(true);

                gastosPagante.setText(sistema.getInfoGastosPagante(mes));
                gastosRecebedor.setText(sistema.getInfoGastosRecebedor(mes));

                JScrollPane scrollPanePagante = new JScrollPane(gastosPagante);
                JScrollPane scrollPaneRecebedor = new JScrollPane(gastosRecebedor);

                janelaPrincipal.getContentPane().removeAll();
                janelaPrincipal.setLayout(new GridLayout(0, 2));

                janelaPrincipal.add(scrollPanePagante);
                janelaPrincipal.add(scrollPaneRecebedor);
                janelaPrincipal.revalidate();
                janelaPrincipal.repaint();




            }catch(DadosNaoCadastradosException ex){
                JOptionPane.showMessageDialog(janelaPrincipal, "Não há despesas cadastradas no mês de " + mesesExtenso[mes], "Erro", JOptionPane.ERROR_MESSAGE);
                this.actionPerformed(e);
            }

        }



    }
}
