package org.actividad2viu.actividad3;


import java.util.Arrays;

interface Pila2<AnyType>
{
    void         empilar( AnyType x );
    boolean      desempilar( );
    AnyType      tope( );     // devolver el tope de la pila
    boolean      estaVacia( );
    void         convertirVacia( );
    int          numElem( );
    String       toString();
}


public class PilaConCola2<AnyType> implements Pila2<AnyType> {
    private static final int TAMANIO_INICIAL = 10;
    private AnyType[] arreglo;
    private int tamanio;

    public PilaConCola2() {
        arreglo = (AnyType[]) new Object[TAMANIO_INICIAL];
        tamanio = 0;
    }
    @Override
    public void empilar(AnyType x) {
        if (tamanio == arreglo.length) {
            aumentarCapacidad();
        }
        arreglo[tamanio++] = x;
    }

    @Override
    public boolean desempilar() {
        if (!estaVacia()) {
            arreglo[--tamanio] = null; // Elimina la referencia al elemento desapilado
            return true;
        }
        return false;
    }

    @Override
    public AnyType tope() {
        if (!estaVacia()) {
            return arreglo[tamanio - 1];
        }
        return null;
    }

    @Override
    public boolean estaVacia() {
        return tamanio == 0;
    }

    @Override
    public void convertirVacia() {
        arreglo = (AnyType[]) new Object[TAMANIO_INICIAL];
        tamanio = 0;
    }

    @Override
    public int numElem() {
        return tamanio;
    }

    // Método privado para aumentar la capacidad del arreglo dinámicamente
    private void aumentarCapacidad() {
        int nuevoTamanio = arreglo.length * 2;
        arreglo = Arrays.copyOf(arreglo, nuevoTamanio);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < tamanio; i++) {
            sb.append(arreglo[i]);
            if (i != tamanio - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        PilaConCola2<Integer> pila = new PilaConCola2<>();

        pila.empilar(5);
        pila.empilar(10);
        pila.empilar(15);
        System.out.println("Elementos en la pila: " + pila); // Debe imprimir: Elementos en la pila: [5, 10]

        System.out.println("Tope de la pila: " + pila.tope()); // Debe imprimir: Tope de la pila: 15

        pila.desempilar();

        System.out.println("Tope de la pila después de desempilar: " + pila.tope()); // Debe imprimir: Tope de la pila después de desempilar: 10

        System.out.println("Número de elementos en la pila: " + pila.numElem()); // Debe imprimir: Número de elementos en la pila: 2

            System.out.println("Elementos en la pila: " + pila); // Debe imprimir: Elementos en la pila: [5, 10]
    }
}
