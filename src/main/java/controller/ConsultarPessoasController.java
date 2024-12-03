package controller;

import sistema.SistemaFinanceiro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsultarPessoasController implements ActionListener {
    private SistemaFinanceiro sistema;
    private JFrame janelaPrincipal;

    public ConsultarPessoasController(SistemaFinanceiro sistema, JFrame janelaPrincipal) {
        this.sistema = sistema;
        this.janelaPrincipal = janelaPrincipal;
    }

    @Override
    public void actionPerformed(ActionEvent e){




    }


}
