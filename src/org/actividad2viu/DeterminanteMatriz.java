package org.actividad2viu;

import java.util.Scanner;

public class DeterminanteMatriz {
    public static int determinante(int[][] matriz) {
        int n = matriz.length;
        if (n != matriz[0].length) {
            //comproamos que la matriz no es cuadrada
            throw new IllegalArgumentException("La matriz no es cuadrada");
        }
        if (n == 1) {
            return matriz[0][0];
        } else {
            int det;
            det = cofactor(matriz, n);
            return det;
        }
    }

    public static int cofactor(int[][] matriz, int n) {
        // Initialize result
        int num1, num2, det = 1, index, total = 1;
        // matriz temporal para almacenar la fila
        int[] temp = new int[n + 1];
        // Calculamos el cofactor
        for (int i = 0; i < n; i++) {
            index = i; // initialize the index
            // encontrar el índice que tiene un valor distinto de cero
//            while (matriz[index][i] == 0 && index < n) {
//                index++;
//            }
//            if (index != i) {
//                // bucle para intercambiar la fila del elemento diagonal
//                // y fila de índice
//                for (int j = 0; j < n; j++) {
//                    intercambioFila(matriz, index, j, i, j);
//                }                // el signo determinante cambia cuando cambiamos
//                // las filas pasan por propiedades determinantes
//                det = (int)(det * Math.pow(-1, index - i));
//            }
            // almacenando los valores de los elementos de la fila diagonal
            for (int j = 0; j < n; j++) {
                temp[j] = matriz[i][j];
            }
            for (int j = i + 1; j < n; j++) {
                num1 = temp[i]; // valor del elemento diagonal
                num2 = matriz[j][i];// valor del elemento de la siguiente fila

                // atravesando cada columna de fila
                // y multiplicando por cada fila
                for (int k = 0; k < n; k++) {
                    //multiplicando para formar la diagonal
                    // elemento y elemento de la siguiente fila iguales
                    matriz[j][k] = (num1 * matriz[j][k]) - (num2 * temp[k]);
                }
                total = total * num1; // Det(kA)=kDet(A);
            }
        }

        for (int i = 0; i < n; i++) {
            det = det * matriz[i][i];
        }
        return (det / total);
    }

    static int[][] intercambioFila(int[][] arr, int i1, int j1, int i2,int j2){
        int temp = arr[i1][j1];
        arr[i1][j1] = arr[i2][j2];
        arr[i2][j2] = temp;
        return arr;
    }
    public static void main(String[] args) {
        //Formar la matriz
        System.out.println("Forme la matriz");
//        Scanner sc1 = new Scanner(System.in);
//        int n = sc1.nextInt();
//        int[][] matriz= new int[n][n];
////
////
//        //Ingresar datos de la matriz
//        System.out.println("Ingresa los valores para la matriz  => "+ n + " * " + n );
//        for (int i = 0; i < matriz.length; i++) {
//            for (int j = 0; j < matriz.length; j++) {
//                System.out.print("Ingrese el valor para la posición [" + i + "][" + j + "]: ");
//                matriz[i][j] = sc1.nextInt();
//            }
//        }

//        Pruebas de matrices
//        int[][] matriz = {{0,0}, {0,0}};
//        int[][] matriz = {{4,-1}, {3,-7}};
//        int[][] matriz = {{2,-1,3}, {1,-6,2}, {2,1,-2}};

        int[][] matriz = {{0,0}, {0,0}};
//         int[][] matriz = {{0,0,3}, {0,1,0}, {1,0,0}};
//        int[][] matriz = {{ 1, 0, 2, -1 }, { 3, 0, 0, 5 }, { 2, 1, 4, -3 }, { 1, 0, 5, 0 } };
//        int[][] matriz = {{1,0,2,-1}, {3,0,1,5}, { 2, 1, 4, -3 }, { 1, 0, 5, 0 }};
//        int[][] matriz = {{3,3,-5,2}, {1,4,-4,8}, {-1,,1,-5}, {3,-5,2,2}};
//        int[][] matriz = {{2,-1,3,1}, {1,0,2,3}, {2,1,-2,6}, {0,1,0,3}};
        //Mostramos el dato en forma de una matriz
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("el valor para la posición [" + i + "][" + j + "]: ");
                System.out.print("|"+matriz[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.printf("Determinante de la matriz es : %d", determinante(matriz));
    }
}
