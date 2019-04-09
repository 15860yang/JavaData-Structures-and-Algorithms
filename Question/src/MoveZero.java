public class MoveZero {

    /**
     *
     *  给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     *
     * @param nums
     */

    public void moveZeroes(int[] nums) {
        int length = nums.length;
        int zeroStart = -1;
        int zeroEnd = -1;
        for (int i = 0;i < length; i++){
            int a = nums[i];
            if(a == 0){
                if(zeroStart == -1){
                    zeroStart = i;//这里为了记录第一个0的位置
                }
                zeroEnd = i;//如果是0 更新0末端位置
            }else {
                if(zeroStart == -1){
                    //此时0的开始还是-1  表示还没交换过，也就是在前面还没发现过0
                    continue;
                }else {
                    nums[zeroStart] = nums[i];
                    nums[i] = 0;
                    zeroEnd = i;
                    zeroStart++;
                }
            }
            if(zeroEnd > i + 1){
                i = zeroEnd;
            }
        }
    }

}
