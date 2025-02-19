package dao;

import model.Livro;

import java.io.*;
import java.util.*;

public class LivroDAO {
    private static final String FILE_NAME = "livros.txt";
    private static List<Livro> livros = new ArrayList<>();
    
    public static void carregarLivros() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                livros.add(Livro.fromString(linha));
            }
        } catch (IOException e) {
            livros = new ArrayList<>();
        }
    }

    public static void adicionarLivro(Livro livro) {
        livros.add(livro);
        salvarLivros();
    }

    public static void removerLivro(String titulo) {
        livros.removeIf(l -> l.getTitulo().equalsIgnoreCase(titulo));
        salvarLivros();
    }
    
    public static List<Livro> listarLivros() {
        List<Livro> lista = new ArrayList<>();

    	 try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
             String linha;
             while ((linha = br.readLine()) != null) {
            	 lista.add(Livro.fromString(linha));
             }
         } catch (IOException e) {
        	 lista = new ArrayList<>();
         }
        return lista;
    }

    private static void salvarLivros() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Livro livro : livros) {
                bw.write(livro.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
