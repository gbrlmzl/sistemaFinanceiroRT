package controller;

import entidades.*;
import exceptions.PessoaJaCadastradaException;
import sistema.SistemaFinanceiro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPessoaController implements ActionListener {
    private SistemaFinanceiro sistema;
    private JFrame janelaPrincipal;
    //private final ImageIcon addIcon = new ImageIcon("./imgs/icons/addIcon.png");
    private String[] umDoisOpt = new String[]{"1", "2"};


    public AddPessoaController(SistemaFinanceiro sistema, JFrame janela){
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nomeDaPessoa = JOptionPane.showInputDialog(janelaPrincipal, "Nome:","Cadastro de pessoas", JOptionPane.INFORMATION_MESSAGE);
        Integer cpfPessoa = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal, "CPF:", JOptionPane.INFORMATION_MESSAGE));
        int funcaoOpt = JOptionPane.showOptionDialog(janelaPrincipal,"1 - Pagante \n2 - Recebedor","Função da Pessoa", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, umDoisOpt,null);

        Pessoa novaPessoa = new Pessoa(cpfPessoa, nomeDaPessoa, funcaoOpt);
        try{
            if(sistema.cadastrarPessoa(novaPessoa)){
                JOptionPane.showMessageDialog(janelaPrincipal,"Pessoa cadastrada com sucesso!","",JOptionPane.INFORMATION_MESSAGE);
            }}
        catch (PessoaJaCadastradaException exception){
            JOptionPane.showMessageDialog(janelaPrincipal,exception.getMessage(),"ERRO",JOptionPane.ERROR_MESSAGE);
        }









    }


}
