import java.util.ArrayList;
import java.util.Scanner;

class Produto {
    String nome;
    int quantidade;
    String categoria;

    public Produto(String nome, int quantidade, String categoria) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.categoria = categoria;
    }
}

public class SistemaProdutos {
    public static void main(String[] args) {
        ArrayList<Produto> produtos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        while(true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Listar Produtos");
            System.out.println("3. Remover Produto");
            System.out.println("4. Sair");
            System.out.print("Escolha: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch(opcao) {
                case 1:
                    System.out.print("\nNome: ");
                    String nome = scanner.nextLine();
                    
                    System.out.print("Quantidade: ");
                    int quantidade = scanner.nextInt();
                    scanner.nextLine();
                    
                    System.out.print("Categoria: ");
                    String categoria = scanner.nextLine();
                    
                    produtos.add(new Produto(nome, quantidade, categoria));
                    System.out.println("Produto adicionado!");
                    break;
                    
                case 2:
                    if(produtos.isEmpty()) {
                        System.out.println("\nNenhum produto cadastrado!");
                    } else {
                        System.out.println("\nLista de Produtos:");
                        for(int i = 0; i < produtos.size(); i++) {
                            Produto p = produtos.get(i);
                            System.out.println((i+1) + ". " + p.nome + 
                                             " - Qtd: " + p.quantidade + 
                                             " - Cat: " + p.categoria);
                        }
                    }
                    break;
                    
                case 3:
                    System.out.print("\nNome do produto a remover: ");
                    String nomeRemover = scanner.nextLine();
                    
                    boolean removido = false;
                    for(int i = 0; i < produtos.size(); i++) {
                        if(produtos.get(i).nome.equalsIgnoreCase(nomeRemover)) {
                            produtos.remove(i);
                            removido = true;
                            break;
                        }
                    }
                    
                    if(removido) {
                        System.out.println("Produto removido!");
                    } else {
                        System.out.println("Produto não encontrado!");
                    }
                    break;
                    
                case 4:
                    System.out.println("Saindo do sistema...");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}