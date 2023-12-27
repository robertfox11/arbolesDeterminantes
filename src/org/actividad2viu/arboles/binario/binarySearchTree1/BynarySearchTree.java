package org.actividad2viu.arboles.binario.binarySearchTree1;

public class BynarySearchTree<T extends Comparable<T >> {
    //Lo que realiza al meter un elemento lo que va hacer ordenar automaticamente
    private NodoArbolBinario<T> root; //va ser el origen

    public boolean isEmpty(){
        //Cuando va ser vacio un arbol cuando root sea null
        return root == null;
    }

    public NodoArbolBinario<T> getRoot() {
        return root;
    }

    //identificar si coger el elemento es el root
    public boolean isRoot(NodoArbolBinario<T> nodo){
        //estamos comparando las referencia el objeto
        return root == nodo;
    }

    //nodo hoja es el que no tiene hijos
    public boolean isLeaf(NodoArbolBinario<T> nodo){
        return nodo.getLeft() == null && nodo.getRigth() == null;
    }

    public boolean isInternal(NodoArbolBinario<T> nodo){
        //Si no es hoja
        return !isLeaf(nodo);

    }


    // vamos añadir el datos recursivo
    public NodoArbolBinario<T> add(NodoArbolBinario<T> origen, T element){
        NodoArbolBinario<T> nodo = null;
        if (root == null){
            root = new NodoArbolBinario<>(element);
        } else if (origen == null) {
            System.out.println("El origen es nulo");
        }else {

            if (origen.getElement().compareTo(element) > 0){
                //si el orgen del elemento supongamos que es el root si es mayor que el  elemento es menor  a cero
                //este elemento lo emtemos a la izquierda
                //comprobamos que si el elemento izquierdo existe
                if (origen.getLeft() != null ){
                    //hacemos la llamada recursiva, llamamos de nuveo este metodo, ahora idicamos que el origen es que lo ponemos
                    add(origen.getLeft(), element );
                }else {
                    //que pasa si no existe el elemento creamos el nodo, y el origen es el elemento
                    nodo = new NodoArbolBinario<>(element);
                    nodo.setParent(origen); //este es el origen el padre
                    origen.setLeft(nodo); //origen quien tu izquierdo es el nodo
                }
            }else {
                //si el orgen del elemento supongamos que es el root si es mayor que el  elemento es menor  a cero
                //este elemento lo emtemos a la izquierda
                //comprobamos que si el elemento izquierdo existe
                if (origen.getRigth()  != null ){
                    //hacemos la llamada recursiva, llamamos de nuveo este metodo, ahora idicamos que el origen es que lo ponemos
                    add(origen.getRigth(), element );
                }else {
                    //que pasa si no existe el elemento creamos el nodo, y el origen es el elemento
                    nodo = new NodoArbolBinario<>(element);
                    nodo.setParent(origen); //este es el origen el padre
                    origen.setRigth(nodo); //origen quien tu izquierdo es el nodo
                }
            }
        }
        return nodo;

    }
    public NodoArbolBinario<T> add(T element){
        NodoArbolBinario<T> nodo = null;
        if (root == null){
            root = new NodoArbolBinario<>(element);
        }else {
            //existe un root
            NodoArbolBinario<T> aux = root;
            boolean insertado = false;
            while (!insertado){
                //si el orgen del elemento supongamos que es el root si es mayor que el  elemento es menor  a cero
                //este elemento lo emtemos a la izquierda
                //comprobamos que si el elemento izquierdo existe
                if (aux.getElement().compareTo(element) > 0){
                    if (aux.getLeft() != null ){
                        //hacemos la llamada recursiva, llamamos de nuveo este metodo, ahora idicamos que el origen es que lo ponemos
                        aux = aux.getLeft();
                    }else {
                        //que pasa si no existe el elemento creamos el nodo, y el origen es el elemento
                        nodo = new NodoArbolBinario<>(element);
                        nodo.setParent(aux); //este es el origen el padre
                        aux.setLeft(nodo); //origen quien tu izquierdo es el nodo
                        insertado = true;
                    }
                }else {
                    //si el orgen del elemento supongamos que es el root si es mayor que el  elemento es menor  a cero
                    //este elemento lo emtemos a la izquierda
                    //comprobamos que si el elemento izquierdo existe
                    if (aux.getRigth()  != null ){
                        //hacemos la llamada recursiva, llamamos de nuveo este metodo, ahora idicamos que el origen es que lo ponemos
                        aux = aux.getRigth();
                    }else {
                        //que pasa si no existe el elemento creamos el nodo, y el origen es el elemento
                        nodo = new NodoArbolBinario<>(element);
                        nodo.setParent(aux); //este es el origen el padre
                        aux.setRigth(nodo); //origen quien tu izquierdo es el nodo
                        insertado = true;
                    }
                }
            }
        }
        return nodo;

    }
}
