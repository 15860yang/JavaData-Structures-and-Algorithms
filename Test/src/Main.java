import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Main main = Main.getInstance();
        main.printArray(main.createRandomSizeOfArray(10,10));
    }
    private static class Instance {
        public static Main main = new Main();
    }

    public static Main getInstance() {
        return Instance.main;
    }

    public int[] createRandomSizeOfArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = (int) (((maxValue + 1) * Math.random()) - (maxValue * Math.random()));
        }
        return arr;
    }
    public void printArray(int[] arr) {
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }
}
