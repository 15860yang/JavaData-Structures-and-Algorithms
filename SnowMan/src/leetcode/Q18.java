package leetcode;

import java.util.*;

public class Q18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        quickSort(nums);
        HashSet<String> tempResult = new HashSet<>();
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int nowTarget = target - nums[i] - nums[j];
                int start = j + 1;
                int end = nums.length - 1;
                while (start < end) {
                    int a = nowTarget - nums[start] - nums[end];
                    if (a > 0) start++;
                    else if (a < 0) end--;
                    else {
                        tempResult.add(nums[i] + "#" + nums[j] + "#" + nums[start] + "#" + nums[end]);
                        start++;
                        end--;
                    }
                }
            }
        }
        Iterator<String> iterator = tempResult.iterator();
        while (iterator.hasNext()) {
            String[] strings = iterator.next().split("#");
            List<Integer> integers = new ArrayList<>();
            integers.add(Integer.parseInt(strings[0]));
            integers.add(Integer.parseInt(strings[1]));
            integers.add(Integer.parseInt(strings[2]));
            integers.add(Integer.parseInt(strings[3]));
            result.add(integers);
        }
        return result;
    }

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
            if (a > 0) swap(arr, now, --higher);
            else if (a < 0) swap(arr, low++, now++);
            else now++;
        }
        quickSort(arr, start, low);
        quickSort(arr, higher, end);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
