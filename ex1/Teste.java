package ex1;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class Teste {
    
    public static void main(String[] args) {
        List<Produto> produtos = new ArrayList<>();

        // Código para criar produtos com categorias
        produtos.add(new Produto("mouse", 100.0, "Eletronicos"));
        produtos.add(new Produto("pc", 2000.0, "Eletronicos"));
        produtos.add(new Produto("teclado", 300.0, "Eletronicos"));
        
        produtos.add(new Produto("livro1", 40.0, "Livros"));
        produtos.add(new Produto("livro2", 501.0, "Livros"));
        produtos.add(new Produto("livro3", 600.0, "Livros"));
        
        produtos.add(new Produto("calça", 700.0, "Roupas"));
        produtos.add(new Produto("camisa", 800.0, "Roupas"));
        produtos.add(new Produto("sapato", 9000.0, "Roupas"));
        

        System.out.println("Exercicio A) ");
        for (Produto produto : produtos) {
            if(produto.getCategoria().equals("Eletronicos")) {
                System.out.println(produto.getNome());
            }
        }
        
        System.out.println("\n ");
        System.out.println(produtos.stream().filter(produto -> produto.getCategoria().equals("Eletronicos")).collect(Collectors.toList()));
       

        System.out.println("\n ");
        System.out.println("Exercicio B) ");
        System.out.println(produtos.stream().map(produto -> produto.getPreco()).filter(preco -> preco > 500).collect(Collectors.toList()));

        System.out.println("\n ");
        System.out.println("Exercicio C) ");
        System.out.println(produtos.stream().filter(produto -> produto.getCategoria().equals("Livros")).mapToDouble(produto -> produto.getPreco()).sum());

        System.out.println("\n ");
        System.out.println("Exercicio D e E) ");
        buscarProdutoPorNome(produtos, "pc").ifPresent(produto -> System.out.println( produto.getNome() + " - R$" + produto.getPreco() + " - " + produto.getCategoria()));

        System.out.println("\n ");
        
        //sem try catch o código acabaria aqui
        try {
            buscarProdutoPorNome(produtos, "televisao").orElseThrow(() -> new RuntimeException("Produto nao encontrado!"));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("\n ");
        System.out.println("Exercicio F) ");
        List<String> nomes = produtos.stream().map(p -> p.getNome()).collect(Collectors.toList());
        System.out.println(nomes);

        List<String> nomes2 = produtos.stream().map(Produto::getNome).collect(Collectors.toList());
        System.out.println(nomes2);
        
        
    }

    public static Optional<Produto> buscarProdutoPorNome(List<Produto> produtos, String nome) {
         return produtos.stream().filter(produto -> produto.getNome().equals(nome)).findFirst();
    }
    
}
