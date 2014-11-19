package com.sudoku;

public class SudokuValidator {
    public static void main(String[] args) {
        isValid(new int[9][9]);
        isValid(null);
    }

    private static boolean isValid(int[][] input) {
        for(int i=0; i<input.length; i++) {
            for(int j=0; j<input.length; j++) {
                System.out.print(i/3*3 + j/3);
                System.out.print(',');
                System.out.print(i%3*3 + j%3);
                System.out.print('\t');
            }

            System.out.println("==============");
        }

        return true;
    }
}
