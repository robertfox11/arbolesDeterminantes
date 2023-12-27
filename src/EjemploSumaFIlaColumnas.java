public class EjemploSumaFIlaColumnas {
    public static void main(String[] args) {
        int sumaFila, sumaColumnas;
        int [][] a = new int[3][3];
        int [][] b = new int[3][3];
        int [][] sumaAB = new int[3][3];
//        llenamos la matriz a
        for (int i = 0; i< a.length; i++){
            for (int j = 0; j <a[i].length; j++){
                a[i][j] = i+j+((int) Math.floor(100*Math.random()));
            }
        }
        System.out.println("matriz a");
        for (int i = 0; i< a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j]+"\t");
            }
            System.out.println();
        }
//        llenamos la matriz b
        for (int i = 0; i< b.length; i++){
            for (int j = 0; j <b[i].length; j++){
                b[i][j] = i+j+((int) Math.floor(100*Math.random()));
            }
        }
        System.out.println("matriz b");
        for (int i = 0; i< b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                System.out.print(b[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println("sumamos el total de cada fila y collumna");
        for (int i = 0; i< a.length; i++) {
            sumaColumnas = 0;
            sumaFila =0;
            for (int j = 0; j < a[i].length; j++) {
                sumaFila += a[i][j];
                sumaColumnas += a[j][i];
            }
            System.out.println("Total fila " +i +" :"+sumaFila );
            System.out.println("Total columna " +i +" :"+sumaColumnas );
        }
    }
}
