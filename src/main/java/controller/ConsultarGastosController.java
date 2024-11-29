package controller;

import sistema.SistemaFinanceiro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsultarGastosController implements ActionListener {
    private SistemaFinanceiro sistema;
    private JFrame janelaPrincipal;
    private final String[] mesesOpt = new String[]{"1","2","3","4","5","6","7","8","9","10","11","12"};

    public ConsultarGastosController(SistemaFinanceiro sistema, JFrame janelaPrincipal){
        this.sistema = sistema;
        this.janelaPrincipal = janelaPrincipal;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        int mes = JOptionPane.showOptionDialog(janelaPrincipal,"Selecione o mês:","Consultar despesas",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,null, mesesOpt,null);
        JOptionPane.showMessageDialog(janelaPrincipal,sistema.getInfoGastos(mes), "Despesas do mês", JOptionPane.INFORMATION_MESSAGE);

    }
}
