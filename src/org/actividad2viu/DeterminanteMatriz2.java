package org.actividad2viu;

import java.util.Scanner;

public class DeterminanteMatriz2 {

    public static int determinante (int [][] matriz){

        int n = matriz.length;
        if (n != matriz[0].length) {
            throw new IllegalArgumentException("La matriz no es cuadrada");
        }
        if (n == 1) {
            return matriz[0][0];
        }

        return calcularDeterminanteRecursivo(matriz);
    }
    private static void sumarMultiploDeFila(int matriz[][], int fila1, int fila2, int escalar) {
        for (int j = 0; j < matriz.length; j++) {
            matriz[fila2][j] += escalar * matriz[fila1][j];
        }
    }
    public static int cofactor(int[][] matriz, int fila, int columna) {
        int n = matriz.length;
        int[][] submatriz = new int[n-1][n-1];
        int submatrizFila = 0, submatrizColumna;

        for (int i = 0; i < 3; i++) {
            if (i != fila) {
                submatrizColumna = 0;
                for (int j = 0; j < 3; j++) {
                    if (j != columna) {
                        submatriz[submatrizFila][submatrizColumna] = matriz[i][j];
                        submatrizColumna++;
                    }
                }
                submatrizFila++;
            }
        }

        return (int) (Math.pow(-1 , fila + columna) * determinante(submatriz));
    }

    public static int calcularDeterminanteRecursivo(int[][] matriz) {
        int n = matriz.length;
        int determinante = 0;
        if (n == 1) {
            return matriz[0][0];
        }
        System.out.println("calculamos la matriz");
        for (int i = 0; i < matriz.length; i++) {
            int[][] minor = new int[n - 1][n - 1];
            for (int j = 1; j < n; j++) {
                int k = 0;
                for (int l = 0; l < n; l++) {
                    if (l != i) {
                        System.out.println("|"+j  +" + "+ l);
                        minor[j - 1][k++] = matriz[j][l];

                    }
                }
            }
            System.out.println("eliminamos la columan esta columana es con la que multiplicamos "+matriz[0][i]);
            System.out.println(matriz[0][i] );
            determinante += (int) (matriz[0][i] * calcularDeterminanteRecursivo(minor) * Math.pow(-1, i));
        }

        return determinante;
    }

    public static void main(String[] args) {
        // Obtener la instancia de Runtime
        Runtime runtime = Runtime.getRuntime();

        // Mostrar la cantidad total de memoria disponible
        long totalMemory = runtime.totalMemory();
        System.out.println("Total Memory: " + totalMemory);

        //Formar la matriz
//        System.out.println("Forme la matriz");
//        Scanner sc1 = new Scanner(System.in);
//        int n = sc1.nextInt();
//        int[][] matriz= new int[n][n];


        //Ingresar datos de un funcion 2*2

//        System.out.println("Ingresa los valores para la matriz  => "+ n + " * " + n );
//
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
        int[][] matriz = {{0,0}, {0,0}};
//        int[][] matriz = {{0,0,3}, {0,1,0}, {1,0,0}};
//      int[][] matriz = {{4,-1}, {-2,7}};
//      int[][] matriz = {{2,-1,3}, {1,-6,2}, {2,1,-2}};
//        int[][] matriz = {{2,-1,3,1}, {1,0,2,3}, {2,1,-2,6}, {0,1,0,3}};

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("el valor para la posición [" + i + "][" + j + "]: ");
                System.out.print("|"+matriz[i][j]+"\t");
            }
            System.out.println();
        }
        int deter = DeterminanteMatriz2.determinante(matriz);
        System.out.println("determinante" + deter);
        // Mostrar la cantidad de memoria libre
        long freeMemory = runtime.freeMemory();
        System.out.println("Free Memory: " + freeMemory);
        // Mostrar la cantidad de memoria utilizada
        long usedMemory = totalMemory - freeMemory;
        System.out.println("Used Memory: " + usedMemory);
    }
}
