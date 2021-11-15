package thalita;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.Collections;

public class Principal {

    public static void main(String[] args) {

        Path caminho = Paths.get("funcionarios.csv"); // caminho do arquivo

        Map<String,String> funcionarios1 = new HashMap<>(); // guarda o identidicador e o numero de filhos
        Map<String,String> funcionarios2 = new HashMap<>(); // guarda o identidicador e o salario

        ArrayList<Funcionario> funcionarios = new ArrayList<>(); // Funcionarios que possuem filhos
        Arquivo arquivo = new Arquivo();                         // novo arquivo que será gerado

        try {
            List<String> conteudo = Files.readAllLines(caminho); // Lê cada linha do arquivo para uma List<String>
            conteudo.forEach((linha) ->
            {
                // vai quebrar a linha quando encontrar uma virgula
                String[] quebra = linha.split(",");
                funcionarios1.put(quebra[0], quebra[3]);
                funcionarios2.put(quebra[0], quebra[4]);
            });

            // remove o cabeçalho para realizar a conversao dos valores
            funcionarios1.remove("Identificador","Filhos");
            funcionarios2.remove("Identificador","Salario");

            funcionarios1.forEach((identificador, numeroFilhos) ->
            {
                if (Integer.parseInt(numeroFilhos) > 0)
                {
                    Funcionario funcionario1 = new Funcionario();
                    funcionario1.setIdentificador(Integer.parseInt(identificador));
                    funcionario1.setNumeroFilhos(Integer.parseInt(numeroFilhos));
                    funcionarios2.forEach((identificador1, salario) ->
                    {
                        if (identificador.equals(identificador1))
                            funcionario1.setSalario(Float.parseFloat(salario));
                    });
                    funcionarios.add(funcionario1);
                }
            });

            // ordena os funcionarios pelo identificador
            Collections.sort(funcionarios);

            // passa os dados no arquivo filtrado
            for (Funcionario funcionario2 : funcionarios) {
                arquivo.escrever(funcionario2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}