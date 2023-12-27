public class EjemploMatrizSimetrica {
    public static void main(String[] args) {
        //Matriz simetrica
//        int[][] matriz = new int[4][4];
        int[][] matriz = {
            {1,2,3,4},
            {2,1,0,5},
            {3,0,1,6},
            {4,5,6,7},
        };
        boolean simetrica = true;
        //rellenamos automaticamente todos los valores si son igulaes que la primera fila que la 1 primera columna entonces son simetrica asi sucesivo
        //segunda fila con la segunda columna
//        for (int i = 0; i < matriz.length; i++) {
//            for (int j = 0; j < matriz[i].length; j++) {
//                matriz[i][j] = i + j + ((int) Math.floor(10 * Math.random()));
//            }
//        }

        int i = 0;
        int j = 0;
        salirfor: for (i = 0; i < matriz.length; i++) {
            for (j = 0; j <i; j++) {
                if (matriz[i][j] != matriz[j][i]){
                    simetrica = false;
                    break salirfor;
                }
            }
        }
//        utilizando etiquetas con while
//        salir: while (i< matriz.length){
//            j = 0;
//            while (j<i){
//                if (matriz[i][j] != matriz[j][i]){
//                    simetrica = false;
//                    break salir;
//                }
//                j++;
//            }
//            i++;
//        }
        if (simetrica){
            System.out.println("la matriz es simetrica");
        }else {
            System.out.println("La matriz no es simetrica");
        }
    }
}
