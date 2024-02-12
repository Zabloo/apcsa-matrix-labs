public class Solutions {
    public static void main(String[] args) {
        System.out.println("yes");
    /*
        int[][] arr = new int[][] {{1, 2, 3}, {2, 13, 1}, {6, 5, 100}};
        int[][] newArr = scale(arr, 3);
        printMatrix(newArr);
        */
        // System.out.println(10 - Math.floor(Math.log10(5)));
        int[][] matrix = new int[][] {{6, 4, 2}, {1, -2, 8}, {1, 5, 7}};
        printMatrix(matrix);
        try {
            System.out.println("Determinant: " + determinant(matrix));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // int[][] m = new int[][] {{2, -3}, {5, 10}};
        //  printMatrix(m);
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
                for (int rowM = 1; rowM < cutMatrix.length; rowM++) {
                    cutMatrix[colM][rowM] = input[colM][rowM];
                }
            }
            for (colM = colM + 1; colM < input.length; colM++) { // after selected element
                for (int rowM = 1; rowM < cutMatrix.length; rowM++) {
                    cutMatrix[colM - 1][rowM] = input[colM][rowM];
                }
            }
            System.out.println("\n\n\n");
            printMatrix(cutMatrix); // this line causes it to spam newlines, comment out to stop the bug
            result += mult * determinant(scale(cutMatrix, elem));
            mult *= -1;
        }
        return result;
    }

    public static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[col][row] + " ");
            }
            System.out.println();
        }
    }
}
