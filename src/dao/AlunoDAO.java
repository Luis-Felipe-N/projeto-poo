package dao;

import model.Aluno;

import java.io.*;
import java.util.*;

public class AlunoDAO {
    private static final String FILE_NAME = "alunos.txt";
    private static List<Aluno> alunos = new ArrayList<>();

    public static void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
        salvarAlunos();
    }

    public static void removerAluno(String cpf) {
        alunos.removeIf(a -> a.getCpf().equals(cpf));
        salvarAlunos();
    }

    public static List<Aluno> listarAlunos() {
        return alunos;
    }

    private static void salvarAlunos() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Aluno aluno : alunos) {
                bw.write(aluno.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void carregarAlunos() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                alunos.add(Aluno.fromString(linha));
            }
        } catch (IOException e) {
            alunos = new ArrayList<>();
        }
    }
}
