public class Solutions {
    public static void main(String[] args) {
        System.out.println("yes");
    /*
        int[][] arr = new int[][] {{1, 2, 3}, {2, 13, 1}, {6, 5, 100}};
        int[][] newArr = scale(arr, 3);
        printMatrix(newArr);
        */
        // System.out.println(10 - Math.floor(Math.log10(5)));
        // int[][] matrix = new int[][] {{6, 4, 2}, {1, -2, 8}, {1, 5, 7}};
        /*
        int[][] matrix = new int[][] {{6, 4, 2}, {1, -2, 8}, {1, 5, 7}};
        printMatrix(matrix);
        try {
            System.out.println("Determinant: " + determinant(matrix));
        } catch (Exception e) {
            e.printStackTrace();
        }
        */
        int[][] m1 = {{1, 4}, {2, 5}, {3, 6}};
        printMatrix(m1);
        System.out.println();
        int[][] m2 = {{7, 9, 11}, {8, 10, 12}};
        printMatrix(m2);
        System.out.println();
        try {
            printMatrix(multiplyMatrices(m1, m2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static int[][] scale(int[][] input, int factor) {
        int[][] output = new int[input.length][input[0].length];
        for (int col = 0; col < input.length; col++) {
            for (int row = 0; row < input[0].length; row++)
                output[col][row] = input[col][row] * factor;
        }
        return output;
    }


    public static int determinant(int[][] input) throws Exception {
        // System.out.println("iteratio");
        // System.out.print("determinant called");
        if (input.length != input[0].length) throw new Exception("Matrix must have same number of rows as columns.");
        if (input.length == 2) return input[0][0] * input[1][1] - input[0][1] * input[1][0];
        int result = 0;
        int mult = 1;
        for (int col = 0; col < input.length; col++) { // create all other matrixes to get determinants of them
            int elem = input[col][0];
            // create copy of matrix that does not contain any elements in same row or column
            int[][] cutMatrix = new int[input.length - 1][input.length - 1];
            int colM;
            for (colM = 0; colM < col; colM++) { // before selected element
                for (int rowM = 1; rowM <= cutMatrix.length; rowM++) {
                    cutMatrix[colM][rowM - 1] = input[colM][rowM];
                }
            }
            for (colM = colM + 1; colM < input.length; colM++) { // after selected element
                for (int rowM = 1; rowM <= cutMatrix.length; rowM++) {
                    cutMatrix[colM - 1][rowM - 1] = input[colM][rowM];
                }
            }
            result += mult * elem * determinant(cutMatrix);
            mult *= -1;
        }
        return result;
    }


    public static int[][] multiplyMatrices(int[][] m1, int[][] m2) throws Exception {
        if (m1.length != m2[0].length || m1[0].length != m2.length) {
            if (m2.length == m1[0].length && m1.length == m2[0].length)
                return multiplyMatrices(m2, m1); // reverse inputs
            throw new Exception("Number of rows in one matrix must equal number of columns in the other, and vice versa.");
        }
        int[][] result = new int[m1[0].length][m2.length]; // m2.length (num of cols in m2) is same as m1[0].length (num of rows in m2)
        for (int m1Row = 0; m1Row < m1[0].length; m1Row++) {
            for (int m2Col = 0; m2Col < m2.length; m2Col++) {
                for (int a = 0; a < m2.length + 1; a++) { // m2.length (num of cols in m2) is same as m1[0].length (num of rows in m2)
                    result[m2Col][m1Row] += m1[a][m1Row] * m2[m2Col][a];
                }
            }
        }
        return result;
    }


    public static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix[0].length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[col][row] + " ");
            }
            System.out.println();
        }
    }
}
