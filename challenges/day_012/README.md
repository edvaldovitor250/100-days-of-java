# Day 12

## Desafio:

	Implemente um programa Java que calcule a média de uma lista de números.

**Resultado:**

```java


import java.util.ArrayList;
import java.util.List;

public class Day012 {


    public static void main(String[] args) {
        

        List<Integer>  media = new ArrayList<Integer>();
        media.add(2);
        media.add(10);
        media.add(4);
        media.add(9);
       
        int sum = 0;

        for(int num : media){
            sum += num;
        }

        double average = (double) sum / media.size();

        System.out.println(average);

    }
    
}

