package model;

public class Livro {
    private String titulo;
    private String autor;
    private boolean emprestado;

    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.emprestado = false;
    }

    public String getTitulo() { 
    	return titulo; 
    	}
    
    public void setTitulo(String titulo) { 
    	this.titulo = titulo; 
    	}

    public String getAutor() { 
    	return autor; 
    	}
    
    public void setAutor(String autor) { 
    	this.autor = autor; 
    	}

    public boolean isEmprestado() { 
    	return emprestado; 
    	}
    
    public void setEmprestado(boolean emprestado) { 
    	this.emprestado = emprestado; 
    	}
    
    @Override
    public String toString() {
        return titulo + "," + autor + "," + emprestado;
    }

    public void mostrarInfo() {
        System.out.println("Livro: " + titulo + " | Autor: " + autor + " | Emprestado: " + (emprestado ? "Sim" : "Não"));
    }
    
    public static Livro fromString(String linha) {
        String[] partes = linha.split(",");
        Livro livro = new Livro(partes[0], partes[1]);
        livro.setEmprestado(Boolean.parseBoolean(partes[2]));

        return livro;
    }
}
