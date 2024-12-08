package controller;

import sistema.SistemaFinanceiro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsultarGastosControllerV2 implements ActionListener {
    private SistemaFinanceiro sistema;
    private JFrame janelaPrincipal;
    private final String[] mesesOpt = new String[]{"1","2","3","4","5","6","7","8","9","10","11","12"};
    private final String[] mesesExtenso = new String[]{"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
    private final ImageIcon consultarIcon = new ImageIcon("./imgs/icons/consultarIconBig.png");

    public ConsultarGastosControllerV2(SistemaFinanceiro sistema, JFrame janelaPrincipal) {
        this.sistema = sistema;
        this.janelaPrincipal = janelaPrincipal;
    }

    public void actionPerformed(ActionEvent e) {



    }
}
