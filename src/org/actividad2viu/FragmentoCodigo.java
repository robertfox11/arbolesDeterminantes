package org.actividad2viu;

public class FragmentoCodigo {
    public static void main(String[] args) {
        int n = 4;

        int sum = 0;
        for (int i = 0; i < n*n; i++){
            sum += i;
        }
        System.out.println(sum);
        sum = 0;
        for (int i = 0; i*i < n; i++){
            sum += i;
        }
        System.out.println(sum);

        sum = 0;
        for (int i = n*n; i > 1; i /= 2){
            if (i > 16) sum += i;
        }
        System.out.println(sum);

        sum = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                for (int k = j+1; k < n; k++){
                    sum += i*j*k;
                }
            }
        }
        System.out.println(sum);
    }
}
