public class Main {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 8, 4, 3, 9, 7, 6, 2, 5, 0};
        QuickSort.quickSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        BubbleSort.bubbleSort(arr);
        System.out.println();
        for (int i : arr) {
            System.out.print(i + " ");
        }

    }

}
