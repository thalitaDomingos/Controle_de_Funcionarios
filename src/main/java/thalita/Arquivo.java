package thalita;

import java.io.*;

public class Arquivo {

    static int trava = 1;

    public void escrever (Funcionario s1) {

        OutputStream os;
        OutputStreamWriter osr;
        BufferedWriter bw = null;

        try {
            os = new FileOutputStream("func_filtrado.csv", true);
            osr = new OutputStreamWriter(os);
            bw = new BufferedWriter(osr);

            if (trava == 1) {
                bw.write("Identificador" + "," + "Filhos" + "," + "Salario" + "\n");
                trava = 0;
            }

            bw.write(s1.getIdentificador() + ",");
            bw.write(s1.getNumeroFilhos() + ",");
            bw.write(s1.getSalario() + "\n");

        } catch (Exception e) {
            System.out.println(e);

        } finally {
            try {
                assert bw != null;
                bw.close();

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}