package sort;

/**
 * 堆排
 * 这里用的是大根堆
 */
public class BigHeapSort {
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int heapSize = arr.length;
        Base.swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            Base.swap(arr, 0, --heapSize);
        }
    }

    /**
     * 从下往上加，那么就是一级一级往上跳，达到大根堆的要求
     * @param arr
     * @param index
     */
    private static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            Base.swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    /**
     * 这里假设是改变堆顶的数，操作之后达到平衡（大根堆）
     * @param arr 表示堆的数组
     * @param index 堆中改变的项
     * @param heapSize 堆size
     */
    private static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left]
                    ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            Base.swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }
}
