package org.actividad2viu.separatechaininghashable;

import java.util.LinkedList;
import java.util.List;

public class SeparateChainingHashTable<AnyType> {
    private static final int DEFAULT_TABLE_SIZE = 101;

    /** The array of Lists. */
    private List<AnyType>[ ] theLists; //la interface List de java.util
    private int currentSize;

    /** The array of Lists. */
    // private List<AnyType> [ ] theLists = new List[10];
    // private List aa = new List();   no se puede instanciar el
    // tipo List porque es una interface pero si un arreglo de
    // tipo List
    // List<AnyType> aa;   si se puede y luego se le inserta
    // un objeto que herede de List

    /**
     * Construct the hash table.
     */
    public SeparateChainingHashTable( )
    {
        this( DEFAULT_TABLE_SIZE );
    }

    /**
     * Construct the hash table.
     * @param size approximate table size.
     */
    public SeparateChainingHashTable( int size )
    {
        theLists = new LinkedList[ nextPrime( size ) ];
        for( int i = 0; i < theLists.length; i++ )
            theLists[ i ] = new LinkedList<AnyType>( );
    }

    /**
     * Insert into the hash table. If the item is
     * already present, then do nothing.
     * @param x the item to insert.
     */
    public void insert( AnyType x )
    {
        List<AnyType> whichList = theLists[ myhash( x ) ];
        if( !whichList.contains( x ) )
        {
            whichList.add( x );

            // Rehash; see Section 5.5
            if( ++currentSize > theLists.length )
                rehash( );
        }
    }

    /**
     * Remove from the hash table.
     * @param x the item to remove.
     */
    public void remove( AnyType x )
    {
        List<AnyType> whichList = theLists[ myhash( x ) ];
        if( whichList.contains( x ) )
        {
            whichList.remove( x );
            currentSize--;
        }
    }

    /**
     * Find an item in the hash table.
     * @param x the item to search for.
     * @return true if x isnot found.
     */
    public boolean contains( AnyType x )
    {
        List<AnyType> whichList = theLists[ myhash( x ) ];
        return whichList.contains( x );
    }

    /**
     * Make the hash table logically empty.
     */
    public void makeEmpty( )
    {
        for( int i = 0; i < theLists.length; i++ )
            theLists[ i ].clear( );
        currentSize = 0;
    }
//
//    /**
//     * A hash routine for String objects.
//     * @param key the String to hash.
//     * @param tableSize the size of the hash table.
//     * @return the hash value.
//     */
//    public static int hash( String key, int tableSize )
//    {
//        int hashVal = 0;
//
//        for( int i = 0; i < key.length( ); i++ )
//            hashVal = 37 * hashVal + key.charAt( i );
//
//        hashVal %= tableSize;
//        if( hashVal < 0 )
//            hashVal += tableSize;
//
//        return hashVal;
//    }

    private void rehash( )
    {
        List<AnyType> [ ]  oldLists = theLists;

        // Create new double-sized, empty table
        theLists = new List[ nextPrime( 2 * theLists.length ) ];
        for( int j = 0; j < theLists.length; j++ )
            theLists[ j ] = new LinkedList<>( );

        // Copy table over
        currentSize = 0;
        for( List<AnyType> list : oldLists )
            for( AnyType item : list )
                insert( item );
    }

    private int myhash( AnyType x )
    {
        int hashVal = x.hashCode( );  // funciona x.hashCode( )
        // porque Object tiene
        // el método hashCode
        // pero AnyType deberia tener
        // tanto equals como hashCode

        hashVal %= theLists.length;
        if( hashVal < 0 )
            hashVal += theLists.length;

        return hashVal;
    }



    /**
     * Internal method to find a prime number at least as large as n.
     * @param n the starting number (must be positive).
     * @return a prime number larger than or equal to n.
     */
    private static int nextPrime( int n )
    {
        if( n % 2 == 0 )
            n++;

        for( ; !isPrime( n ); n += 2 )
            ;

        return n;
    }

    /**
     * Internal method to test if a number is prime.
     * Not an efficient algorithm.
     * @param n the number to test.
     * @return the result of the test.
     */
    private static boolean isPrime( int n )
    {
        if( n == 2 || n == 3 )
            return true;

        if( n == 1 || n % 2 == 0 )
            return false;

        for( int i = 3; i * i <= n; i += 2 )
            if( n % i == 0 ) // si i es impar , n es impar y
                // i*i < n < (i+1)*(i+1) y n no es primto
                // entonces n = i*k, para algun entero k
                return false;

        return true;
    }


    // Simple main
    public static void main( String [ ] args )
    {

        // PRUEBA DEL HASHTABLE (SeparateChainingHashTable)

        SeparateChainingHashTable<Integer> H
                = new SeparateChainingHashTable<>( );

        long startTime = System.currentTimeMillis( );

        final int NUMS = 2000000;
        final int GAP  =   37;
        System.out.println( "Verificando... " +
                "(si no hay output significa exito)" );

        for( int i = GAP; i != 0; i = ( i + GAP ) % NUMS ) {

            H.insert( i ); // inserta 37 , 37+37, etc. i=0 después
            // de 2000000 iteraciones
            //System.out.print(i+" ");
        }

        for( int i = 1; i < NUMS; i+= 2 )
            H.remove( i );

        for( int i = 2; i < NUMS; i+=2 )
            if( !H.contains( i ) )
                System.out.println( "Fallo: los pares estan " + i );

        for( int i = 1; i < NUMS; i+=2 )
        {
            if( H.contains( i ) )
                System.out.println( "Fallo: los impares no estan " +  i  );
        }

        long endTime = System.currentTimeMillis( );

        System.out.println( "Tiempo transcurrido: " +
                (endTime - startTime) );

        // El siguiente código es válido, da overflow el cálculo pero
        // funciona y corre
//          String key = "asdamdasdklkerlwemflwkeflweflwefwellwefelfkjdskjdjkasd dasd as d as d a s sadsadsada ";
//          int hashVal = 0;
//          for( int i = 0; i < key.length( ); i++ ) {
//              hashVal = 37 * hashVal + key.charAt( i );
//              System.out.print(hashVal+" ");
//          }
//          System.out.println("\n"+(37*187759310 + key.charAt( 5 )));
//          System.out.println("\n"+ hashVal + " " + " " +
//                     Integer.MIN_VALUE+ " "+ (Integer.MIN_VALUE-10));
//          hashVal %= 10;
//          System.out.println( hashVal );
//          if( hashVal < 0 )
//              hashVal += 10;
        //
//          System.out.println( hashVal );

    }

}
