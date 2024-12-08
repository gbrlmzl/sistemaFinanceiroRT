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

    public AddPessoaController(SistemaFinanceiro sistema, JFrame janela){
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nomeDaPessoa = JOptionPane.showInputDialog(janelaPrincipal, "Nome:","Cadastro de pessoas", JOptionPane.INFORMATION_MESSAGE);
        String cpfPessoa = JOptionPane.showInputDialog(janelaPrincipal, "CPF:", "Cadastrar pessoa", JOptionPane.INFORMATION_MESSAGE);

        Pessoa novaPessoa = new Pessoa(cpfPessoa, nomeDaPessoa);
        try{
            if(sistema.cadastrarPessoa(novaPessoa)){
                JOptionPane.showMessageDialog(janelaPrincipal,"Pessoa cadastrada com sucesso!","",JOptionPane.INFORMATION_MESSAGE);
            }}
        catch (PessoaJaCadastradaException exception){
            JOptionPane.showMessageDialog(janelaPrincipal,exception.getMessage(),"ERRO",JOptionPane.ERROR_MESSAGE);
        }


    }


}
