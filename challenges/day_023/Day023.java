
public class Day023 {

  public static void main(String[] args) {
    GestaoClientes gestao = new GestaoClientes();
        
        gestao.adicionarCliente("Alice", 123456);
        gestao.adicionarCliente("Bob", 234567);
        
        System.out.println("Lista de Clientes:");
        gestao.listarClientes();
        
        gestao.alterarCliente("Alice", "Alice Smith", 654321);
        
        System.out.println("\nLista de Clientes Após Alteração:");
        gestao.listarClientes();

        gestao.removerCliente("Bob");
        
        System.out.println("\nLista de Clientes Após Remoção:");
        gestao.listarClientes();
  }

    
   

}