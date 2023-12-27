package org.actividad2viu;

import java.util.Scanner;

public class Prueba_Determinante {
    public static int determinante (int [][] matriz){

        int n = matriz.length;
        if (n != matriz[0].length) {
            throw new IllegalArgumentException("La matriz no es cuadrada");
        }
        if (n == 1) {
            return matriz[0][0];
        }
        // Llama al método recursivo para calcular el determinante
        return calcularDeterminanteRecursivo(matriz, n);
    }

    // Método recursivo para calcular el determinante utilizando menores complementarios
    public static int calcularDeterminanteRecursivo(int[][] matriz, int n) {
        //obtenemos la logintud de la matriz
//        int n = matriz.length;
        int determinante = 0;
        if (n == 1) {
            return matriz[0][0];
        }
        for (int i = 0; i < matriz.length; i++) {
            int[][] minor = new int[n - 1][n - 1];

            // Calcular menores complementarios recursivamente
            for (int j = 1; j < n; j++) {
                int k = 0;
                for (int l = 0; l < n; l++) {
                    if (l != i) {
                        minor[j - 1][k++] = matriz[j][l];
//                        matriz[j - 1][k++] = matriz[j][l];

                    }
                }
            }
            // Fórmula para calcular el determinante por menores complementarios
            determinante += (int) (matriz[0][i] * calcularDeterminanteRecursivo(minor, n-1) * Math.pow(-1, i));
        }

        return determinante;
    }

    public static void main(String[] args) {
        // Solicitar al usuario las dimensiones de la matriz
        System.out.println("coloque la dimension de la matriz.");
//        Scanner sc1 = new Scanner(System.in);
//        int n = sc1.nextInt();
//        int[][] matriz= new int[n][n];

//        int[][] matriz = {{0,0}, {0,0}}; //ejemplo de su ejercicio
        int[][] matriz = {{0,0,3}, {0,1,0}, {1,0,0}};

        // Ingreso de valores para la matriz
//        System.out.println("Ingresa los valores para la matriz  => "+ n + " * " + n );
//        for (int i = 0; i < matriz.length; i++) {
//            for (int j = 0; j < matriz.length; j++) {
//                System.out.print("Ingrese el valor para la posición [" + i + "][" + j + "]: ");
//                matriz[i][j] = sc1.nextInt();
//            }
//        }
//
//        //Mostramos el dato en forma de una matriz
//        for (int i = 0; i < matriz.length; i++) {
//            for (int j = 0; j < matriz[i].length; j++) {
//                System.out.print(matriz[i][j]+"\t");
//            }
//            System.out.println();
//        }


        // Mostrar la matriz ingresada
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("el valor para la posición [" + i + "][" + j + "]: ");
                System.out.print("|"+matriz[i][j]+"\t");
            }
            System.out.println();
        }
        // Calcular y mostrar el determinante de la matriz
        int deter = determinante(matriz);
        System.out.println("determinante" + deter);
    }
}
