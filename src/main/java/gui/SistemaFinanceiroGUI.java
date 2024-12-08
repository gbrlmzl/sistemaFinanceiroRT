package gui;

import controller.*;
import data.Gravador;
import sistema.SistemaFinanceiro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SistemaFinanceiroGUI extends JFrame {
    ImageIcon windowIcon = new ImageIcon("./imgs/icons/contabilidadeIconWindow.png");
    ImageIcon contabilidade = new ImageIcon("./imgs/icons/contabilidade128.png");
    ImageIcon buscar = new ImageIcon("./imgs/icons/lupa.png");
    ImageIcon adicionarDespesasIcon = new ImageIcon("./imgs/icons/addFileIcon.png");
    ImageIcon downloadIcon = new ImageIcon("./imgs/icons/downloadIcon.png");
    ImageIcon homeIcon = new ImageIcon("./imgs/icons/homeIcon.png");
    ImageIcon importIcon = new ImageIcon("./imgs/icons/importIcon.png");
    ImageIcon exportIcon = new ImageIcon("./imgs/icons/exportIcon.png");
    ImageIcon formatarIcon = new ImageIcon("./imgs/icons/excluirIcon.png");

    SistemaFinanceiro sistema = new SistemaFinanceiro(true);
    JMenuBar barraDeMenu = new JMenuBar();
    JLabel iconeContabilidadeJLabel;





    public SistemaFinanceiroGUI() {
        setTitle("Controle de despesas");
        setSize(600, 400); //tamanho da janela
        setLocation(150, 150);
        setResizable(false);
        setBackground(Color.white);
        setIconImage(contabilidade.getImage());

        resetarMenu();

        //JMenu
        JButton menuRetornar = new JButton(homeIcon);

        JMenu menuDespesas = new JMenu("Despesas");
        JMenuItem menuCadastrarDespesas = new JMenuItem("Cadastrar despesas", adicionarDespesasIcon);
        JMenuItem menuConsultarDespesas = new JMenuItem("Consultar despesas", buscar);
        JMenuItem menuListaDespesas = new JMenuItem("Baixar lista de despesas", downloadIcon);
        menuDespesas.add(menuConsultarDespesas);
        menuDespesas.add(menuCadastrarDespesas);
        menuDespesas.add(menuListaDespesas);


        menuRetornar.setFocusPainted(false);
        menuRetornar.setBorderPainted(false);


        JMenu menuDados = new JMenu("Sistema");
        JMenuItem menuImportarDados = new JMenuItem("Importar dados", importIcon);
        JMenuItem menuExportarDados = new JMenuItem("Exportar dados", exportIcon);

        menuDados.add(menuImportarDados);
        menuDados.add(menuExportarDados);

        JMenu menuFormatacao = new JMenu("Formatação");
        JMenuItem menuFormatar = new JMenuItem("Formatar sistema (NÃO PODE SER DESFEITO)", formatarIcon);
        menuFormatacao.add(menuFormatar);

        //Action Listener
        menuCadastrarDespesas.addActionListener(new AddGastosController(sistema, this));
        menuConsultarDespesas.addActionListener(new ConsultarGastosController(sistema, this));
        menuListaDespesas.addActionListener(new BaixarListaController(sistema, this));
        menuExportarDados.addActionListener(new ExportarDadosController(sistema, this));
        menuImportarDados.addActionListener(new ImportarDadosController(sistema, this));
        menuFormatar.addActionListener(new FormatarDadosController(sistema, this));
        menuRetornar.addActionListener(ActionListener -> {
            resetarMenu();
        });

        barraDeMenu.add(menuRetornar);
        barraDeMenu.add(menuDespesas);
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
    public void resetarMenu(){
        getContentPane().removeAll();
        iconeContabilidadeJLabel = new JLabel(null,contabilidade, JLabel.CENTER);
        add(iconeContabilidadeJLabel);
        setLayout(new GridLayout(1, 3));
        revalidate();
        repaint();
    }


    public static void main(String[] args) {

        JFrame janela = new SistemaFinanceiroGUI();


        try { //Implementa o tema do sistema na janela do programa
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

}
