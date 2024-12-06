package gui;

import controller.*;
import sistema.SistemaFinanceiro;

import javax.swing.*;
import java.awt.*;

public class SistemaFinanceiroGUI extends JFrame {
    ImageIcon addGastos = new ImageIcon("./imgs/icons/addIcon.png");
    SistemaFinanceiro sistema = new SistemaFinanceiro();
    JMenuBar barraDeMenu = new JMenuBar();
    JLabel linha1, linha2;
    public SistemaFinanceiroGUI() {
        setTitle("Controle de despesas");
        setSize(800, 600); //tamanho da janela
        setLocation(150, 150);
        setResizable(false);
        setBackground(Color.white);
        linha1 = new JLabel("Teste", JLabel.CENTER);
        linha1.setForeground(Color.red);
        linha1.setFont(new Font("Serif", Font.BOLD, 24));
        linha2 = new JLabel("addGastos", JLabel.RIGHT);
        setLayout(new GridLayout(3, 1));
        add(linha1);
        add(linha2);
        add(new JLabel());

        //JMenu
        JMenu menuDespesas = new JMenu("Despesas");
        JMenuItem menuCadastrarDespesas = new JMenuItem("Cadastrar despesas");
        JMenuItem menuConsultarDespesas = new JMenuItem("Consultar despesas");
        JMenuItem menuListaDespesas = new JMenuItem("Baixar lista de despesas");
        menuDespesas.add(menuConsultarDespesas);
        menuDespesas.add(menuCadastrarDespesas);
        menuDespesas.add(menuListaDespesas);




        /*JMenu menuPessoas = new JMenu("Pessoas");
        JMenuItem menuCadastrarPessoas = new JMenuItem("Cadastrar pessoa");
        JMenuItem menuConsultarPessoas = new JMenuItem("Consultar pessoas");
        menuPessoas.add(menuCadastrarPessoas);
        menuPessoas.add(menuConsultarPessoas);
        */

        JMenu menuDados = new JMenu("Sistema");
        JMenuItem menuImportarDados = new JMenuItem("Importar dados");
        JMenuItem menuExportarDados = new JMenuItem("Exportar dados");

        menuDados.add(menuImportarDados);
        menuDados.add(menuExportarDados);

        JMenu menuFormatacao = new JMenu("Formatação");
        JMenuItem menuFormatar = new JMenuItem("Formatar sistema (NÃO PODE SER DESFEITO)");
        menuFormatacao.add(menuFormatar);




        //Action Listener

        menuCadastrarDespesas.addActionListener(new AddGastosController(sistema, this));
        //menuCadastrarPessoas.addActionListener(new AddPessoaController(sistema, this));
        menuConsultarDespesas.addActionListener(new ConsultarGastosController(sistema, this));
        menuListaDespesas.addActionListener(new BaixarListaController(sistema, this));
        menuExportarDados.addActionListener(new ExportarDadosController(sistema, this));
        menuImportarDados.addActionListener(new ImportarDadosController(sistema, this));
        menuFormatar.addActionListener(new FormatarDadosController(sistema, this));



        barraDeMenu.add(menuDespesas);
        //barraDeMenu.add(menuPessoas);
        barraDeMenu.add(menuDados);
        barraDeMenu.add(menuFormatacao);
        setJMenuBar(barraDeMenu);
    }


    public static void main(String[] args) {
        JFrame janela = new SistemaFinanceiroGUI();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
