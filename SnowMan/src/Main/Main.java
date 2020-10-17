package Main;

import leetcode.Q40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        Arrays.sort(candidates);
        printArray(candidates);
        Q40 q40 = new Q40();
        System.out.println("结果如下：");
        printMatrix(q40.combinationSum2(candidates, target));
    }

    private static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + "  ");
        }
        System.out.println();
    }


    private static void printMatrix(List<List<Integer>> matrix) {
        for (List list : matrix) {
            System.out.println(list);
        }
    }
}
