public class Solutions {
    public static void main(String[] args) {
        System.out.println("yes");
        int[][] arr = new int[][] {{1, 2, 3}, {2, 13, 1}, {6, 5, 100}};
        int[][] newArr = scale(arr, 3);
        printMatrix(newArr);
    }


    public static int[][] scale(int[][] input, int factor) {
        int[][] output = new int[input.length][input[0].length];
        for (int col = 0; col < input.length; col++) {
            for (int row = 0; row < input[0].length; row++)
                output[col][row] = input[col][row] * factor;
        }
        return output;
    }

    public static void printMatrix(int[][] matrix) {
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix[0].length; row++) {
                System.out.print(matrix[col][row]);
                for (int a = 0; a < 10 - Math.floor(Math.log10(matrix[col][row])); a++)
                    System.out.print(" ");
            }
            System.out.print("\n");
        }
    }
}
