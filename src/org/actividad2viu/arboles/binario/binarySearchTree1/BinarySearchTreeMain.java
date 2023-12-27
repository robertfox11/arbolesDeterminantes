package org.actividad2viu.arboles.binario.binarySearchTree1;

public class BinarySearchTreeMain {
    public static void main(String[] args) {
        BynarySearchTree<Integer> arbol = new BynarySearchTree<>();
        arbol.add(8);
        arbol.add(4);
        arbol.add(arbol.getRoot(), 10);
        arbol.add(arbol.getRoot(), 12);
        arbol.add(1);
        System.out.println("**********Arbol ");
        System.out.println(arbol);

        System.out.println("************PREORDER");
        arbol.preorder(arbol.getRoot() );

        System.out.println("****INORDER********");
        arbol.inorder(arbol.getRoot());
        System.out.println("****POSTORDER********");
        arbol.postorder(arbol.getRoot());
    }
}

