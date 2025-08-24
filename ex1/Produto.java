package ex1;

public class Produto {
    
    private String nome;
    private double preco;
    private String categoria;

    public Produto(String nome, double preco, String categoria) {
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
    }

    public String getNome() {
        return this.nome;
    }

    public double getPreco() {
        return this.preco;
    }

    public String getCategoria() {
        return this.categoria;
    }

    

    @Override
    public String toString() {
        return getNome();
    }
}
