# Day 24

## Desafio:

	Implemente um programa Java que realize a busca binária em um array ordenado.

**Resultado:**

```java

public class Day024 {

public static int binarySearch(int[] array, int target) {
  int left = 0;
  int right = array.length - 1;

  while (left <= right) {
      int mid = left + (right - left) / 2;

      if (array[mid] == target) {
          return mid;
      }

      if (array[mid] < target) {
          left = mid + 1;
      } 
      else {
          right = mid - 1;
      }
  }

  return -1;
}

public static void main(String[] args) {
  int[] sortedArray = {2, 3, 4, 10, 40};
  int target = 10;

  int result = binarySearch(sortedArray, target);
  if (result == -1) {
      System.out.println("Elemento não encontrado no array.");
  } else {
      System.out.println("Elemento encontrado no índice: " + result);
  }
}
}