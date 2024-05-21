import java.util.Arrays;

public class Day009 {
    public static void main(String[] args) {
       
       Day009 d9 = new Day009();
       d9.ordernar(1, 0, 2);


    }

    static void ordernar(int numero,int numero2, int numero3){
        int[] dados = {numero,numero2,numero3};
        Arrays.sort(dados);
        System.out.println(Arrays.toString(dados));

    }

}
