package sort;

/**
 * 快排
 */
public class QuickSort {
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //判空之后进入正式的排序方法
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int l, int r) {
        if (r > l) {
            //在这里将随机位置与最后一位置的数交换，就是为了避免数据不均匀的问题而导致算法效率降低
            Base.swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
            //传入需要排序的数组和需要排序的左右边界，因为快排每次排序之后会使数组中此次待排序段最后的数据处于正确的位置
            //而这个变量可能有多个相同的值，所以该方法返回此次排序之后中间相同部分的左右边界所在数组
            int[] p = partition(arr, l, r);
            quickSort(arr, l, p[0] - 1);
            quickSort(arr, p[1] + 1, r);
        }
    }

    /**
     * 每次排序的核心方法
     *
     * @param arr 待排序数组
     * @param l   待排序数组的左边边界
     * @param r   待排序数组的右边边界
     * @return 正确位置的左右边界
     */
    private static int[] partition(int[] arr, int l, int r) {
        //l 为位置部分的左边界
        int less = l - 1;//小于中介数的左边界
        int more = r;//大于中介数的右边界

        //这里拿的是最右边的数作为 中介数
        while (l < more) {
            //如果左边小于中介数，那就交换最左边两个数，也就是小部分与位置部分的相邻位置交换，小部分位置的边界右移
            if (arr[l] < arr[r]) {
                Base.swap(arr, ++less, l++);
            } else if (arr[l] > arr[r]) {
                Base.swap(arr, --more, l);
            } else {
                l++;
            }
        }
        Base.swap(arr, more, r);
        return new int[]{less + 1, more};
    }
}
