import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<GuaiShow> guaiShows = new ArrayList<>(n);
        for (int i = 0; i < n;i++){
            guaiShows.add(new GuaiShow(scanner.nextInt()));
        }
        for(int i = 0;i < n;i++){
            guaiShows.get(i).money = scanner.nextInt();
        }
        int baohu = 0;
        int index = 0;
        int money = getMinMoney(guaiShows,index,baohu,0);
        System.out.println(money);

    }

    private static int getMinMoney(List<GuaiShow> guaiShows,int index,int baohu,int nowMoney) {
        int size = guaiShows.size();
        if(index >= size){
            return nowMoney;
        }
        GuaiShow show = guaiShows.get(index);
        if(show.wu > baohu){
            nowMoney += show.money;
            baohu += show.wu;
            return getMinMoney(guaiShows,index+1,baohu,nowMoney);
        }else {
            int i =nowMoney + show.money;
            int j = baohu + show.wu;
            return Math.min(getMinMoney(guaiShows,index+1,baohu,nowMoney),getMinMoney(guaiShows,index+1,j,i));
        }
    }

    public static class GuaiShow{
        int wu = 0;
        int money = 0;
        public GuaiShow(int wu) {
            this.wu = wu;
        }
    }
}
