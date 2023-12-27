package org.actividad2viu.arboles.binario.binarySearchTree1;

public class BinarySearchTreeMain {
    public static void main(String[] args) {
        BynarySearchTree<Integer> arbol = new BynarySearchTree<>();
        arbol.add(8);
        arbol.add(4);
        arbol.add(arbol.getRoot(), 10);
        arbol.add(arbol.getRoot(), 12);
        arbol.add(1);

        System.out.println(arbol);
    }
}
