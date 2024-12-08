package controller;

import exceptions.DadosNaoCadastradosException;
import sistema.SistemaFinanceiro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.EventListener;

public class BaixarListaController implements ActionListener {
    private SistemaFinanceiro sistema;
    private JFrame janelaPrincipal;
    private final String[] mesesOpt = new String[]{"1","2","3","4","5","6","7","8","9","10","11","12"};

    public BaixarListaController(SistemaFinanceiro sistema, JFrame janelaPrincipal) {
        this.sistema = sistema;
        this.janelaPrincipal = janelaPrincipal;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        int mes = JOptionPane.showOptionDialog(janelaPrincipal,"Selecione o mês:","Baixar lista de despesas",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,null, mesesOpt,null);
        if(mes < 0){
            return;
        }
        if(sistema.despesasJaCadastradas(mes)){
            try{
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int retorno = fileChooser.showDialog(janelaPrincipal, "Salvar");
                if(retorno == JFileChooser.APPROVE_OPTION){
                    String path = fileChooser.getSelectedFile().getAbsolutePath() + "\\Despesas_Mes_" + (mes+1) + ".txt";
                    if(sistema.baixarListaDespesas(mes, path)){
                        JOptionPane.showMessageDialog(janelaPrincipal, "Lista salva com sucesso!", "Baixar lista de despesas",JOptionPane.PLAIN_MESSAGE);
                    }
                }

            }catch(IOException exc){
                JOptionPane.showMessageDialog(janelaPrincipal, "Erro ao salvar lista.", "ERRO", JOptionPane.ERROR_MESSAGE);

                }
            }
        else{
            JOptionPane.showMessageDialog(janelaPrincipal, "Não há despesas cadastradas nesse mês!", "Erro", JOptionPane.ERROR_MESSAGE);
        }

            }

    }



