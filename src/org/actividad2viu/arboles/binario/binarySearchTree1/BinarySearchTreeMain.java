package org.actividad2viu.arboles.binario.binarySearchTree1;

import java.util.ArrayList;

public class BinarySearchTreeMain {
    public static void main(String[] args) {
        BynarySearchTree<Integer> arbol = new BynarySearchTree<>();

//        int[] elements = {54, 14, 10, 56, 30, 45, 9, 20, 62, 18, 54, 55 };
        int[] elements = {54, 56, 30, 45, 18,10, 9, 20, 62 ,  55 };
//        NodoArbolBinario<Integer> t = arbol.add(arbol.getRoot(), 50);
////        NodoArbolBinario<Integer> t41 = arbol.add(arbol.getRoot(), 45);
////        NodoArbolBinario<Integer> t4 = arbol.add(arbol.getRoot(), );
//        NodoArbolBinario<Integer> t3 = arbol.add(arbol.getRoot(), 25);
//        NodoArbolBinario<Integer> t2 = arbol.add(arbol.getRoot(), 14);

        for (int element: elements){
//            arbol.add(element);
            arbol.add(arbol.getRoot(), element);
        }
//        arbol.add(10);
//        arbol.add(arbol.getRoot(), 35);
//        arbol.add(arbol.getRoot(), 45);
//        arbol.add(arbol.getRoot(), 52);
//        arbol.add(arbol.getRoot(), 40);
//        arbol.add(arbol.getRoot(), 12);

        arbol.mostrar(arbol.getRoot());
//        arbol.remove(t);
//        arbol.mostrar(arbol.getRoot());
//        NodoArbolBinario<Integer> t = arbol.add(arbol.getRoot(), 45);
////        arbol.add(20);
////        arbol.add(20);
////        arbol.add(20);
////        arbol.add(30);
//        NodoArbolBinario<Integer> t2 = arbol.add(arbol.getRoot(), 35 );
////        arbol.add(40);
////        arbol.add(15);
//        NodoArbolBinario<Integer> t3 = arbol.add(arbol.getRoot(), 52);
//        NodoArbolBinario<Integer> t5 = arbol.add(arbol.getRoot(), 18);
//        NodoArbolBinario<Integer> t6 = arbol.add(arbol.getRoot(), 10);
//
//        System.out.println("**********Arbol ");
//        System.out.println(arbol);
//
//        System.out.println("************PREORDER");
//        arbol.preorder(arbol.getRoot() );
//
//        System.out.println("****INORDER********");
//        arbol.inorder(arbol.getRoot());
//        System.out.println("****POSTORDER********");
//        arbol.postorder(arbol.getRoot());
//
//        System.out.println("*******Altura del Arbol");
//        System.out.println(arbol.height(arbol.getRoot()));
//        System.out.println("*******Altura del Arbol cont ");
//        System.out.println(arbol.height(t));
//        System.out.println("*******Produndidad del Arbol");
//        System.out.println(arbol.depth(t));
//
//        System.out.println("*******************Pruebas de Remove");
//        arbol.mostrar(arbol.getRoot());
//        arbol.remove(t);
//        arbol.mostrar(arbol.getRoot());
////        arbol.remove(t2);
////        arbol.remove(t3);
////        arbol.remove(t4);
////        arbol.inorder(arbol.getRoot() );
//        System.out.println("*******************Pruebas de buscando nodos en nuestro arbol, mostrar un elemento en concreto");
//        //queremos que nos encuentre el nodo 12
//        NodoArbolBinario<Integer> nodo = arbol.getNode(arbol.getRoot(), 8);
//
//        if (nodo != null){
//            System.out.println("get node: " + nodo.getElement());
//        }
//        Integer elemento = arbol.getElement(nodo, 45);
//
//        System.out.println("getElement " + elemento);
//
//        //Encontrar variao elemento
//        ArrayList<NodoArbolBinario<Integer>> nodos = new ArrayList<>();
//        arbol.getNodes(arbol.getRoot(), 20 , nodos);
//        System.out.println("get node");
//        for (NodoArbolBinario<Integer> aux:nodos){
//            System.out.println(aux.getElement());
//        }
//
//        ArrayList<Integer> elementos = new ArrayList<>();
//       elementos = arbol.getElements(nodo, 20   );
//        System.out.println("get elements");
//        for (Integer aux:elementos){
//            System.out.println(aux);
//        }
//        System.out.println("Mostramos el arbol");
////        arbol.mostrar(nodo);
//        System.out.println("*************+");
//        BynarySearchTree<Integer> tree = new BynarySearchTree<>();
//        int[] elements = { 50, 25, 14, 10, 56, 30, 45, 9, 20, 62, 18, 54, 55 };
//
//        for (int element : elements) {
//            tree.add(element);
//
//            System.out.println("Después de insertar " + element + ": ");
//            tree.mostrar(tree.getRoot());
//
//            System.out.println();
//        }
//        System.out.println("*******Printorder");
////        tree.preorder(tree.getRoot());
//        System.out.println("remover ");
//        int[] elementsEliminar = { 50, 25, 14};
////        NodoArbolBinario<Integer> t8 = tree.getNode(tree.getRoot(), 50);
////        NodoArbolBinario<Integer> t = arbol.add(arbol.getRoot(), 45);
////        System.out.println("get node: " + nodo1.getElement());
////        tree.remove(t8);
////        tree.mostrar(tree.getRoot());
////        for (int element : elementsEliminar) {
////
////            System.out.println("Eliminamos el elemento " + element + ": ");
////            tree.remove(nodo1);
////
////            System.out.println();
//        }
    }
}

