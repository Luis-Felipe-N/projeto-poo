package main;

import dao.LivroDAO;
import dao.AlunoDAO;
import model.Livro;
import model.Aluno;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar Livro");
            System.out.println("2 - Listar Livros");
            System.out.println("3 - Remover Livro");
            System.out.println("4 - Cadastrar Aluno");
            System.out.println("5 - Listar Alunos");
            System.out.println("6 - Remover Aluno");
            System.out.println("7 - Sair");
            int escolha = scanner.nextInt();
            scanner.nextLine(); 

            switch (escolha) {
                case 1:
                    System.out.print("Digite o título do livro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Digite o autor do livro: ");
                    String autor = scanner.nextLine();
                    
                    Livro livro = new Livro(titulo, autor);
                    LivroDAO.adicionarLivro(livro);
                    System.out.println("Livro cadastrado com sucesso!");
                    break;

                case 2:
                	System.out.println("Lista de Livros:");
                    LivroDAO.listarLivros().forEach(l -> {
                        // Formatar cada livro para exibição
                        String livroFormatado = String.format("Livro: %-30s | Autor: %-25s | Emprestado: %-5s", 
                                                             l.getTitulo(), l.getAutor(), 
                                                             (l.isEmprestado() ? "Sim" : "Não"));
                        System.out.println(livroFormatado);
                    });
                    break;
                case 3:
                    System.out.print("Digite o ISBN do livro a ser removido: ");
                    String isbnRemover = scanner.nextLine();
                    LivroDAO.removerLivro(isbnRemover);
                    System.out.println("Livro removido com sucesso!");
                    break;

                case 4:
                    System.out.print("Digite o nome do aluno: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o CPF do aluno: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Digite a matricula do aluno: ");
                    String matricula = scanner.nextLine();
                    
                    Aluno aluno = new Aluno(nome, cpf, matricula);
                    AlunoDAO.adicionarAluno(aluno);
                    System.out.println("Aluno cadastrado com sucesso!");
                    break;

                case 5:
                    System.out.println("Lista de Alunos:");
                    AlunoDAO.listarAlunos().forEach(a -> System.out.println(a));
                    break;

                case 6:
                    System.out.print("Digite o CPF do aluno a ser removido: ");
                    String cpfRemover = scanner.nextLine();
                    AlunoDAO.removerAluno(cpfRemover);
                    System.out.println("Aluno removido com sucesso!");
                    break;

                case 7:
                    System.out.println("Saindo...");
                    return;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}
