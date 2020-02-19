package com.codersbay;

import java.util.Arrays;

public class GameOfLife {
    public static void main(String[] args) {
        int fieldLength = 12;
        int[][] array = new int[fieldLength][fieldLength];
        int[][] arrayNew = new int[fieldLength][fieldLength];
        int ticker = 3;
        array[3][3] = 1;
        array[2][3] = 1;
        array[1][3] = 1;
        array[2][2] = 1;

for(int i = 0; i < ticker; i++){
        for (int col = 1; col < fieldLength - 1; col++) {
            for (int row = 1; row < fieldLength - 1; row++) {


                //for 1/1 to max-1/max-1, 8 surrounding fields
                if (array[col][row] == 0 && (array[col - 1][row - 1] + array[col - 1][row] + array[col - 1][row + 1]   //Dead Cell with 3 living neighbours
                        + array[col][row - 1] + array[col][row + 1]
                        + array[col - 1][row - 1] + array[col - 1][row] + array[col - 1][row + 1]) == 3) {
                    arrayNew[col][row] = 1;
                } else if (array[col][row] == 1 && (array[col - 1][row - 1] + array[col - 1][row] + array[col - 1][row + 1]   //Living Cell Cell with %lt 2
                        + array[col][row - 1] + array[col][row + 1]
                        + array[col - 1][row - 1] + array[col - 1][row] + array[col - 1][row + 1]) < 2) {
                    arrayNew[col][row] = 0;
                } else if (array[col][row] == 1 && (array[col - 1][row - 1] + array[col - 1][row] + array[col - 1][row + 1]   //Living Cell Cell with 2
                        + array[col][row - 1] + array[col][row + 1]
                        + array[col - 1][row - 1] + array[col - 1][row] + array[col - 1][row + 1]) == 2 ||
                        (array[col][row] == 1 && (array[col - 1][row - 1] + array[col - 1][row] + array[col - 1][row + 1]   //Living Cell Cell with 3
                                + array[col][row - 1] + array[col][row + 1]
                                + array[col - 1][row - 1] + array[col - 1][row] + array[col - 1][row + 1]) == 3)) {
                    arrayNew[col][row] = 1;
                } else {
                    arrayNew[col][row] = 0;
                }
            }}
            array = arrayNew;

            //OUTPUT
            for (int column = 1; column < array.length-1; column++) {
                for (int ro = 1; ro < array.length-1; ro++) {
                    System.out.printf("%3d", array[column][ro]);
                }
                System.out.println();
            }
            System.out.println("---------");}

        }

    }


