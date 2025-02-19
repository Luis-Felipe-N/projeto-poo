package model;

public class Aluno extends Usuario {
    private String matricula;

    public Aluno(String nome, String cpf, String matricula) {
        super(nome, cpf);
        this.matricula = matricula;
    }

    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }

    @Override
    public void mostrarInfo() {
        System.out.println("Aluno: " + getNome() + ", Matrícula: " + matricula);
    }
    
    public static Aluno fromString(String linha) {
        String[] partes = linha.split(",");
        return new Aluno(partes[0], partes[1], partes[2]);
    }
}
