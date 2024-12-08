package data;

import sistema.SistemaFinanceiro;
import java.time.LocalDateTime;
import java.io.*;
import java.time.format.DateTimeFormatter;


public class Gravador {
    private final static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd_MM_yyyy__HH_mm");
    private static String programDataPath = System.getenv("ProgramData");
    private static File diretorioArquivo = new File(programDataPath, "Calculadora de Despesas");
    private static File arquivoPath = new File(diretorioArquivo.getAbsolutePath() + "\\dados_contabilidade.data");


    public static void autoSalva(SistemaFinanceiro sistema) throws IOException{
        if (!(diretorioArquivo.exists())) {
            diretorioArquivo.mkdir();
        }

        try (FileOutputStream fos = new FileOutputStream(arquivoPath);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(sistema);


        }
    }

    public static boolean autoRecupera(SistemaFinanceiro sistema) throws IOException, ClassNotFoundException {
        if (!(diretorioArquivo.exists()) || !(arquivoPath.exists())) {
            return false;
        }
        try (FileInputStream fis = new FileInputStream(arquivoPath); ObjectInputStream ois = new ObjectInputStream(fis)) {
            SistemaFinanceiro novoSistema = (SistemaFinanceiro) ois.readObject();
            sistema.importar(novoSistema.getDespesaDoMes(), novoSistema.getPessoas());

            return true;
        }



    }


    public static boolean exportarDados(String path, SistemaFinanceiro sistema) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(path + "\\dados_contabilidade_" + getDataFormatada() + ".data");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
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
















