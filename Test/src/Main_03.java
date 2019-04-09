import java.util.ArrayList;
import java.util.Scanner;

public class Main_03 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int s = in.nextInt();
        ArrayList<Integer> arrays = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            arrays.add(in.nextInt());
        }
        arrays.sort((o1, o2) -> o2 - o1);
        int i = 0;
        if (s < 0) {
            System.out.println(arrays.get(0));
            return;
        }
        for (i = 0; i < n - 1; i++) {
            int t = arrays.get(i);
            //减去当前的与下一个的差距乘以前面的长度
            int t1 = arrays.get(i+1);
            int m = s / (i+1);
            if(m > t- t1){
                s = s - ((t - arrays.get(i + 1)) * (i + 1));
            }else if(m == t - t1){
                System.out.println(t1);
                return;
            }else {
                System.out.println(t1 + (t-t1 - m ) + 1);
                return;
            }

            //如果s被减到小于0，那么最低的可以取到i   否则取到i+1
//            if (s <= 0) {
//                //如果小于0表示剪过头了
//                s = s * -1;
//                int h = s / (i + 1);
//                int g = s % (i + 1);
//                System.out.println(arrays.get(i + 1) +h *(i +1) + g -1);
//                return;
//            }
        }
        if (s > arrays.get(n - 1)) {
            System.out.println(-1);
        } else {
            System.out.println(arrays.get(n - 1) - s);
        }
    }
}
