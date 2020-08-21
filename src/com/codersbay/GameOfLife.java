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

    public static int getLivingNeighbourCount(int[][] array, int x, int y) {
        return ((array[x - 1][y - 1] + array[x - 1][y] + array[x - 1][y + 1]
                + array[x][y - 1] + array[x][y + 1]
                + array[x + 1][y - 1] + array[x + 1][y] + array[x + 1][y + 1]));
    }

    //Dead Cell
    public static boolean deadCell(int[][] array, int x, int y) {
        return ((array[x][y] == 0) && (getLivingNeighbourCount(array, x, y) == 3));
    }

    //Lonely Cell
    public static boolean lonelyCell(int[][] array, int x, int y) {
        return (array[x][y] == 1 && (getLivingNeighbourCount(array, x, y)) < 2);
    }

    //Happy Cell
    public static boolean happyCell(int[][] array, int x, int y) {
        return (array[x][y] == 1 && (getLivingNeighbourCount(array, x, y)) == 2 ||
                (array[x][y] == 1 && (getLivingNeighbourCount(array, x, y)) == 3));
    }

    public static void output(int[][] array) {
        for (int column = 1; column < array.length - 1; column++) {
            for (int ro = 1; ro < array.length - 1; ro++) {
                System.out.printf("%3d", array[column][ro]);
            }
            System.out.println();
        }
    }

    public static void gameOfLife(int[][] array, int[][] arrayNew, int playfield, int generations) {
        for (int i = 0; i < generations; i++) {
            output(array);

            System.out.println("---------------------");

            for (int col = 1; col < playfield - 1; col++) {
                for (int row = 1; row < playfield - 1; row++) {


                    //for 1/1 to max-1/max-1, 8 surrounding fields
                    if (deadCell(array, col, row)) {
                        arrayNew[col][row] = 1;
                    } else if (lonelyCell(array, col, row)) {
                        arrayNew[col][row] = 0;
                    } else if (happyCell(array, col, row)) {
                        arrayNew[col][row] = 1;
                    } else {
                        arrayNew[col][row] = 0;
                    }
                }
            }
            array = Arrays.stream(arrayNew).map(int[]::clone).toArray(int[][]::new);
        }

    }


    public static void main(String[] args) {
        int fieldLength = 100;
        int[][] array = new int[fieldLength][fieldLength];
        int[][] arrayNew = new int[fieldLength][fieldLength];
        int ticker = 10;       //USE CTRL - F2
        randomizeArray(array);
        gameOfLife(array, arrayNew, fieldLength, ticker);
    }

}



