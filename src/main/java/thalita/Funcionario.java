package thalita;

public class Funcionario implements Comparable<Funcionario> {

    private int identificador;
    private int numeroFilhos;
    private float salario;

    public int getIdentificador() { return identificador; }
    public int getNumeroFilhos()  { return numeroFilhos; }
    public float getSalario()     { return salario; }

    public void setIdentificador(int identificador) { this.identificador = identificador; }
    public void setNumeroFilhos (int numeroFilhos)  { this.numeroFilhos = numeroFilhos; }
    public void setSalario      (float salario)     { this.salario = salario; }

    @Override
    public int compareTo(Funcionario f1) {
        return Integer.compare(this.getIdentificador(), f1.getIdentificador());
    }
}