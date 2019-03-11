public class KMP {

    public static void main(String[] args) {
        String fArr = "asffdsfgdfgsas";
        String sArr = "asffd";
        System.out.println(getIndexOf(fArr.toCharArray(),sArr.toCharArray()));
    }

    public static int getIndexOf(char[] fatherArr, char[] sonArr) {
        final int fArrLength = fatherArr.length;
        final int sArrLength = sonArr.length;
        int i1 = 0, i2 = 0;
        int[] nextArr = getNextArr(sonArr);
        while (i1 < fArrLength && i2 < sArrLength) {
            if (fatherArr[i1] == sonArr[i2]) {
                i1++;
                i2++;
            }
            //后面这两个if—else是为了在不匹配的情况下把 子串的值往后推，
            else if (nextArr[i2] == -1) {
                //这里的情况是  子串已经跳到了最前  0号位置，此时已经不能往前跳，所以母串加一
                i1++;
            } else {
                //子串往前跳，继续比较
                i2 = nextArr[i2];
            }
        }
        return i2 == sArrLength ? i1 - i2 : -1;
    }

    private static int[] getNextArr(char[] arr) {
        if (arr == null || arr.length == 0) return null;
        if (arr.length == 1) return new int[]{-1};
        int[] nextArr = new int[arr.length];
        //先将前两个写出来
        nextArr[0] = -1;
        nextArr[1] = 0;
        int length = arr.length;
        //然后根据前2个推后面的,这里我已经确定next数组前2个的数，现在要做的就是依次确定 第三个，第四个，第五个。。。
        int i = 2;
        int cn = 0;
        while (i < length) {
            if (arr[i - 1] == arr[cn]) {
                nextArr[i++] = ++cn;
            } else if (cn > 0) {
                //注意，这里是往前推的主要逻辑
                cn = nextArr[cn];
            } else {
                nextArr[i++] = 0;
            }
        }
        return nextArr;
    }


}
