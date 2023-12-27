package org.actividad2viu.arboles.binario;

public class BinaryNodeA<AnyType> {
    private AnyType element;
    private BinaryNodeA<AnyType> left;
    private BinaryNodeA<AnyType> right;
    //Princiip de ocultamiento de dato
    public BinaryNodeA(AnyType theElement, BinaryNodeA<AnyType> lt, BinaryNodeA<AnyType> rt ) {
        element = theElement;
        left = lt;
        right = rt;
    }

    //Obtener elemento
    public AnyType getElement( ){
        return element;
    }

    //
    public BinaryNodeA<AnyType> getLeft( ) {
        return left;
    }
    public BinaryNodeA<AnyType> getRight( )
    {
        return right; }
    public void setElement( AnyType x )
    {
        element = x; }
    public void setLeft( BinaryNodeA<AnyType> t )
    {
        left = t;
    }
    public void setRight( BinaryNodeA<AnyType> t )
    {
        right = t;
    }
}
