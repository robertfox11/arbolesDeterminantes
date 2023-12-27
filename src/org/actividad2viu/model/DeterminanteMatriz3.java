package org.actividad2viu.model;

public class DeterminanteMatriz3 {

    // Function to get determinant of matrix
    static int determinantOfMatrix(int mat[][], int n)
    {
        int num1, num2, det = 1, index,
                total = 1; // Initialize result

        // temporary array for storing row
        int[] temp = new int[n + 1];

        // loop for traversing the diagonal elements
        for (int i = 0; i < n; i++) {
            index = i; // initialize the index

            // finding the index which has non zero value
            while (mat[index][i] == 0 && index < n) {
                System.out.println("ebtre while");
                index++;
            }
            if (index == n) // if there is non zero element
            {
                System.out.println("entra index == n ");
                // the determinant of matrix as zero
                continue;
            }

            if (index != i) {
                System.out.println("entra");
                // loop for swaping the diagonal element row
                // and index row
                for (
                        int j = 0; j < n; j++) {
                    swap(mat, index, j, i, j);
                }
                // determinant sign changes when we shift
                // rows go through determinant properties
                det = (int)(det * Math.pow(-1, index - i));
            }

            // storing the values of diagonal row elements
            for (int j = 0; j < n; j++) {
                temp[j] = mat[i][j];

                System.out.println("temp" + temp[j]);
            }

            // traversing every row below the diagonal
            // element

            for (int j = i + 1; j < n; j++) {
                num1 = temp[i]; // value of diagonal element
                num2 = mat[j][i]; // value of next row element
                System.out.println(num1+"num1");
                System.out.println(num2+"num2");
                // traversing every column of row
                // and multiplying to every row
                for (int k = 0; k < n; k++) {
                    // multiplying to make the diagonal
                    // element and next row element equal

                    mat[j][k] = (num1 * mat[j][k]) - (num2 * temp[k]);
                    System.out.println("matjk"+mat[j][k]);
                }
                total = total * num1; // Det(kA)=kDet(A);
                System.out.println(total + "total");
            }
        }

        // multiplying the diagonal elements to get
        // determinant

        for (int i = 0; i < n; i++) {
            System.out.println("antes del for por delt " + det + " est mat[i][i] " + mat[i][i]);
            det = det * mat[i][i];
        }
        System.out.println(det + "det despues del for");
        return (det / total); // Det(kA)/k=Det(A);
    }

    static int[][] swap(int[][] arr, int i1, int j1, int i2,
                        int j2)
    {
        int temp = arr[i1][j1];
        arr[i1][j1] = arr[i2][j2];
        arr[i2][j2] = temp;
        return arr;
    }

    // Driver code
    public static void main(String[] args)
    {
        int mat[][] = { { 1, 0, 2, -1 },
                { 3, 0, 0, 5 },
                { 2, 1, 4, -3 },
                { 1, 0, 5, 0 } };
//      int[][] mat = {{4,-1}, {-2,7}};

//        int[][] mat = {{2,-1,3}, {1,-6,2}, {2,1,-2}};
        int n = mat.length;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print("el valor para la posición [" + i + "][" + j + "]: ");
                System.out.print("|"+mat[i][j]+"\t");
            }
            System.out.println();
        }
        // Function call
        System.out.printf(
                "Determinant of the matrix is : %d",
                determinantOfMatrix(mat, n));
    }
}
