import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TesteSistema {
    @Test
    public void testaSistema(){
        String[] mesesOpt = new String[]{"1","2","3","4","5","6","7","8","9","10","11","12"};
        String[] umDoisOpt = new String[]{"1", "2"};

        int mes = JOptionPane.showOptionDialog(null,"Selecione o mês:","Cadastro de gastos",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,null, mesesOpt,null);
        System.out.println(mes);
        String cpfPaga = JOptionPane.showInputDialog(null,"CPF do pagante:","Cadastro de gastos",JOptionPane.INFORMATION_MESSAGE);
        System.out.println(cpfPaga);
        int opt = JOptionPane.showOptionDialog(null,"1 - Adicionar outra despesa \n2 - Finalizar e cadastrar despesas do recebedor","Cadastro de gastos do pagante", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, umDoisOpt,null);
        System.out.println(opt);




    }
}
