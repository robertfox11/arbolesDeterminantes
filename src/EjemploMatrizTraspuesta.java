public class EjemploMatrizTraspuesta {
    public static void main(String[] args) {
        int[][] matrizEnteros = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
        };
        int i = 0;
        int j = 0;
        System.out.println("MATRIZ  origina");
        for (i = 0; i < matrizEnteros.length; i++) {
            for (j = 0; j < matrizEnteros[i].length; j++) {
                System.out.print(matrizEnteros[i][j] + "\t");
            }
            System.out.println();
        }

//        vamos a dar la vuelta la primera y segunda  fila con una variable aux
        int aux;
        System.out.println("matriz traspuesta");
        for (i = 1; i < matrizEnteros.length; i++) {
            for (j = 0; j < i; j++) {
                aux = matrizEnteros[i][j];
//                System.out.println(aux);
                matrizEnteros[i][j] = matrizEnteros[j][i];
                matrizEnteros[j][i] = aux;
//                System.out.print(matrizEnteros[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("MATRIZ  traSPUESTA VA INCREMENTANDOSE DE FORMA VERTICAL");
        for ( i = 0; i < matrizEnteros.length;i++){
            for (j =0; j< matrizEnteros[i].length; j++){
                System.out.print(matrizEnteros[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
