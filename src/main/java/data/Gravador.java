package data;

import sistema.SistemaFinanceiro;

import java.io.*;

public class Gravador {

    public Gravador() {
    }

    public boolean exportarDados(String path, SistemaFinanceiro sistema) throws IOException {
        try(FileOutputStream fos = new FileOutputStream(path + "\\dados_contabilidade.data");
        ObjectOutputStream oos = new ObjectOutputStream(fos)){

        oos.writeObject(sistema);
        return true;
        }

    }
    public SistemaFinanceiro importarDados(String path, SistemaFinanceiro sistema) throws IOException, ClassNotFoundException {
        try(FileInputStream fis = new FileInputStream(path); ObjectInputStream ois = new ObjectInputStream(fis)){
            SistemaFinanceiro novoSistema = (SistemaFinanceiro) ois.readObject();

            return novoSistema;
        }
    }


    }



