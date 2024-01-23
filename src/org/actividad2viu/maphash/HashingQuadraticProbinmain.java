package org.actividad2viu.maphash;

public class HashingQuadraticProbinmain {
    // Simple main
    public static void main( String [ ] args )
    {
        QuadraticProbingHashTable<String> H =
                new QuadraticProbingHashTable<>( );

        long startTime = System.currentTimeMillis( );

        final int NUMS = 2000000;
        final int GAP  =   37;

        System.out.println( "Verificando... (si no hay output significa exito)" );


        for( int i = GAP; i != 0; i = ( i + GAP ) % NUMS )
            H.insert( ""+i );
        for( int i = GAP; i != 0; i = ( i + GAP ) % NUMS )
            if( H.insert( ""+i ) )
                System.out.println( "Error!! No se puede insertar" +
                        " un elemento que ya existe " + i );
        for( int i = 1; i < NUMS; i+= 2 )
            H.remove( ""+i );

        for( int i = 2; i < NUMS; i+=2 )
            if( !H.contains( ""+i ) )
                System.out.println( "Fallo contains pues los pares estan "
                        + i );

        for( int i = 1; i < NUMS; i+=2 )
        {
            if( H.contains( ""+i ) )
                System.out.println( "Fallo contains pues los impares no estan "
                        +  i  );
        }

        long endTime = System.currentTimeMillis( );

        System.out.println( "Tiempo transcurrido: " + (endTime - startTime) );
    }
}
