package org.actividad2viu;

public class evaluacionPolinomio {
    private static double evaluacionPolinomio(double[] pol, double x, int n) {
        int i = 0;
        double eval = 0.0;
        while (i <= n) {
            eval += pol[i] * potencia(x, i);
            i++;
        }
        return eval;
    }
    public static double potencia(double x,int i){
        if( i == 0 ) return 1;
        if( i == 1 ) return x;
        if( i%2 == 0 )return potencia( x * x, i / 2 );
        else return potencia( x * x, i / 2 ) * x;
    }
    public static void main(String[] args) {
        // Ejemplo de uso
        double[] polinomio = {1, 2, 3}; // Coeficientes del polinomio: 1 + 2x + 3x^2
        double valorX = 2; // Valor de x a evaluar
        int gradoPolinomio = polinomio.length - 1; // Grado del polinomio
        double resultado = evaluacionPolinomio(polinomio, valorX, gradoPolinomio);
        System.out.println("El resultado de evaluar el polinomio en x = " + valorX + " es: " + resultado);
    }
}
