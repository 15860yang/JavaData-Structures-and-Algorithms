package sort;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        int i = 0;
        int n = arr.length - 1;
        for (i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    Base.swap(arr, j, j + 1);
                }
            }
        }
    }
}
