package controller;

import sistema.SistemaFinanceiro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormatarDadosController implements ActionListener {
    private String palavraDeConfirmacao = "Quero formatar o sistema";
    private SistemaFinanceiro sistema;
    private JFrame janelaPrincipal;
    public FormatarDadosController(SistemaFinanceiro sistema, JFrame janelaPrincipal){
        this.sistema = sistema;
        this.janelaPrincipal = janelaPrincipal;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String confirmaString = JOptionPane.showInputDialog(janelaPrincipal,"ATENÇÃO: ESSA OPERAÇÃO NÃO PODE SER DESFEITA!\nPara prosseguir com a formatação, digite:\n\"Quero formatar o sistema\"\n"
                ,"Formatação",JOptionPane.INFORMATION_MESSAGE);
        if(confirmaString == null || confirmaString.isEmpty()){
            JOptionPane.showMessageDialog(janelaPrincipal,"Operação de formatação cancelada pelo usuário", "Operação cancelada",JOptionPane.INFORMATION_MESSAGE);
            return;

        }
        if(confirmaString.equals(palavraDeConfirmacao)){
            sistema.formatarSistema(true);
            JOptionPane.showMessageDialog(janelaPrincipal,"Sistema formatado com sucesso!", "Formatação",JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(janelaPrincipal,"Operação de formatação cancelada pelo usuário", "Operação cancelada",JOptionPane.INFORMATION_MESSAGE);
        }
    }


}
