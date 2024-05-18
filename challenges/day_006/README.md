# Day 6

## Desafio:

	Implemente um programa Java para verificar se um número é um número primo.
**Resultado:**

```java

public class Day006 {
    public static void main(String[] args) {
        Day006 d1 = new Day006();
        d1.parOuImpar(2);
    }

    public void parOuImpar(int numero) {
      
        try {
            if(numero % 2 == 0){
                System.out.println("É Par");
            }
            else{
                System.out.println("É Impar");
            }
          
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao encotrar se é impar ou par: " + e.getMessage());
        } finally {
            System.out.println("A execução do projeto foi concluída.");
        }
    }
}
