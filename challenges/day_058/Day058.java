import java.util.*;

public class Day058 {


    public static void main(String[] args) {
        Restaurante r1 = new Restaurante();
        r1.adicionarPedido("Hamburguer", 1, "João");
    }


 static   class Restaurante {
        List<String> pedido;
        List<Integer> mesas;
        List<String> funcionario;
    
        public Restaurante() {
            pedido = new ArrayList<>();
            mesas = new ArrayList<>();
            funcionario = new ArrayList<>();
        }
    
        public void listarPedido(){
            for(int i = 0; i < pedido.size(); i++){
                System.out.println("Pedido: " + pedido.get(i) + ", Mesa: " + mesas.get(i) + ", Funcionario: " + funcionario.get(i));
            }
        }

        public void adicionarPedido(String nome, int numeroMesa, String nomeFuncionario){
            pedido.add(nome);
            mesas.add(numeroMesa);
            funcionario.add(nomeFuncionario);

            System.out.println("Pedido adicionado: " + nome + ", Mesa: " + numeroMesa + ", Funcionario: " + nomeFuncionario);
        }

        public void mesasDisponiveis(){
            Set<Integer> mesasSet = new HashSet<>(mesas);
            System.out.println("Mesas Disponiveis: " + mesasSet);
        }




    }

}