package sort;

public class QuickSort_SnowMan {

    public void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length);
    }

    private void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int low = start;
        int now = start + 1;
        int higher = end;
        while (now < higher) {
            int a = arr[now] - arr[low];
            if (a > 0) Base.swap(arr, now, --higher);
            else if (a < 0) Base.swap(arr, low++, now++);
            else now++;
        }
        quickSort(arr, start, low);
        quickSort(arr, higher, end);
    }
}
