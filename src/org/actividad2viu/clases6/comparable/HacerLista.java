package org.actividad2viu.clases6.comparable;

import java.util.List;

public class HacerLista {
    public static void hacerLista(List<Integer> lst, int N ) // usamos el tipo
// genérico List<Integer> que es una interfaz de JAVA
    {
        //El algoritmo proporcionado tiene una complejidad de tiempo de O(N^2), donde N es el valor del parámetro N.
        // Esto se debe a la operación lst.add(i, 0). En una lista, agregar un elemento en una posición específica
        // puede requerir mover todos los elementos después de esa posición para hacer espacio para el nuevo elemento.
        // En cada iteración del bucle for, se agrega un elemento en la posición i, lo que puede requerir reorganizar
        // los elementos existentes en la lista para abrir espacio para el nuevo elemento. Esto se hace N veces.
        lst.clear( ); // lst la convertimos en vacía, movemos un apuntadores
        for( int i = 0; i < N; i++ )
            lst.add( i,0); // insertar i de primero en la lista (insertar)
    }
}
