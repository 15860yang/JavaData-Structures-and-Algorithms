public class Q12 {


    public static void main(String[] args) {
        System.out.println(new Q12().maxProfit(new int[]{1,4}));
    }
    /**
     *  给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
     注意你不能在买入股票前卖出股票。
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        return getMaxProfit(prices,0,0,false);
    }

    public static int getMaxProfit(int[] prices,int index,int nowMoney,boolean isBuy){
        if(index >= prices.length-1){
            return isBuy ? nowMoney + prices[index] : nowMoney;
        }
        if(isBuy){
            //如果已经买了，那么最大的利润等于卖出或者不卖出的价格中最大的
            return Math.max(getMaxProfit(prices,index+1,nowMoney+prices[index],!isBuy),
                    getMaxProfit(prices,index+1,nowMoney,isBuy));
        }else {
            //如果没买，那么就等于买到和没买到的最大利润
            return Math.max(getMaxProfit(prices,index+1,nowMoney-prices[index],!isBuy),
                    getMaxProfit(prices,index+1,nowMoney,isBuy));
        }
    }
}
