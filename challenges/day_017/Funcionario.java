import java.util.ArrayList;
import java.util.List;

public class Funcionario {

   private List<String> nome;
   private List<Integer> telefone;

   public Funcionario() {
      this.nome = new ArrayList<>();
      this.telefone = new ArrayList<>();
   }

   
   public void getFuncionario() {
    
    System.out.println("Nomes: " + nome);
    System.out.println("Telefones: " + telefone);
}

   public void addFuncionario(String nomeF, int telefoneF){

    nome = new ArrayList<String>();
    telefone = new ArrayList<Integer>();

    nome.add(nomeF);
    telefone.add(telefoneF);
    
    System.out.println("Novo funcioanrio foi adicionado:" + nomeF);
    System.out.println("Novo funcioanrio foi adicionado:" + telefoneF);
   }

   public void atualizar(String nomeAntigo, String nomeNovo, int telefoneNovo) {
    int index = nome.indexOf(nomeAntigo);
    if (index >= 0) {
        nome.set(index, nomeNovo);
        telefone.set(index, telefoneNovo);
        System.out.println("Funcionário foi atualizado: " + nomeNovo + ", Telefone: " + telefoneNovo);
    } else {
        System.out.println("Funcionário não encontrado: " + nomeAntigo);
    }
}

public void remover(String nomeR) {
    int index = nome.indexOf(nomeR);
    if (index >= 0) {
        nome.remove(index);
        telefone.remove(index);
        System.out.println("Funcionário foi removido: " + nomeR);
    } else {
        System.out.println("Funcionário não encontrado: " + nomeR);
    }
}
    
}



