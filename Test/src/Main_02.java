import java.util.Scanner;

public class Main_02 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        int minCount = getMinCount(2*n,k);

        System.out.println(minCount+1);
    }

    private static int getMinCount(int n, int k) {
        if(n < k*2){
            return 0;
        }
        return 1 + getMinCount(n-k*2,k);
    }
}
