import java.util.ArrayList;
import java.util.List;

public class Day046 {

  public static void main(String[] args) {
        List<String> atribuindo = new ArrayList<>();
        List<String> aparelho = new ArrayList<>();
        
        GerenciarTrafego gt1 = new GerenciarTrafego(atribuindo, aparelho);

        gt1.adicionarAparelho("Router", "Alice");
        gt1.adicionarAparelho("Switch", "Bob");

        gt1.listarAparelhos();

        gt1.GaratirEntrege("Router", "Alice");
    }
    public static class GerenciarTrafego{

        List<String> atribuindo;
        List<String> aparelho;

        public GerenciarTrafego(List<String> atribuindo, List<String> aparelho) {
            this.atribuindo = atribuindo;
            this.aparelho = aparelho;
        }

        public void listarAparelhos() {
            for (int i = 0; i < atribuindo.size(); i++) {
                System.out.println("Aparelho: " + aparelho.get(i) + ", Atribuido para: " + atribuindo.get(i));
            }
        }

        public void adicionarAparelho(String aparelho, String atribuido) {
            this.atribuindo.add(atribuido);
            this.aparelho.add(aparelho);
            System.out.println("Aparelho " + aparelho + " adicionado com sucesso!");
        }

        public void GaratirEntrege(String aparelho, String atribuido){
            System.out.println("Aparelho " + aparelho + " atribuindo prioridades aos pacotes e garantindo a entrega correta!");

        }

    }
    
}