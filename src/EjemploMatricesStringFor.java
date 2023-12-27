public class EjemploMatricesStringFor {
    public static void main(String[] args) {
        String[][] nombres = new String[3][2];

        nombres[0][0] = "pepe";
        nombres[0][1] = "pepa";
        nombres[1][0] = "Josefa";
        nombres[1][1] = "Paco";
        nombres[2][0] = "Lucas";
        nombres[2][1] = "Pancha";

        //recorremos fila
        System.out.println("iterando con for");
        for (int i=0; i< nombres.length; i++){
            //recoreemos cada columna
            for (int j = 0; j< nombres[i].length; j++){
                System.out.print(nombres[i][j]+ "\t");
            }
            System.out.println();
        }
        System.out.println("iterando con foreach");
        for (String[] fila:nombres  ) {
            for (String nombre:fila ) {
                System.out.println(nombre + " \t");
            }
            System.out.println();
        }
    }
}

