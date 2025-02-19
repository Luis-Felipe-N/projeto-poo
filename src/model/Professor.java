package model;

public class Professor extends Usuario {
    private String departamento;

    public Professor(String nome, String cpf, String departamento) {
        super(nome, cpf);
        this.departamento = departamento;
    }

    public String getDepartamento() { return departamento; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }

    @Override
    public void mostrarInfo() {
        System.out.println("Professor: " + getNome() + ", Departamento: " + departamento);
    }
}
