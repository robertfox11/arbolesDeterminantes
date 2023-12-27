public class EjemploMatricesSumar {
    public static void main(String[] args) {
        int [][] a = new int[3][3];
        int [][] b = new int[3][3];
        int [][] sumaAB = new int[3][3];
//        llenamos la matriz a
        for (int i = 0; i< a.length; i++){
            for (int j = 0; j <a[i].length; j++){
                a[i][j] = i+j+((int) Math.floor(100*Math.random()));
            }
        }
//        llenamos la matriz b
        for (int i = 0; i< b.length; i++){
            for (int j = 0; j <b[i].length; j++){
                b[i][j] = i+j+((int) Math.floor(100*Math.random()));
            }
        }

        System.out.println("suma de a y b");
        for (int i = 0; i< a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(sumaAB[i][j]+"\t");
            }
            System.out.println();
        }

    }
}
