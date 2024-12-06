package controller;

import data.Gravador;
import sistema.SistemaFinanceiro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ExportarDadosController implements ActionListener {
    private SistemaFinanceiro sistema;
    private JFrame janelaPrincipal;

    public ExportarDadosController(SistemaFinanceiro sistema, JFrame janelaPrincipal){
        this.sistema = sistema;
        this.janelaPrincipal = janelaPrincipal;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        try{
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int retorno = fileChooser.showDialog(janelaPrincipal, "Salvar");
            if(retorno == JFileChooser.APPROVE_OPTION){
                String path = fileChooser.getSelectedFile().getAbsolutePath();
                if(Gravador.exportarDados(path, sistema)){
                    JOptionPane.showMessageDialog(janelaPrincipal, "Dados salvos com sucesso!", "Exportar dados",JOptionPane.PLAIN_MESSAGE);
                }




            }

        }catch(IOException exc){
            JOptionPane.showMessageDialog(janelaPrincipal, exc.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);

        }

    }
}
