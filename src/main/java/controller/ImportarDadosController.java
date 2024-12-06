package controller;

import data.Gravador;
import sistema.SistemaFinanceiro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ImportarDadosController implements ActionListener {
    private SistemaFinanceiro sistema;
    private JFrame janelaPrincipal;
    public ImportarDadosController(SistemaFinanceiro sistema, JFrame janelaPrincipal){
        this.sistema = sistema;
        this.janelaPrincipal = janelaPrincipal;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        try{
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int retorno = fileChooser.showDialog(janelaPrincipal, "Abrir");
            if(retorno == JFileChooser.APPROVE_OPTION){
                String path = fileChooser.getSelectedFile().getAbsolutePath();
                if(Gravador.importarDados(path, sistema)){
                    JOptionPane.showMessageDialog(janelaPrincipal, "Dados importados com sucesso!", "Importar dados",JOptionPane.PLAIN_MESSAGE);
                }




            }

        }catch(IOException exc){
            JOptionPane.showMessageDialog(janelaPrincipal, "Caminho inválido", "ERRO", JOptionPane.ERROR_MESSAGE);

        }catch(ClassNotFoundException exc){
            JOptionPane.showMessageDialog(janelaPrincipal, "Arquivo inválido", "ERRO", JOptionPane.ERROR_MESSAGE);

        }

    }
    }



