package com.codersbay;

import java.util.Arrays;
import java.util.Random;

public class GameOfLife {

    private static int[][] randomizeArray(int[][] array) {
        Random randy = new Random();
        for (int column = 1; column < array.length - 1; column++) {
            for (int ro = 1; ro < array.length - 1; ro++) {

                array[column][ro] = randy.nextInt(2);
            }
        }
        return array;
    }


    public static void main(String[] args) {
        int fieldLength = 10;
        int[][] array = new int[fieldLength][fieldLength];
        int[][] arrayNew = new int[fieldLength][fieldLength];
        int ticker = 10;       //USE CTRL - F2

        randomizeArray(array);

        for (int i = 0; i < ticker; i++) {
            //OUTPUT
            for (int column = 1; column < array.length - 1; column++) {
                for (int ro = 1; ro < array.length - 1; ro++) {
                    System.out.printf("%3d", array[column][ro]);
                }
                System.out.println();
            }
            System.out.println("---------------------");

            for (int col = 1; col < fieldLength - 1; col++) {
                for (int row = 1; row < fieldLength - 1; row++) {


                    //for 1/1 to max-1/max-1, 8 surrounding fields
                    if (array[col][row] == 0 && (array[col - 1][row - 1] + array[col - 1][row] + array[col - 1][row + 1]   //Dead Cell with 3 living neighbours
                            + array[col][row - 1] + array[col][row + 1]
                            + array[col + 1][row - 1] + array[col + 1][row] + array[col + 1][row + 1]) == 3) {
                        arrayNew[col][row] = 1;
                    } else if (array[col][row] == 1 && (array[col - 1][row - 1] + array[col - 1][row] + array[col - 1][row + 1]   //Living cell &lt 2
                            + array[col][row - 1] + array[col][row + 1]
                            + array[col + 1][row - 1] + array[col + 1][row] + array[col + 1][row + 1]) < 2) {
                        arrayNew[col][row] = 0;
                    } else if (array[col][row] == 1 && (array[col - 1][row - 1] + array[col - 1][row] + array[col - 1][row + 1]   //Living with 2
                            + array[col][row - 1] + array[col][row + 1]
                            + array[col + 1][row - 1] + array[col + 1][row] + array[col + 1][row + 1]) == 2 ||
                            (array[col][row] == 1 && (array[col - 1][row - 1] + array[col - 1][row] + array[col - 1][row + 1]   //livin with 3
                                    + array[col][row - 1] + array[col][row + 1]
                                    + array[col + 1][row - 1] + array[col + 1][row] + array[col + 1][row + 1]) == 3)) {
                        arrayNew[col][row] = 1;
                    } else {
                        arrayNew[col][row] = 0;
                    }
                }
            }
            array = Arrays.stream(arrayNew).map(int[]::clone).toArray(int[][]::new);

        }

    }
}





