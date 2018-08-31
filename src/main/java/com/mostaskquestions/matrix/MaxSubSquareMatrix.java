package com.mostaskquestions.matrix;

/**
 * @author Jitendra Kumar : 31/8/18
 */
public class MaxSubSquareMatrix {
    private static void printMaxSubMatrix(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] result = new int[row][column];
        int rowMax = 0;
        int columnMax = 0;
        int resultMax = 0;

        /**
         * initialise all row
         */
        for (int i = 0 ; i < row ; i++)
            result[i][0] = matrix[i][0];

        /**
         * initialise all columns
         */
        for (int i = 0 ; i < column ; i++)
            result[0][i] = matrix[0][i];

        /**
         * If value of matrix[i][j] = 1 then get the minimum value from result[i-1][j-1], result[i][j-1] and result[i-1][j]
         */
        for (int i = 1 ; i < row ; i++) {
            for (int j = 1 ; j < column ; j++) {
                if (matrix[i][j] == 1) {
                    result[i][j] = Math.min(result[i-1][j-1], Math.min(result[i][j-1], result[i-1][j])) +1;
                } else result[i][j] = 0;
            }
        }

        /**
         * Find the row, column and max size of matrix
         */
        for (int i = 0 ; i < row ; i++) {
            for (int j = 0 ; j < column ; j++) {
                if (resultMax <= result[i][j]) {
                    resultMax = result[i][j];
                    rowMax = i;
                    columnMax = j;
                }
            }
        }

        for (int i = rowMax ; i > rowMax - resultMax ; i--) {
            for (int j = columnMax ; j > columnMax - resultMax ; j--) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 0, 1, 0},
                {0, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1},
                {0, 1, 1, 1, 1}
        };
        printMaxSubMatrix(matrix);
        System.out.println();
        int matrix1[][] =  {{0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}};
        printMaxSubMatrix(matrix1);
        System.out.println();
        int[][] matrix2 = {
                {1, 0, 0, 1, 0, 0},
                {0, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {0, 1, 1, 0, 1, 1},
                {0, 1, 1, 0, 1, 0}
        };
        printMaxSubMatrix(matrix2);
    }
}
