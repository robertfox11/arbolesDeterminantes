package org.actividad2viu.clases6.comparable;

public class ListaDobEnlCent <CualquierTipo> {

	/* 
	 * La clase ListaDobEnlCent implementa una lista doblemente
	 * enlazada con centinelas cabeza y cola
	*/ 
	private Nodo<CualquierTipo>   cabeza = null; 
	// cabeza.siguiente sera una referencia al primer nodo o la cola
	private Nodo<CualquierTipo>   cola = null;  
	// cola.anterior sera una referencia al ultimo nodo o la cabeza
	private int tam ;   // es conveniente mantener el tamaño de la lista

	public ListaDobEnlCent() {   //CONSTRUCTOR lista vacía
		cabeza = new Nodo<CualquierTipo>( null, null, null );
		cola = new Nodo<CualquierTipo>( null, cabeza, null );
		cabeza.siguiente = cola;
		tam = 0;    }

	private static class Nodo<TipoElemento> { 
		// clase interna para 
		// definir nodos de tipo generico
		private TipoElemento elemento;
		private Nodo<TipoElemento> anterior;
		private Nodo<TipoElemento> siguiente;

		public Nodo(TipoElemento o, Nodo<TipoElemento> ant,
				Nodo<TipoElemento> sig) {
			// constructor de un nodo
			elemento = o;
			anterior = ant;
			siguiente = sig;
		}
		// por mantener los principios de ocultamiento y
		// encapsulamiento de datos deberiamos tener los
		// metodos para obtener y escribir sobre los campos
		// de un objeto tipo nodo....
		// no los coloco para facilitar el trabajo.....
	}

	public boolean estaVacia( ) {
		// Devuelve verdad si y solo si la lista esta vacia
		return cabeza.siguiente == cola;
	}

	private Nodo<CualquierTipo> obtenerRef(int i){
		// Como entrada se tiene el parametro i que es un
		// valor que obligatoriamente debe estar entre 0 y 
		// el numero de elementos de la lista
		// devuelve la referencia al nodo en la posición i
		// de la lista (this)
		// El metodo recorre iterativamente la lista desde la cabeza 
		// hasta llegar al nodo en la posicion i
		
		Nodo<CualquierTipo> p = cabeza.siguiente; // referencia al primer elemento
		int j = 0;
		while (j < i) {
			j++;
			p = p.siguiente;
		}
		System.out.println(p+"p");
		return p;	    	
	}

	public void insertar( CualquierTipo x, int i )
	{   
		// Precondición:    0<= i <= tam 
		//insertar elemento x en la posición i de la lista
		// Se encuentra primero la referencia p del objeto en
		// la posición i , y luego se crea un nodo con el objeto
		// x y se inserta antes del referenciado por p
		Nodo<CualquierTipo> p  = obtenerRef (i) ;
		Nodo<CualquierTipo> nodo_nuevo = new Nodo<>( x, p.anterior, p );  // newNode.prev = p.prev  (1)
		// newNode.next = p   (2)
		nodo_nuevo.anterior.siguiente = nodo_nuevo;  // paso (3)
		p.anterior = nodo_nuevo;  // paso (4)
		tam++;  // se suma 1 al número de elementos de la lista
	}

	public void eliminar(  int i )
	{   
		// Precondición:    0<= i < tam
		// Elimina el nodo en la posición i de la lista
		// Primero se busca la referencia p del nodo en la posición i
		// y luego se procede a eliminarlo
		// 
		Nodo<CualquierTipo> p  = obtenerRef (i) ;
		p.siguiente.anterior = p.anterior;    // paso (1)
		p.anterior.siguiente = p.siguiente;    // paso (2)
		tam--; // se resta 1 al número de elementos de la lista
	}

	public String toString() {
		
		/* Se declara una variable tipo "String" en donde se iran 
		 * agregando cada uno de los elementos de la lista
		 * actual en forma de cadena de caracteres. 
		 */
	    
		String conjuntoString = "[";
		Nodo<CualquierTipo> tmp = cabeza.siguiente;
		
		// iterar sobre los nodos hasta llegar al final de la lista
		// e ir agregando los objetos al string
		// note que convierte tmp.elemento a String
		while (tmp != cola) {
			conjuntoString += tmp.elemento;
			tmp = tmp.siguiente;
			if (tmp!=cola) conjuntoString += ", ";
		}
	    
	    conjuntoString += "]";
	    
	    return conjuntoString;
	}

	public static void main(String args[]) {
		// Creamos (instanciamos) un objeto tipo ListaEnlazada<String>, es decir, una lista
		// cuyos elementos son Strings (cadena de caracteres) y luego
		// la imprimimos mediante el metodo print() de la clase ListaEnlazada
		// y luego la imprimimos en el programa principal (main) utilizando los médos de la lista
		// (recuerde que los nodos estan escondidos, la clase interna Nodo es  private)

		ListaDobEnlCent<String> listaEnlazada1 = 
				new ListaDobEnlCent<>();

		listaEnlazada1.insertar("hola0",0); // lo inserta de ultimo
		listaEnlazada1.insertar("hola1",1);
		listaEnlazada1.insertar("hola2",2);
		listaEnlazada1.insertar("hola3",3);
		listaEnlazada1.insertar("hola4",4); 

		System.out.println(listaEnlazada1);

		// prueba de eliminar 

		listaEnlazada1.eliminar(0);
		listaEnlazada1.eliminar(3);
		System.out.println(listaEnlazada1);
	}
}
