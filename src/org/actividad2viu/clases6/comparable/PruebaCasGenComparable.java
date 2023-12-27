package org.actividad2viu.clases6.comparable;
class CasGenComp<CualquierTipo extends Comparable<CualquierTipo>>
        implements Comparable<CasGenComp<CualquierTipo>>
{   // Aqui tenemos una clase que hereda de Comparable y que
    // a su vez el tipo genérico hereda de Comparable
    // coloque esta clase en el mismo archivo
// Datos privados
    private CualquierTipo valor;
    // Métodos públicos
    public CualquierTipo leer( )         { return valor; }
    public void escribir( CualquierTipo x ) { valor = x; }
    public String toString() {
        return valor.toString();
    }
    public int compareTo( CasGenComp<CualquierTipo> x) {
        return valor.compareTo(x.valor);
    }
}
public class PruebaCasGenComparable {
    public static void main( String [ ] args )
    {   CasGenComp<String> m1 = new CasGenComp<String>( );
        CasGenComp<Integer> m2 = new CasGenComp<Integer>( );
        CasGenComp<Integer> m3 = new CasGenComp<Integer>( );
        m1.escribir( "hola" );
        m2.escribir(1000);
        m3.escribir(7);
        System.out.println(" El contenido es: " + "m1 = "+m1+
                "  m2= "+m2+" m3 = "+m3);
        String xx;
        int compar = m2.compareTo(m3);
        if (compar < 0) xx = " es menor que " ;
        else if (compar==0) xx = " es igual a ";
        else  xx = " es mayor que ";
        System.out.println(m2 + xx + m3);

    }
}
