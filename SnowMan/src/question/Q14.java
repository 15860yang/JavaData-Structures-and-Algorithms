package question;

/**
 * 问题：一个整型数组，比如【1,2,100,4】 代表一个顺序的纸牌，有两个玩家，玩家一和玩家二
 *      规定：每个玩家每次从左或者从右只能拿一张牌，玩家一先拿，当拿完牌之后，谁手中的牌面之和大者为赢家
 *  为玩家指定策略，使得该玩家赢的可能性最大
 */
public class Q14 {

    public static int[] Solution(int[] arr){
        int[] res = new int[]{0,0};
        getResult_baoli(arr,0,arr.length-1);
        return null;
    }

    private static void getResult_baoli(int[] arr,int start, int end) {

    }

}
