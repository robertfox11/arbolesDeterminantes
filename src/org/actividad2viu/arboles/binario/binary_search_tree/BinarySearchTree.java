package org.actividad2viu.arboles.binario.binary_search_tree;//package clase8;

import java.util.*;
import java.io.*;

class OrderPersonByName implements Comparator<Person>
{
    public int compare( Person p1, Person p2 ){   // un comparador por nombre
        return p1.getName().compareTo(p2.getName());
    }
}


class Person implements Comparable<Person>
{
    public Person( String dni, String n, int ag, String p )
    {
        this.dni = dni; name = n; age = ag;  phone = p;
    }

    public String toString( )
    {
        return getDni( ) + " " +getName( ) + " " + getAge( ) + " " + getPhoneNumber( );
    }

    public int compareTo( Person rhs ) // comparar por DNI
    {
        return dni.compareTo(rhs.dni);
    }

    public final String getDni( )
    {
        return dni;
    }

    public final String getName( )
    {
        return name;
    }

    public final int getAge( )
    {
        return age;
    }

    public final String getPhoneNumber( )
    {
        return phone;
    }

    public final void setPhoneNumber( String newPhone )
    {
        phone = newPhone;
    }

    private String dni;
    private String name;
    private int age;
    private String phone;

}

class Student extends Person
{
    public Student( String dni, String n, int ag, String p, double promedio )
    {
        super( dni, n, ag,  p );
        this.promedio = promedio;
    }

    public String toString( )
    {
        return super.toString( ) + " Promedio= " + getPromedio();
    }

    public double getPromedio( )
    {
        return promedio;
    }

    private double promedio;
}

class Employee extends Person
{
    public Employee( String dni, String n, int ag,  String p, double salario )
    {
        super( dni, n, ag,  p );
        this.salario = salario;
    }

    public String toString( )
    {
        return super.toString( ) + " $" + getSalario( );
    }

    public double getSalario( )
    {
        return salario;
    }

    public void raise( double percentRaise )
    {
        salario *= ( 1 + percentRaise );
    }

    private double salario;
}
//Clase BinarySearchTree
//
//
//******************METODOS PUBLICOS*********************
//void insert( x )       --> Inserta x
//void remove( x )       --> Elimina x
//void removeMin( )      --> Elimina el objeto con menor valor (clave)
//Comparable find( x )   --> Devuelve el objeto del arbol igual a x
//Comparable findMin( )  --> devuelve el objeto menor
//Comparable findMax( )  --> devuelve el objeto mayor
//boolean isEmpty( )     --> devuelve TRUE sii el arbol es vacio
//void makeEmpty( )      --> elimina todos los nodos del arbol

/**
 * Implementa Arbol Binario de Búsqueda
 * Como comparador por default es compareTo
 * Pero podemos pasarle un Comparator al momento
 * de crear el arbol
 *
 */
public class BinarySearchTree<AnyType extends
        Comparable<? super AnyType>>
{
    private BinaryNode<AnyType> root;
    private Comparator<? super AnyType> cmp; // para poder
    // otra forma de comparar claves
    // que no sea la dada por el
    // metodo compareTo de la interfaz
    // Comparable

    public BinarySearchTree( ){
        // llamar al siguiente constructor
        // (el siguiente) con comparador null
        this( null );
    }

    public BinarySearchTree( Comparator<? super AnyType> c ){
        // en este constructor podemos pasar un Comparador (Comparator)
        root = null; cmp = c;
    }

    private int myCompare( AnyType lhs, AnyType rhs )
    // Siempre que comparemos elementos utilizamos este
    // metodo de comparacion de elementos. Si existe
    // un Comparator se usa este para comparar, si no
    // se usa compareTo de la interfaz Comparable
    // de esta forma podemos comparar por nombre, DNI, etc
    // el default es DNI que es por donde se compara
    // en el metodo compareTo de la interfaz Comparable
            //un numero menor que cero si lhs es menor que rhs
            // un numero igual a cero si lhs   es igual que rhs
            //un numero mayor que cero si lhs es mayor que rhs
    {
        if( cmp != null )
            return cmp.compare( lhs, rhs ); //compara
        else
            return lhs.compareTo( rhs );
    }


    /**
     * Insertar (o agregar) el objeto x al arbol
     * @param x el elemento a insertar.
     */
    public void insert( AnyType x )
    {  // metodo DRIVER que llama a uno recurviso privado
        root = insert( x, root );
    }

    /**
     * Eliminar un objeto del arbol..
     * @param x el objeto a eliminar
     */
    public void remove( AnyType x )
    {   // metodo DRIVER que llama al recursivo privado
        root = remove( x, root );
    }

    /**
     * Eliminar el menor elemento
     */
    public void removeMin( )
    {
        root = removeMin( root );
    }

    /**
     * Encontrar el menor elemento
     * @return devuelve el menor elemento o null si esta vacio.
     */
    public AnyType findMin( )
    {
        return elementAt( findMin( root ) );
    }

    /**
     * Encontrar el mayor elemento del arbol
     * @return devuelve el mayor elemento o null si es vacio.
     */
    public AnyType findMax( )
    {
        return elementAt( findMax( root ) );
    }

    /**
     * Buscar un elemento en el arbol.
     * @param x es el elemento a buscar.
     * @return devuelve el elemento o null si no existe.
     */
    public AnyType find( AnyType x )
    {
        return elementAt( find( x, root ) );
    }

    /**
     * convertir el arbol en vacio
     */
    public void makeEmpty( )
    {
        root = null;
    }

    /**
     * Preguntar si el arbol es vacio
     * @return devuelve TRUE sii es vacio.
     */
    public boolean isEmpty( )
    {
        return root == null;
    }

    /**
     * Metodo interno para obtener el elemento en un nodo.
     * @param t es el ndo.
     * @return devuelve el elemento o null si el nodo es null.
     */
    private AnyType elementAt( BinaryNode<AnyType> t )
    {
        return t == null ? null : t.element;
    }

    /**
     * Internal method to insert into a subtree.
     * @param x the item to insert.
     * @param t the node that roots the tree.
     * @return the new root.
     * //@throws DuplicateItemException if x is already present.
     */
    protected BinaryNode<AnyType> insert( AnyType x, BinaryNode<AnyType> t ) {
        int valor;
        if( t == null )
            t = new BinaryNode<AnyType>( x );
        else if ( (valor = myCompare(x, t.element)) < 0 )
            t.left = insert( x, t.left );
        else if ( valor > 0 )
            t.right = insert( x, t.right );
        else; // no inserta nada porque el elemento ya existe;
        // se ha podido quetar este else pero lo dejo para indicar que en ese punto
        // consigue que el elemento ya esta en el arbol
        return t;
    }

    /**
     * Internal method to remove from a subtree.
     * @param x the item to remove.
     * @param t the node that roots the tree.
     * @return the new root.
     * //@throws ItemNotFoundException if x is not found.
     */
    protected BinaryNode<AnyType> remove( AnyType x,
                                          BinaryNode<AnyType> t )
    {
        if( t == null );
        // no haga nada porque el elemento no existe;
        if( myCompare(x, t.element ) < 0 )
            t.left = remove( x, t.left );
        else if( myCompare(x, t.element ) > 0 )
            t.right = remove( x, t.right );
        else if( t.left != null && t.right != null ) // Two children
        {
            t.element = findMin( t.right ).element;
            t.right = removeMin( t.right );
        }
        else
            t = ( t.left != null ) ? t.left : t.right;
        return t;
    }

    /**
     * Internal method to remove minimum item from a subtree.
     * @param t the node that roots the tree.
     * @return the new root.
     * //@throws ItemNotFoundException if t is empty.
     */
    protected BinaryNode<AnyType> removeMin( BinaryNode<AnyType> t )
    {
        if( t == null ) return t;
            // no haga nada porque el elemento no existe;
        else if( t.left != null )
        {
            t.left = removeMin( t.left );
            return t;
        }
        else
            return t.right;
    }

    /**
     * Internal method to find the smallest item in a subtree.
     * @param t the node that roots the tree.
     * @return node containing the smallest item.
     */
    protected BinaryNode<AnyType> findMin( BinaryNode<AnyType> t )
    {
        if( t != null )
            while( t.left != null )
                t = t.left;

        return t;
    }

    /**
     * Internal method to find the largest item in a subtree.
     * @param t the node that roots the tree.
     * @return node containing the largest item.
     */
    private BinaryNode<AnyType> findMax( BinaryNode<AnyType> t )
    {
        if( t != null )
            while( t.right != null )
                t = t.right;

        return t;
    }

    /**
     * Internal method to find an item in a subtree.
     * @param x is item to search for.
     * @param t the node that roots the tree.
     * @return node containing the matched item.
     */
    private BinaryNode<AnyType> find( AnyType x, BinaryNode<AnyType> t )
    {
        while( t != null )
        {
            if( myCompare(x, t.element ) < 0 )
                t = t.left;
            else if( myCompare(x, t.element ) > 0 )
                t = t.right;
            else
                return t;    // Match
        }

        return null;         // Not found
    }

    // La clase BinaryNode para crear nodos
    // Note que por no er ni publica ni privada
    // solo es accesible en el paquete

    static class BinaryNode<AnyType>
    {

        private AnyType             element;
        private BinaryNode<AnyType> left;
        private BinaryNode<AnyType> right;

        public BinaryNode( )
        {
            this( null, null, null );
        }

        public BinaryNode(AnyType x )
        {
            this( x, null, null );
        }

        public BinaryNode( AnyType theElement, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt )
        {
            element = theElement;
            left    = lt;
            right   = rt;
        }


        public AnyType getElement( )
        {
            return element;
        }

        public BinaryNode<AnyType> getLeft( )
        {
            return left;
        }

        public BinaryNode<AnyType> getRight( )
        {
            return right;
        }

        public void setElement( AnyType x )
        {
            element = x;
        }

        public void setLeft( BinaryNode<AnyType> t )
        {
            left = t;
        }

        public void setRight( BinaryNode<AnyType> t )
        {
            right = t;
        }

    }

    private BinaryNode<AnyType> getRoot(){
        // obtener la referencia al nodo raíz
        return root;
    }

    // Estos métodos deben estar en la clase BinaryTree
    // si la Clase BinaryNode es interna a BinaryTree y privada
    // porque hacen uso de metodos y campos de la clase BinaryNode

    // Determina el nivel de un elemento
    public int nivel(AnyType elem){

        return  nivel(getRoot(), elem, 0);
    }

    private int nivel(BinaryNode<AnyType> nodo, AnyType elem, int res){

        if (nodo== null)
            return -1; // no encontrado

        AnyType r = nodo.getElement();

        int valor = myCompare(elem,r);

        if (valor == 0) return res;

        if (valor<0) return nivel(nodo.getLeft(),elem,1+res);

        else {  return nivel(nodo.getRight(),elem,1+res); }

    }
    // Imprimir el arbol en Pre Orden.
    public void printPreOrder( )
    {
        if (root != null) printPreOrderR(root);
    }
    private static <Otro> void printPreOrderR(BinaryNode<Otro> nod )
    {
        System.out.println( nod.getElement() );       // Node
        if( nod.getLeft() != null )
            printPreOrderR( nod.getLeft() );          // Left
        if( nod.getRight() != null )
            printPreOrderR( nod.getRight() );         // Right
    }

    // Imprimir el arbol en In Orden (la impresion sera
    // la lista de los elementos del arbol ordenados
    // en orden creciente)
    public void printInOrder( )
    {
        if (root != null) printInOrderR(root);
    }
    private static <Otro> void printInOrderR(BinaryNode<Otro> nod )
    {
        if( nod.getLeft() != null )
            printInOrderR( nod.getLeft() );          // Left
        System.out.println( nod.getElement() );       // Node
        if( nod.getRight() != null )
            printInOrderR( nod.getRight() );         // Right
    }

    public boolean test_AVL() {
        // permite probar si un arbol binario de busqueda es AVL
        // es decir, los subarboles izquierdo y derecho son
        // AVL y la diferencia de las alturas de los
        // subarboles izq y der es a lo sumo 1
        // Los arboles null y con un solo nodo son AVL

        element_AVL elem = test_AVL(root);
        return elem.test;
    }
    class element_AVL{
        boolean test;
        int altura;
    }
    private element_AVL test_AVL(BinaryNode<AnyType> n) {
        // este algoritmo devuelve un objeto tipo element_AVL
        // que consiste de dos campos: test y altura
        // el algoritmo determina si el �rbol cuya ra�z es n cumple con que
        // para cada nodo las alturas de sus subárboles derecho e izquierdo
        // difieren en a lo sumo 1. De ser este verdad, se devuelve el
        // objeto elemnt_AVL con valor (true, altura del árbol)
        // de ser falso se devuelve (false, xxx) xxx representa un valor que
        // no necesariamente es la altura del árbol cuya raíz es n
        // El algoritmo es recursivo y muy sencillo:
        // - determina si el subárbol izquierdo cumple con la propiedad:
        //		para cada nodo las alturas de sus subárboles derecho e izquierdo
        // 		difieren en a lo sumo 1
        // - determina si el subárbol derecho cumple con la propiedad:
        //		para cada nodo las alturas de sus subárboles derecho e izquierdo
        // 		difieren en a lo sumo 1
        // - de ser cierto que los subárboles izquierdo y derecho de n cumplen
        //	la propiedad, entonces
        //		- si las alturas de los subárboles difieren en menos de 2 se devuelve
        //			(verdad, altura del árbol cuya raíz es n)
        //		- si las alturas de los subárboles difieren en al menos 2 se devuelve
        //			(false, altura del árbol cuya raíz es n)
        //	Nota: la altura del árbol cuya raíz es n es:
        //			1+ max(altura izquierdo, altura derecho)


        element_AVL elem = new element_AVL();
        element_AVL elem1 = new element_AVL();
        element_AVL elem2 = new element_AVL();
        if (n==null) { elem.test=true; elem.altura=-1;}
        else {
            elem1 = test_AVL(n.getLeft());
            // el siguiente if permite que sea mas eficiente el proceso
            // pues una vez que uno de los subárboles no cumpla
            // con la diferencia de alturas menor o igual que  1 para cada uno de sus
            // nodos, entonces no vale la pena continuar, sino que se
            // devuelve que el árbol cuya raíz es n tampoco cumple con
            // diferencia de alturas menor o igual que 1  para cada nodo
            // y ya no importa calcular su altura
            if (elem1.test==false) return elem1;

            elem2 = test_AVL(n.getRight());
            // el siguiente if permite que sea mas eficiente el proceso
            // pues una vez que uno de los subárboles no cumpla
            // con la diferencia de alturas menor o igual que  1 para cada uno de sus
            // nodos, entonces no vale la pena continuar, sino que se
            // devuelve que el árbol cuya raíz es n tampoco cumple con
            // diferencia de alturas menor o igual que 1  para cada nodo
            // y ya no importa calcular su altura
            if (elem2.test==false) return elem2;
            elem.test = ( Math.abs(elem1.altura-elem2.altura)<=1  );
            elem.altura = 1 + Math.max(elem1.altura,elem2.altura);
        }
        return elem;
    }

    // Programa de prueba
    // Lee un archivo "archivo.txt" con información de
    // estudiantes y empleados. Los guarda en un BinarySearchTree
    // de acuerdo a la clave que queramos (name o DNI)
    // Y luego los imprime utilizand un recorrido en In-Orden
    // El formato del archivo es como sigue (un ejemplo):
    //	S           para indicar que es un estudiante
    //	12345679
    //	martha pérez
    //	34
    //	58-4126785453
    //	9.5
    //	E
    //	12345661
    //	carlos pérez
    //	33
    //	34-678445533
    //	2000.34
    //	E
    //	12345662
    //	pedro pérez
    //	33
    //	34-678445533
    //	2000.34
    //	S

    public static void main( String [ ] args ) throws IOException
    {
        BinarySearchTree<Person> t = new BinarySearchTree<Person>
                ( new OrderPersonByName() );
        // ordena por nombre usa el COMPARATOR OrderPersonByName
        // aunque nombre no es una buena clave porque puede ver nombre repetitivo y es la clave para insertar elementos
        String rutaArchivo = "/home/reyfox11-spark/Documentos/JavaIntellijCurso/matricesBidimensionales/src/org/actividad2viu/arboles/binario/archivo.txt";
        // Crear un objeto File con la ruta del archivo
        File archivo = new File(rutaArchivo);
        if (archivo.exists()) {
            System.out.println("El archivo existe en la ruta especificada.");
        }
        Scanner in = new Scanner(new FileReader
                (rutaArchivo));//leemos el archivo
        String line = new String();
        String tipo = new String();
        String dni = new String();
        String nombre = new String();
        Integer edad ;
        String telf = new String();
        Double calif_o_salario ;

        //Leer archivo e ir guardando a los estudiantes
        // y empleados en el �rbol

        while (in.hasNextLine()) {
            line = in.nextLine();
            tipo = line.split(" ")[0];
            if (tipo.equals("S")) {
                line = in.nextLine();
                dni = line.split(" ")[0];
                nombre = in.nextLine();
                line = in.nextLine();
                edad = Integer.parseInt(line.split(" ")[0]);
                line = in.nextLine();
                telf = line.split(" ")[0];
                line = in.nextLine();
                calif_o_salario = Double.parseDouble(line.split(" ")[0]);
                Student est = new Student(dni,nombre,edad,telf,calif_o_salario);
                t.insert(est);
            }
            if (tipo.equals("E")) {
                line = in.nextLine();
                dni = line.split(" ")[0];
                nombre = in.nextLine();
                line = in.nextLine();
                edad = Integer.parseInt(line.split(" ")[0]);
                line = in.nextLine();
                telf = line.split(" ")[0];
                line = in.nextLine();
                calif_o_salario = Double.parseDouble(line.split(" ")[0]);
                Employee emp = new Employee(dni,nombre,edad,telf,calif_o_salario);
                t.insert(emp);
            }
        }
        System.out.println( "Ordenados por nombre: " );
        t.printInOrder();

        in.close();
        System.out.println("************************Otra parte***********");
        BinarySearchTree<Person> t1 = new BinarySearchTree<Person>(  );//Creamos un nuevo arbol, le passamos un comparetor
        // ordena por DNI
        in = new Scanner(new FileReader
                (rutaArchivo));

        while (in.hasNextLine()) {
            line = in.nextLine();
            tipo = line.split(" ")[0];
            if (tipo.equals("S")) {
                line = in.nextLine();
                dni = line.split(" ")[0];
                nombre = in.nextLine();
                line = in.nextLine();
                edad = Integer.parseInt(line.split(" ")[0]);
                line = in.nextLine();
                telf = line.split(" ")[0];
                line = in.nextLine();
                calif_o_salario = Double.parseDouble(line.split(" ")[0]);
                Student est = new Student(dni,nombre,edad,telf,calif_o_salario);
                t1.insert(est);
            }
            if (tipo.equals("E")) {
                line = in.nextLine();
                dni = line.split(" ")[0];
                nombre = in.nextLine();
                line = in.nextLine();
                edad = Integer.parseInt(line.split(" ")[0]);
                line = in.nextLine();
                telf = line.split(" ")[0];
                line = in.nextLine();
                calif_o_salario = Double.parseDouble(line.split(" ")[0]);
                Employee emp = new Employee(dni,nombre,edad,telf,calif_o_salario);
                t1.insert(emp);
            }
        }
        System.out.println( "Ordenados por DNI: " );
        t1.printInOrder();


     /*
     t.insert(22);
     t.insert(18);
     t.insert(16);
     t.insert(14);
     t.insert(12);
     t.insert(17);
     t.insert(20);
     t.insert(19);
     t.insert(26);
     t.insert(24);
     t.insert(23);
     t.insert(28);
     //Listar en preorder
     t.printPreOrder();
     int nivel = t.nivel(14);
     System.out.println( "nivel = " + nivel);

     System.out.println( "es avl? = " + t.test_AVL());


	 final int NUMS = 4000;
     final int GAP  =   37;
     System.out.println( "Checking... (no more output means success)" );

     for( int i = GAP; i != 0; i = ( i + GAP ) % NUMS )
         t.insert( i );

     for( int i = 1; i < NUMS; i += 2 )
         t.remove( i );

     if( t.findMin( ) != 2 || t.findMax( ) != NUMS - 2 )
         System.out.println( "FindMin or FindMax error!" );

     for( int i = 2; i < NUMS; i += 2 )
          if( t.find( i ) != i )
              System.out.println( "Find error1!" );

     for( int i = 1; i < NUMS; i += 2 )
         if( t.find( i ) != null )
             System.out.println( "Find error2!" );
*/
    }
}