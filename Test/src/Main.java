import java.io.InputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

//    输入第一行是一个整数n(1≤n≤105）表示家族关系树中成员数量。
//            第二行有n个数，中间用空格隔开，第i个数fi表示i号成员的父亲为fi，如果fi为0，表示不知道i号成员父亲是谁。
//            第三行包含一个整数m（1≤m≤105） ,表示询问的数量。
//            接下来有m行，每行有两个正整数x，k，中间用空格隔开，表示询问x成员的k表兄弟有多少个。
//
//
//
//
//
//
//            战乱年代，整个世界各个军阀的兵团混战，你是PZ军团的战略参谋，你手下有n（保证为3的倍数）个士兵，第i个士兵的物理攻击数值为Ai，
//            魔法攻击数值为Bi，你需要将这些士兵三等分为三个连，第一个连需要去物理空间参加物理对抗战争，战斗力估值W1为士兵的物理攻击数值之和；
//            第二个连需要去魔法空间参加魔法对抗战争，战斗力估值W2为士兵的魔法攻击数值之和；第三个连需要去虚幻空间参加物理魔法兼备的综合对抗战争，
//            战斗力估值W3为所有士兵的物理攻击数值、魔法攻击数值之和除以2。你希望W1+W2+W3最大，这样才最有可能胜利。
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Solider> maxA = new ArrayList<>(n);
//        ArrayList<Solider> maxB = new ArrayList<>(n);
//        ArrayList<Solider> maxA_B = new ArrayList<>(n);

        ArrayList<Solider> w1 = new ArrayList<>(n/3);
        ArrayList<Solider> w2 = new ArrayList<>(n/3);
        ArrayList<Solider> w3 = new ArrayList<>(n/3);
        for (int i = 0;i < n;i ++){
            Solider solider = new Solider();
            solider.a = in.nextInt();
            maxA.add(solider);
        }
        for (int i = 0;i < n;i ++){
            maxA.get(i).b = in.nextInt();
        }
//        maxB.addAll(maxA);
//        maxA_B.addAll(maxA);
//        maxA.sort((o1, o2) -> o2.a - o1.a);
//        maxB.sort((o1, o2) -> o2.b - o1.b);
//        maxA_B.sort((o1, o2) -> o2.a + o2.b - o1.a - o1.b);
//        int an = 0,bn = 0,abn = 0;
        Solider solider;
        int a ,b,ab;
        int w1n = 0,w2n= 0,w3n = 0;
        for (int i = 0;i< n;i++){
            solider = maxA.get(i);
            a = solider.a;
            b = solider.b;
            ab = solider.a + solider.b;

            if(w1n < n/3){
                if(a > b && a > ab/2){
                    w1.add(solider);
                    w1n++;
                    continue;
                }
            }
            if(w2n < n/3){
                if( b > ab/2){
                    w2.add(solider);
                    w2n++;
                    continue;
                }
            }
            if(w3n < n/3){
                w3.add(solider);
                continue;
            }
        }
        float max = 0;
        for(int i = 0; i< n/3;i++){
            max = max + w1.get(i).a + w2.get(i).b + (float) (w3.get(i).a+ w3.get(i).b)/2;
        }
        max = max * 1000;
        if(max%10 > 4){
            max+=10;
        }
        max/=10;
        System.out.println((float) max/100);

    }


    public static class Solider{
        int a = 0;
        int b = 0;
        boolean used = false;
    }




























//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int sum = 0;
//        for (int i = 0;i < n;i++){
//            int s = scanner.nextInt();
//            if( s < 5900){
//                sum++;
//            }
//        }
//        System.out.println("---------"+sum+"------");
//        float res = (float) sum/n;
//        res *= 100000;
//        if(res%10 > 4){
//            res+=10;
//        }
//        int r = (int) (res / 10);
//        float result = ((float)r/100);
//        System.out.print( result);
//        if(result == 0) {
//            System.out.println("00.00%");
//        }if((result*10)%1 == 0){
//            System.out.println("0%");
//        }else {
//            System.out.println("%");
//        }
//    }
}
