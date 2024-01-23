package org.actividad2viu.arboles.binario.binarySearchTree1;

import java.util.ArrayList;

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

    /**
     * Añade un nodo de forma recursiva
     *
     * @param origen
     * @param elemento
     * @return nodo añadido
     */
    // vamos añadir el datos recursivo
    public NodoArbolBinario<T> add(NodoArbolBinario<T> origen, T elemento) {

        NodoArbolBinario<T> nodo = null;
        //Si el root es nulo, lo añade el primero
        if (root == null) {
            nodo = new NodoArbolBinario<>(elemento);
            root = nodo;
        } else if (origen == null) { //el parametro pasado es invalido
            System.out.println("El origen es nulo");
        } else {

            //Comparamos los elementos
            //Si el nodo del origen es mayor que el elemento pasado, pasa a la izquierda
            if (origen.getElement().compareTo(elemento) > 0) {

                //Si tiene nodo izquierdo, hago la llamada recursiva
                if (origen.getLeft() != null) {
                    nodo = add(origen.getLeft(), elemento);
                } else {
                    //Creo el nodo
                    nodo = new NodoArbolBinario<>(elemento);
                    //Indico que el padre del nodo creado
                    nodo.setParent(origen);
                    //Indico que el nodo es el nodo izquierdo del origen
                    origen.setLeft(nodo);
                }

            } else { //sino pasa a la derecha

                //Si tiene nodo derecho, hago la llamada recursiva
                if (origen.getRigth() != null) {
                    nodo = add(origen.getRigth(), elemento);
                } else {
                    //Creo el nodo
                    nodo = new NodoArbolBinario<>(elemento);
                    //Indico que el padre del nodo creado
                    nodo.setParent(origen);
                    //Indico que el nodo es el nodo izquierdo del origen
                    origen.setRigth(nodo);
                }

            }

        }

        return nodo;

    }
    public NodoArbolBinario<T> add(T elemento) {

        NodoArbolBinario<T> nodo = null;
        //Si el root es nulo, lo añade el primero
        if (root == null) {
            nodo = new NodoArbolBinario<>(elemento);
            root = nodo;
        } else {

            //Creo un nodo auxuliar
            NodoArbolBinario<T> aux = root;
            boolean insertado = false;
            //No salgo hasta que este insertado
            while (!insertado) {

                //Comparamos los elementos
                //Si el nodo del origen es mayor que el elemento pasado, pasa a la izquierda
                if (aux.getElement().compareTo(elemento) > 0) {

                    //Si tiene nodo izquierdo, actualizo el aux
                    if (aux.getLeft() != null) {
                        aux = aux.getLeft();
                    } else {
                        //Creo el nodo
                        nodo = new NodoArbolBinario<>(elemento);
                        //Indico que el padre del nodo creado
                        nodo.setParent(aux);
                        aux.setLeft(nodo);
                        //indico que lo he insertado
                        insertado = true;
                    }

                } else {

                    if (aux.getRigth() != null) {
                        aux = aux.getRigth();
                    } else {
                        //Creo el nodo
                        nodo = new NodoArbolBinario<>(elemento);
                        //Indico que el padre del nodo creado
                        nodo.setParent(aux);
                        aux.setRigth(nodo);
                        //indico que lo he insertado
                        insertado = true;
                    }

                }

            }

        }

        return nodo;

    }

    //Preorden
    public void preorder(NodoArbolBinario<T> nodo){
        //Este es el preorder
        System.out.println(nodo.getElement().toString());
        if (nodo.getLeft() != null) {
            //Hay un nodo hay preorder donde  va ser el nuevo nodo
            preorder(nodo.getLeft());
        }

        if (nodo.getRigth() != null){
            preorder(nodo.getRigth());
        }
    }
    public void inorder(NodoArbolBinario<T> nodo){

        if (nodo.getLeft() != null) {
            //Hay un nodo hay preorder donde  va ser el nuevo nodo
            inorder(nodo.getLeft());
        }
        //Este es el inorder
        System.out.println(nodo.getElement().toString());
        if (nodo.getRigth() != null){
            inorder(nodo.getRigth());
        }

    }

    public void postorder(NodoArbolBinario<T> nodo){

        if (nodo.getLeft() != null) {
            //Hay un nodo hay preorder donde  va ser el nuevo nodo
            postorder(nodo.getLeft());
        }

        if (nodo.getRigth() != null){
            postorder(nodo.getRigth());
        }
        //Este es el postorder
        System.out.println(nodo.getElement().toString());

    }

    //altura de nodo no se encuentra el propio nodo
    public int height(NodoArbolBinario<T> nodo){
        int height = 0;
        //Si el nodo si internal si tiene hijos
        if (isInternal(nodo)){
            if (nodo.getLeft() != null){
                //actualizmamos la altura max cogera el mayor de las dos
                height = Math.max(height, height(nodo.getLeft()));
            }
            if (nodo.getRigth() != null){
                height = Math.max(height, height(nodo.getRigth()));
            }
            height++;
        }
        return  height;
    }

    //la profundidad del nodo se cuenta el nodo
    public int depth(NodoArbolBinario<T> nodo){
        int depth = 0;
        //si nodo si es distinto
        if (nodo != getRoot()){
            //si distinto de root voy al padre
            depth = 1 + depth(nodo.getParent());

        }
        return depth;
    }

    //Eliminar nodo
    public void remove (NodoArbolBinario<T> nodo){
        if (root == null){
            //Que vamos a eliminar
            System.out.println("no hay nodo que borrar");
        } else if (isLeaf(nodo) ) {
            //si el nodo es una hoja
            removeLeaf(nodo);
        } else if (nodo.getRigth() != null && nodo.getLeft() == null) {
            //Si el tiene nodo derecho y is no tiene nodo izquierd
            removeWithChild(nodo, ONE_NODE_RIGHT);

        } else if (nodo.getRigth() == null && nodo.getLeft() != null) {
            //Si el nodo derecho es null si nodo izquiesdo no es null
            removeWithChild(nodo, ONE_NODE_LEFT);
        }else {
            //Si tiene dos nodos
            removeWithChild(nodo, TWO_NODES);
        }
    }

    private void removeLeaf(NodoArbolBinario<T> nodo){
        //Si queremos borrar el root
        if (isRoot(nodo)){
//            el nodo que no tenga root
            root = null;
        }else {
            //si tiene hijos cogemos el padre
            NodoArbolBinario<T> parent = nodo.getParent();
            if (parent.getLeft() == nodo){
                //lo ponemos a null
                parent.setLeft(null);
            }

            if (parent.getRigth() == nodo){

                parent.setRigth(null);
            }

            nodo = null;
        }
    }

    private final int ONE_NODE_LEFT = 1;
    private final int ONE_NODE_RIGHT = 2;
    private final int TWO_NODES = 3;
    private void removeWithChild(NodoArbolBinario<T> nodo, int type_node){
        //declaramos un variable para obtener el valor siquiiente
        NodoArbolBinario<T> siguiente = null;
        //coger el menor de la siguiente rama , si no hubieara la rama izquierda cogiera el left

        switch (type_node) {
            case ONE_NODE_LEFT:
                //el siguiente lo coge en el izquierdo
                siguiente = nodo.getLeft();
                break;
            case ONE_NODE_RIGHT:
                //Si tiene uno derecho, cogemos el nodo getright
                siguiente = minSubTree(nodo.getRigth());
                break;
            case TWO_NODES:

                siguiente = minSubTree(nodo.getRigth());
                //Aseguramos que el root no sea el padre
                if (!isRoot(siguiente.getParent())) {
                    //cogemos el nodo que queremos borrar
                    //indicamos que el nuevo padre es el siguiente
                    nodo.getLeft().setParent(siguiente);
                    nodo.getRigth().setParent(siguiente);


                    if (siguiente.getParent().getLeft() == siguiente) {
                        //Cogemos el padre  es igual a siguiente lo cortamos de raiz cortamos la relación
                        siguiente.getParent().setLeft(null);
                    } else if (siguiente.getParent().getRigth() == siguiente) {
                        //Cogemos el padre  es igual a siguiente lo cortamos de raiz cortamos la relación
                        siguiente.getParent().setRigth(null);
                    }
                }

                break;
        }

        //Vamos a decirl del padre del siguiente el padre del nodo que hemos borrado
        siguiente.setParent(nodo.getParent());

        if (!isRoot(nodo)) {

            if (nodo.getParent().getLeft() == nodo) {
                //
                nodo.getParent().setLeft(siguiente);
            } else if (nodo.getParent().getRigth() == nodo) {
                nodo.getParent().setRigth(siguiente);
            }

        } else {
            root = siguiente;
        }
        //En caso que el nodo tiene hijo va adoptar el nodo
        if (nodo.getRigth() != null && nodo.getRigth() != siguiente) {
            //Aqui obtiene al hijo
            siguiente.setRigth(nodo.getRigth());
        }


        //
        if (nodo.getLeft() != null && nodo.getLeft() != siguiente) {
            siguiente.setLeft(nodo.getLeft());
        }
        //eliminar el nodo
        nodo = null;

    }


    /*Calcula el valor minimo de un subarbol
    * */
    private NodoArbolBinario<T> minSubTree(NodoArbolBinario<T> nodo){
        //Cogemos el minimo valor de un subarbol
        if (nodo != null && nodo.getLeft() != null){
            //Coge de mas de la izquierda este
            //Mientra sea distinto de una hoja, obtenemos el minimo
            while (!isLeaf(nodo)){
                //ahora llamamos el sub arbol
                nodo = minSubTree(nodo.getLeft());
            }
        }
        return nodo;
    }

    /**
     * get node
     * */
    public NodoArbolBinario<T> getNode(NodoArbolBinario<T> nodo, T element){
        //
        NodoArbolBinario<T> aux = null;
        if (nodo.getElement().compareTo(element) == 0){
            //comparamos si es igual cero aux igual a nodo
            aux = nodo;
        }else {
            if (nodo.getLeft() != null){
                //
                aux = getNode(nodo.getLeft(), element);
            }
            if (nodo.getRigth() != null){
                //
                aux = getNode(nodo.getRigth(), element);
            }
        }
        return aux;

    }

    public T getElement(NodoArbolBinario<T> nodo, T element){
        // deveolvemos el elemento
        NodoArbolBinario<T> aux = getNode(nodo, element);

        if (aux == null){
            return null;
        }
        return aux.getElement();
    }

    //elemento devuelva la lista enladas con los elementos
    public void getNodes(NodoArbolBinario<T> nodo, T element, ArrayList<NodoArbolBinario<T>> listanodos) {
        //si el nodo  se igual a cero
        if (nodo.getElement().compareTo(element) == 0){
            listanodos.add(nodo);
        }
        if (nodo.getLeft() != null){
            //
            getNodes(nodo.getLeft(), element, listanodos);
        }
        if (nodo.getRigth() != null){
            //
            getNodes(nodo.getRigth(), element, listanodos);
        }
    }

    public ArrayList<T> getElements(NodoArbolBinario<T> nodo, T element){
        ArrayList<T> elementos = new ArrayList<>();
        ArrayList<NodoArbolBinario<T>> lista_nodos = new ArrayList<>();

        getNodes(nodo, element, lista_nodos);

        for (NodoArbolBinario<T> aux : lista_nodos) {

            elementos.add(aux.getElement());

        }

        return elementos;
    }


    public void mostrar(NodoArbolBinario<T> nodo) {
        //Profundidad
        int profundidad = this.depth(nodo);
        for (int i = 0; i < profundidad; i++) {
            System.out.print(" ");
        }

        System.out.println("- "+nodo.getElement().toString());

        if (nodo.getLeft() != null) {
            mostrar(nodo.getLeft());
        }

        if (nodo.getRigth() != null) {
            mostrar(nodo.getRigth());
        }

    }
}
