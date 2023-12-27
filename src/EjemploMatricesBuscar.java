public class EjemploMatricesBuscar {
    public static void main(String[] args) {
        /**Buscando un elemento en un matriz usando un break o usando etiquetas*/
        int[][] matrizEnteros = new int[3][4];
//        int nrandom = (int)  Math.floor(10*Math.random());
//        System.out.println(nrandom);
        for (int i = 0; i< matrizEnteros.length; i++){
            for (int j = 0; j <matrizEnteros[i].length; j++){
                matrizEnteros[i][j] = i+j+((int) Math.floor(100*Math.random()));
            }
        }

        for (int i = 0; i < matrizEnteros.length;i++){
            for (int j =0; j< matrizEnteros[i].length; j++){
                System.out.print(matrizEnteros[i][j]+"\t");
            }
            System.out.println();
        }

        int elementoBuscar = 15;
        boolean encontrado= false;
        int i;
        int j = 0;
//        vamos a utilizar etiquetas para salir del for primario cuando se encuentra el elemento
        buscar: for (i =0; i < matrizEnteros.length;i++){
            for (j =0; j< matrizEnteros[i].length; j++){
                if (matrizEnteros[i][j] == elementoBuscar){
                    encontrado = true;
                    break buscar;
                }
            }
        }
        if (encontrado){
            System.out.println("entontrado elemento a buscar" + elementoBuscar + "En las coordenadas " +  i +" "+ j );
        }else {
            System.out.println("no se encontro en la matriz");
        }
    }
}
