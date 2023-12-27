package org.actividad2viu.arboles.binario.binarySearchTree1;

public class NodoArbolBinario<T extends Comparable<T>> {

    private T element;
    private NodoArbolBinario<T> parent;
    private NodoArbolBinario<T> left;
    private NodoArbolBinario<T> rigth;

    //Creamos 4 constructores
    public NodoArbolBinario(T element) {
        this.element = element;
    }

    public NodoArbolBinario(T element, NodoArbolBinario<T> parent, NodoArbolBinario<T> left, NodoArbolBinario<T> rigth) {
        this.element = element;
        this.parent = parent;
        this.left = left;
        this.rigth = rigth;
    }

    public NodoArbolBinario(T element, NodoArbolBinario<T> parent) {
        this.element = element;
        this.parent = parent;
    }

    public NodoArbolBinario(T element, NodoArbolBinario<T> left, NodoArbolBinario<T> rigth) {
        this.element = element;
        this.left = left;
        this.rigth = rigth;
    }

    //Setters y getters


    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public NodoArbolBinario<T> getParent() {
        return parent;
    }

    public void setParent(NodoArbolBinario<T> parent) {
        this.parent = parent;
    }

    public NodoArbolBinario<T> getLeft() {
        return left;
    }

    public void setLeft(NodoArbolBinario<T> left) {
        this.left = left;
    }

    public NodoArbolBinario<T> getRigth() {
        return rigth;
    }

    public void setRigth(NodoArbolBinario<T> rigth) {
        this.rigth = rigth;
    }
}
