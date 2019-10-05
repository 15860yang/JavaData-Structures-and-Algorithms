package leetcode;

public class Q27 {

    public int removeElement(int[] nums, int val) {
        int valSize = 0;
        int lastIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[lastIndex++] = nums[i];
            } else valSize++;
        }
        return nums.length - valSize;
    }


}
