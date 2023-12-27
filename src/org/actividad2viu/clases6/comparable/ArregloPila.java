package org.actividad2viu.clases6.comparable;

import java.util.ArrayList;

interface Pila<AnyType>
{
    void         empilar( AnyType x );
    boolean      desempilar( );
    AnyType      tope( );     // devolver el tope de la pila
    boolean      estaVacia( );
    void         convertirVacia( );
    int          numElem( );
    String       toString();
}

public class ArregloPila<AnyType> implements Pila<AnyType>
{   private AnyType [ ] pila;  // tambien hemos podido usar ArrayList
    private int   topePila;  // posición del último elemento del arreglo
    private static final int CAPACIDAD_INICIAL = 10;

    public ArregloPila( )
    {  pila = (AnyType []) new Object[ CAPACIDAD_INICIAL ];
        topePila = -1;   // Stack vac�o
    }
    public boolean estaVacia( )
    {  return topePila == -1;   }

    public AnyType tope( )   // devuelve el tope de la pila
    {  if( !estaVacia( ) )
        return pila[topePila]; // lo ideal sería clonar el objeto
    else return null;
    }

    public void empilar( AnyType x )
    {   if( topePila + 1 == pila.length)
        duplicarArreglo( ); //Si est� lleno duplicarlo
        pila[ ++topePila] = x;    //agrega al final de la pila
    }
    private void duplicarArreglo( )
    {
        AnyType [ ] nuevo;
        nuevo = (AnyType []) new Object[ pila.length * 2 ];
        for( int i = 0; i < pila.length; i++ )
            nuevo[ i ] = pila[ i ];
        pila = nuevo;
    }
    public boolean desempilar( )  //devuelve verdad sii pudo desempilar
    {
        if( estaVacia( ) ) return false;
        topePila--;
        return true;
    }
    public void convertirVacia() {
        // Se crea un nuevo arreglo para que tenga tantos elementos
        // como indica CAPACIDAD_INICIAL
        pila = (AnyType []) new Object[ CAPACIDAD_INICIAL ];

        topePila = -1;   // Stack vac�o
    }
    public int numElem() {
        return topePila+1;
    }
    public String toString(){
        // guardamos la pila en un arreglo donde
        // la posicion cero es el tope
        ArrayList<AnyType> arreglo = new ArrayList<>();
        if (!estaVacia())
            for (int i = topePila; i>=0; i--) {
                arreglo.add(pila[i]);
            }
        return arreglo.toString();
    }

    public static void main(String args[]) {
        ArregloPila<Integer> pila = new ArregloPila<>();
        pila.empilar(1);
        pila.empilar(2);
        pila.empilar(3);
        System.out.println(" La pila es: "+pila+
                " donde el tope es el primer elemento = "+pila.tope());
    }
}

