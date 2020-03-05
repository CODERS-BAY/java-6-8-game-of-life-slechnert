package com.codersbay;

import java.util.Arrays;
import java.util.Random;

public class GameOfLife {
    //Randomizer
    private static int[][] randomizeArray(int[][] array) {
        Random randy = new Random();
        for (int column = 1; column < array.length - 1; column++) {
            for (int ro = 1; ro < array.length - 1; ro++) {

                array[column][ro] = randy.nextInt(2);
            }
        }
        return array;
    }

    //Dead Cell
    public static boolean DeadCell(int[][] array, int x, int y) {
        if ((array[x][y] == 0) && ((array[x - 1][y - 1] + array[x - 1][y] + array[x - 1][y + 1]   //Dead Cell with 3 living neighbours
                + array[x][y - 1] + array[x][y + 1]
                + array[x + 1][y - 1] + array[x + 1][y] + array[x + 1][y + 1]) == 3)) {
            return true;
        } else {
            return false;
        }
    }

    //Lonely Cell
    public static boolean LonelyCell(int[][] array, int x, int y) {
        if (array[x][y] == 1 && (array[x - 1][y - 1] + array[x - 1][y] + array[x - 1][y + 1]   //Living cell &lt 2
                + array[x][y - 1] + array[x][y + 1]
                + array[x + 1][y - 1] + array[x + 1][y] + array[x + 1][y + 1]) < 2)
            return true;
        else {
            return false;
        }
    }

    //Happy Cell
    public static boolean HappyCell(int[][] array, int x, int y) {
        if (array[x][y] == 1 && (array[x - 1][y - 1] + array[x - 1][y] + array[x - 1][y + 1]   //Living with 2
                + array[x][y - 1] + array[x][y + 1]
                + array[x + 1][y - 1] + array[x + 1][y] + array[x + 1][y + 1]) == 2 ||
                (array[x][y] == 1 && (array[x - 1][y - 1] + array[x - 1][y] + array[x - 1][y + 1]   //livin with 3
                        + array[x][y - 1] + array[x][y + 1]
                        + array[x + 1][y - 1] + array[x + 1][y] + array[x + 1][y + 1]) == 3))
            return true;
        else {
            return false;
        }
    }

    public static void Output(int[][] array) {
        for (int column = 1; column < array.length - 1; column++) {
            for (int ro = 1; ro < array.length - 1; ro++) {
                System.out.printf("%3d", array[column][ro]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int fieldLength = 27;
        int[][] array = new int[fieldLength][fieldLength];
        int[][] arrayNew = new int[fieldLength][fieldLength];
        int ticker = 10;       //USE CTRL - F2

        randomizeArray(array);

        for (int i = 0; i < ticker; i++) {
            Output(array);
            }
            System.out.println("---------------------");

            for (int col = 1; col < fieldLength - 1; col++) {
                for (int row = 1; row < fieldLength - 1; row++) {


                    //for 1/1 to max-1/max-1, 8 surrounding fields
                    if (DeadCell(array, col, row) == true) {
                        arrayNew[col][row] = 1;
                    } else if (LonelyCell(array, col, row) == true) {
                        arrayNew[col][row] = 0;
                    } else if (HappyCell(array, col, row) == true) {
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

//
//(array[col][row] == 0 && (array[col - 1][row - 1] + array[col - 1][row] + array[col - 1][row + 1]   //Dead Cell with 3 living neighbours
//        + array[col][row - 1] + array[col][row + 1]
//        + array[col + 1][row - 1] + array[col + 1][row] + array[col + 1][row + 1]) == 3)




