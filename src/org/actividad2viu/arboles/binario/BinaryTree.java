package org.actividad2viu.arboles.binario;

public class BinaryTree <AnyType>
{
    private BinaryNode<AnyType> root; //variable root que estara apuntado a un nodo

    public static class BinaryNode<OtroTipo>
    {
        private OtroTipo element;
        private BinaryNode<OtroTipo> left;
        private BinaryNode<OtroTipo> right;

        public BinaryNode(OtroTipo theElement, BinaryNode<OtroTipo> lt,
                          BinaryNode<OtroTipo> rt)
        {
            element = theElement;
            left = lt;
            right = rt;
        }

        public OtroTipo getElement(){
            return element;
        }

        public BinaryNode<OtroTipo> getLeft(){
            return left;
        }

        public BinaryNode<OtroTipo> getRight(){
            return right;
        }
        public void setElement(OtroTipo x){
            element = x;
        }

        public void setLeft(BinaryNode<OtroTipo> left) {
            this.left = left;
        }

        public void setRight(BinaryNode<OtroTipo> right) {
            this.right = right;
        }
    }
    public BinaryTree( ) // constructor
    {
        root = null; // construye un árbol vacío
    }
    public BinaryTree( AnyType rootItem )
    {
        //Arbol que tiene 1 solo uno del elemento  que le pasamos el arbol
        //izquierdo es nulo y el arbol dereco es nulo
        root = new BinaryNode<AnyType>( rootItem, null, null );
    }

    //Otro constructo pasamos elemento, pasamos apuntadores arbol izquiero y arbol derecho
    public BinaryTree( AnyType rootItem, BinaryTree<AnyType> left,BinaryTree<AnyType> right){
         //validamos si la raices son iguales puede ser el mismo arbol se destinquue si el smimo nodo, evitar compartir nodo
        if( left.root == right.root && left.root != null ){
            System.err.println( "left==right; no se puede"+
                " pues deben ser distintos los"
                + "arboles izq y derecho");
            return;
         }

        root = new BinaryNode<AnyType>( rootItem, left.root, right.root );
        //Note que el nuevo árbol comparte todos los nodos de
        // left y right. Podemos evitar compartir nodos haciendo a left y right vacíos:
        left.root = right.root = null;
    }

    public void makeEmpty( ){
        root = null;
    }

    public AnyType getElementRoot(){
        return ((root ==null) ? null : root.getElement());
    }
    public BinaryNode<AnyType> getLeft( ){
        return root.getLeft( );
    }
    public BinaryNode<AnyType> getRight( ){
        return root.getRight( );
    }
    public boolean isEmpty( ){
        return root == null;
    }

    public boolean se_encuentra(AnyType e){
        return se_encuentra(root, e);
    }

    public boolean se_encuentra(BinaryNode<AnyType> t, AnyType e){
        if (t == null) return false;

        if (t.getElement().equals(e)) return true;
        return (se_encuentra(t.getLeft(), e) || se_encuentra(t.getRight(), e));
    }

    public  int size(){
        return size(root);
    }

    private static <OtroTipo> int size(BinaryNode<OtroTipo> t){
        if(t == null){
            return 0;
        }
        else {
            return 1 + size(t.getLeft()) +size(t.getRight());
        }
    }

    public int height(){
        return height(root);
    }

    private static <OtroTipo> int height(BinaryNode<OtroTipo> t){
        if (t== null){
            return -1;
        }else {
            return 1 + Math.max(height(t.getLeft()), height(t.getRight()) );
        }
    }

    public void printPreOrder( ) // un driver del método recursivo
    {
        if (root != null) printPreOrderR(root);
        System.out.println( );
    }

    private void printPreOrderR (BinaryNode<AnyType> nod )
    {
      System.out.print( nod.getElement() + " ");
// Visitar Nodo
        if( nod.getLeft() != null )
            printPreOrderR( nod.getLeft() );
// Izquierdo
        if( nod.getRight() != null )
            printPreOrderR( nod.getRight() );
// Derecho
    }
    public static <Tipo extends Comparable<? super Tipo>> int nivel(BinaryTree<Tipo> arbol, Tipo elem){
        return nivel(arbol.root, elem, 0);
    }

    private static <Tipo extends Comparable<? super Tipo>> int nivel(BinaryNode<Tipo> nodo, Tipo elem, int nivel){
        //Algoritmo nivel recursivo, que devuelve el nivel donde se encuentre el elemento elm
        if (nodo == null) return -1; //no encontrado caso base
        int cmp = nodo.getElement().compareTo(elem);
        if(cmp == 0) return nivel;
        int res1 =  nivel(nodo.getLeft(), elem, 1+nivel);
        if (res1 >= 0) return res1;
        int res2 = nivel(nodo.getRight(), elem, 1+nivel);
        if (res2 >=0) return res2;
        return -1;
    }

    //KMC para el foro
    public int numNivel(int elNivel){
        return numNivel(root, elNivel, 0);
    }

    public int numNivel(BinaryNode<AnyType> node, int elNivel, int posNivel){
        /*Algoritmo recursivo,
        * elNivel: argumento que indica el nivel se quiere para contar su elementos
        * posNivel: es el nivel de nodo y cuenta para el metodo recursivo*/
        if (node ==null) return 0;
        if (posNivel == elNivel)return 1;//si hemos llgado al nivel entonces sumamos el elmento
        else return (numNivel(node.getLeft(), elNivel, 1+posNivel)
                    +   numNivel(node.getRight(), elNivel, 1+posNivel));
    }

    public static void main(String[] args) {
        BinaryTree<Integer> t1 = new BinaryTree<Integer>(1);
        BinaryTree<Integer> t3 = new BinaryTree<Integer>(3);
        BinaryTree<Integer> t4 = new BinaryTree<Integer>(4);
        BinaryTree<Integer> t42 = new BinaryTree<Integer>();

        BinaryTree<Integer> t41 = new BinaryTree<Integer>(41,t4,t42);

        //La operación siguiente dara mensaje de error
        BinaryTree<Integer> t5 = new BinaryTree<>(5,t1,t1);

        System.out.printf("t5" + t42.root);

        t5.printPreOrder();

        System.out.println("Nivel de raiz = " + nivel(t5, t5.getElementRoot()));
        System.out.println("Nivel de 1 = "+ nivel(t5, 3));

        t5 = new BinaryTree<Integer>(5,t1, t3);

        BinaryTree<Integer> t6 = new BinaryTree<Integer>(6,t5, t41);


    }
}