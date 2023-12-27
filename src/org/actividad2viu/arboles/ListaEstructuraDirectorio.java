package org.actividad2viu.arboles;

import java.io.File;

public class ListaEstructuraDirectorio {

    //output file name with detention
    public static void printName(String name, int depth){

        for( int i = 0; i < depth; i++ )
            System.out.print( " " );
        System.out.println( name );
    }

    // Un método manejador (“driver”) que prepara la llamada recursiva al recorrido pre-orden, para listar todo lo directorio

        public static void listAll( File dir ) {
            listAll(dir, 0); // 0 indica la profundidad (o nivel) del 		archivo o 	directorio
        }
        private static void listAll( File dir, int depth ){

        //imprimira el directorio correspondiente, dep imprime con la sangria
        printName( dir.getName( ), depth ); // visitar nodo, depth permitirá el espaciado
        // al momento de imprimir
        // si dir es un direcotorio realizamos un for de un recorrido preorden los directorio
        if ( dir.isDirectory( ) )
            for( File child : dir.listFiles( ) )
                listAll( child, depth + 1 );
    }


    //Simple main to list all files in concurrent directory
    public static void main(String[] args) {
        String dirName;
        if( args.length == 0 ) // podemos dar un directorio específico,
            // si no, toma el directorio “actual”, donde esta ubicado
            dirName = ".";
        else
            //Tomamo el directorio que esta en la linea de comando
            dirName = args[ 0 ]; //linea de comando

        File dir = new File( dirName );
        listAll( dir );
    }

}
