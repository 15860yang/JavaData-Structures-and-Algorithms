package Main;

import leetcode.q51_100.Q80;

import java.util.List;

public class Main {
    public static boolean debug = false;

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,2,2,3};
        System.out.println(new Q80().removeDuplicates(arr));
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + "  ");
        }
        System.out.println();
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(ints[j] + "\t");
            }
            System.out.println();
        }
    }

    private static void printMatrix(List<List<Integer>> matrix) {
        for (List list : matrix) {
            System.out.println(list);
        }
    }

    private static void printList(List<Integer> list) {
        for (int i : list) {
            System.out.print(i + "  ");
        }
        System.out.println();
    }
}
