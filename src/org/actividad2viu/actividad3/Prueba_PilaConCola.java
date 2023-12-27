package org.actividad2viu.actividad3;

import java.util.ArrayList;
import java.util.List;

public class Prueba_PilaConCola<T extends Comparable<T>> {

    public static <T extends Comparable<T>> int redistribuir(List<T> lista, T x) {
        int left = 0;
        int right = lista.size() - 1;

        while (left <= right) {
            while (left <= right && lista.get(left).compareTo(x) < 0) {
                left++;
            }

            while (left <= right && lista.get(right).compareTo(x) >= 0) {
                right--;
            }

            if (left < right) {
                T temp = lista.get(left);
                lista.set(left, lista.get(right));
                lista.set(right, temp);
                left++;
                right--;
            }
        }

        return left;
    }
     public static void main(String[] args) {
        List<Integer> lista = new ArrayList<>();
/*         lista.add(1);
        lista.add(5);
        lista.add(2);
        lista.add(8);

        lista.add(7);
        lista.add(4);*/
//            [2,4,3,5,9,6,8,9]
         lista.add(2);
         lista.add(5);
         lista.add(3);
         lista.add(4);
         lista.add(9);
         lista.add(6);
         lista.add(8);
         lista.add(9);
//         lista.add(9);
//         lista.add(5);


        int pivot = 5; // Elemento X
         System.out.println("Lista original");
         System.out.println(lista);

        int p = redistribuir(lista, pivot);

        System.out.println("La posición p es: " + p);
        System.out.println("Lista después de redistribuir:");
        System.out.println(lista);
    }
}
