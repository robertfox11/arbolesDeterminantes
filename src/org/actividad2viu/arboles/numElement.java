package org.actividad2viu.arboles;

public class numElement {



    public static void main(String[] args) {
        Integer[] lista= new Integer[] {1,2,3,4};
        numElemento(lista);
    }
    public  static int numElemento(Integer[] T){
        System.out.println(T.length);
        int n = T.length;
        if (n == 0){
            return 0;
        }
        int total =0;
        for (int lista : T){
            System.out.println("lista"+ lista);
//            total += numElemento(T(lista));
        }
        return 1;
    }



}
