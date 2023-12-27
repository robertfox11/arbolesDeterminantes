package org.actividad2viu.actividad3;

public class MetodoCompareTo {
    public static void main(String[] args) {
//        devuelve <0, entonces la cadena que llama al método es primero lexicográficamente
//        devuelve == 0 entonces las dos cadenas son lexicográficamente equivalentes
//        devuelve> 0, entonces el parámetro pasado al método compareTo es lexicográficamente el primero.

        String str_Sample = "a";
        System.out.println("Compare To 'a' b is : " + str_Sample.compareTo("c"));
        str_Sample = "j";
        System.out.println("Compare To 'b' a is : " + str_Sample.compareTo("b"));
        str_Sample = "b";
        System.out.println("Compare To 'b' b is : " + str_Sample.compareTo("b"));
    }
}
