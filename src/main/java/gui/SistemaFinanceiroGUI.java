package gui;

import controller.*;
import data.Gravador;
import sistema.SistemaFinanceiro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SistemaFinanceiroGUI extends JFrame {
    //ImageIcon addGastos = new ImageIcon("./imgs/icons/addIcon.png");
    ImageIcon contabilidade = new ImageIcon("./imgs/icons/contabilidade128.png");
    SistemaFinanceiro sistema = new SistemaFinanceiro(true);
    JMenuBar barraDeMenu = new JMenuBar();
    JLabel linha1, linha2, linha3;
    public SistemaFinanceiroGUI() {
        setTitle("Controle de despesas");
        setSize(600, 400); //tamanho da janela
        setLocation(150, 150);
        setResizable(false);
        setBackground(Color.white);
        setIconImage(contabilidade.getImage());
        /*linha1 = new JLabel("Titulo", JLabel.CENTER);
        linha1.setForeground(Color.black);
        linha1.setFont(new Font("Arial", Font.BOLD, 50));
        */
        linha2 = new JLabel(null,contabilidade, JLabel.CENTER);
        linha3 = new JLabel("Esquerda", JLabel.LEFT);
        setLayout(new GridLayout(2, 1));
        //add(linha1);
        add(linha2);
        //add(linha3);
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

        //Salvar dados ao fechar a janela
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                salvarDados();
                dispose();
                System.exit(0);
            }
        });


    }
    private void salvarDados(){
        try{
            Gravador.autoSalva(sistema);
        }catch(Exception e){
            System.out.println("Erro ao salvar dados");
        }
    }


    public static void main(String[] args) {

        JFrame janela = new SistemaFinanceiroGUI();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

}
