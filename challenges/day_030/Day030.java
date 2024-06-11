import java.util.ArrayList;
import java.util.Collections;

public class Day030 {

    public static void main(String[] args) {
        Day030 day030 = new Day030();
        day030.grafo(2, 6, 23, 30);
    }
    
    
    public void grafo(int numero, int numero2, int numero3, int numero4){
        ArrayList<Integer> ordem = new ArrayList<Integer>();

        ordem.add(numero);
        ordem.add(numero2);
        ordem.add(numero3);
        ordem.add(numero4);
        ordem.add(24);
        ordem.add(221);
        ordem.add(1);
        ordem.add(9);
        ordem.add(23);
        ordem.add(45);

        Collections.sort(ordem);


       System.out.println(ordem);
        
    } 
}


