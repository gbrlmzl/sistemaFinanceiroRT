package data;

import sistema.SistemaFinanceiro;
import java.time.LocalDateTime;
import java.io.*;
import java.time.format.DateTimeFormatter;


public class Gravador {
    private final static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd_MM_yyyy__HH_mm");

    /*public Gravador() {
    }*/

    public static boolean exportarDados(String path, SistemaFinanceiro sistema) throws IOException {
        try(FileOutputStream fos = new FileOutputStream(path + "\\dados_contabilidade_" + getDataFormatada() + ".data");
            ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(sistema);

            return true;

        }




    }

    public static boolean importarDados(String path, SistemaFinanceiro sistema) throws IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream(path); ObjectInputStream ois = new ObjectInputStream(fis)) {
            SistemaFinanceiro novoSistema = (SistemaFinanceiro) ois.readObject();
            sistema.importar(novoSistema.getDespesaDoMes(), novoSistema.getPessoas());

            return true;
        }
    }


    private static String getDataFormatada() {
        return LocalDateTime.now().format(dateFormatter);
    }

}







