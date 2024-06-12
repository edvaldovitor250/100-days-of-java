
public class Day031 {

    public static void main(String[] args) {
        Day031 day031 = new Day031();

        day031.CalcularSen(5, 13);
    }

    public void CalcularSen(float catetoOposto, float catetoAdjacente){
        try {
            float somaDosValores = catetoOposto / catetoAdjacente;

            System.out.println("Esse é o valor do Sen " + somaDosValores); 
            
        } catch (Exception e) {
            System.out.println(e);
        }
        finally{
            System.out.println("A execução do projeto foi concluída.");
        }

    }
    
    
    
}


