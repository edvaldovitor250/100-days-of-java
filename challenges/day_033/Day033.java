public class Day033 {

    public static void quickSort(int v[], int esquerda, int direita) {
        int esq = esquerda;
        int dir = direita;
        int pivo = v[(esq + dir) / 2];
        int troca;

        while (esq <= dir) {
            while (v[esq] < pivo) {
                esq = esq + 1;
            }
            while (v[dir] > pivo) {
                dir = dir - 1;
            }
            if (esq <= dir) {
                troca = v[esq];
                v[esq] = v[dir];
                v[dir] = troca;
                esq = esq + 1;
                dir = dir - 1;
            }
        }
        if (dir > esquerda) {
            quickSort(v, esquerda, dir);
        }

        if (esq < direita) {
            quickSort(v, esq, direita);
        }
    }

    public static void main(String[] args) {
        int vetor[] = { 100, 15, 65, 65, 76, 3, 4, 6, 8, 89 };
        quickSort(vetor, 0, vetor.length - 1);

        System.out.print("Vetor ordenado: ");
        for (int i : vetor) {
            System.out.print(i + " ");
        }
    }
}
