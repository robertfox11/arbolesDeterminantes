package org.actividad2viu;

import java.util.ArrayList;

public class DeterminanteProfe {
    public static int determinante(int matriz[][]) {

        if(matriz.length == 0) {

            return 1;

        }

        int dimension = matriz.length - 1;

        int fila = 0;

        ArrayList<Integer> columnasEliminadas = new ArrayList<>();

        return determinanteRecursivo(matriz, dimension, columnasEliminadas, fila);

    }

    public static int determinanteRecursivo(int matriz[][], int dimension, ArrayList<Integer> columnasEliminadas, int fila) {

        int determinante = 0;

        int signo = 2;

        for(int columna = 0; columna <= dimension; columna++) {

            if(columnasEliminadas.contains(columna)) {

                continue;

            }

            if(dimension == fila) {

                return matriz[fila][columna];

            }

            columnasEliminadas.add(columna);

            determinante += (int) (Math.pow(-1,signo)*matriz[fila][columna]*determinanteRecursivo(matriz, dimension, columnasEliminadas, fila + 1));

            // se elimina la columna agregada pues pasamos a

            // eliminar la siguiente columna y dejar como

            // no eliminada a columna

            // Note que hago cast a Integer para que lo convierta

            // en objeto y elimine el objeto columna del

            // arrayList, NO el elemento en la posiciÃ³n columna

            // una sutileza del metodo remove de ArrayList

            columnasEliminadas.remove((Integer) columna);

            signo++;

        }

        return determinante;

    }
}
