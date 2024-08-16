import java.util.ArrayList;
import java.util.List;

public class Day095 {

    static class GerenciarParque{

        List<Integer> ingressos;
        List<String> atracoes;
        List<Integer> capacidades;

        public GerenciarParque() {
            ingressos = new ArrayList<>();
            atracoes = new ArrayList<>();
            capacidades = new ArrayList<>();
        }

        public void adicionarAtracao(String atracao, Integer capacidade) {
            ingressos.add(0);
            atracoes.add(atracao);
            capacidades.add(capacidade);
        }

        public void vendasIngresos(int ingresso,String shows){
            ingressos.set(ingresso, ingressos.get(ingresso) + 1);
            System.out.println("Vendido um ingresso para o show: " + shows);
        }
        
        public void controleCapacidades(int count){
            for(int i = 0; i < capacidades.size(); i++){
                if(ingressos.get(i) >= capacidades.get(i)){
                    System.out.println("Capacidade da atração " + atracoes.get(i) + " excedida");
                }
            }

        }
    }

   
}
