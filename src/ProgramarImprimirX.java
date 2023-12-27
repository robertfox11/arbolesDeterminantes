import java.util.Scanner;

public class ProgramarImprimirX {
    public static void main(String[] args) {
        /*Escribir un programa que imprima una X construida a base de la letra X en las diagonales de la matriz y utilizar
        el carácter guion bajo como relleno.
        El tamaño de la x se basa en una variable n que indicará el tamaño de la letra para imprimir en una matriz de n x n.
        El carácter "X" en mayúscula y el guion bajo "_" para los espacios.
        Por ejemplo para n=5 se obtiene:
        * */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el tamaño de la matriz (n x n): ");
        int n = scanner.nextInt();

        if (n == 0) {
            System.out.println("ERROR");
            System.exit(1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (i == j || (j == n - i - 1)) {
                    System.out.print("X");
                } else {
                    System.out.print("_");
                }
            }
            System.out.println();
        }
    }
}
