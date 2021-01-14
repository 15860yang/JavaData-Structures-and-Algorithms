package leetcode.q10_50;

public class Q28 {

    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        int index = -1;
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (equal(haystack.toCharArray(), i, needle.toCharArray())) {
                return i;
            }
        }
        return index;
    }

    public static boolean equal(char[] source, int index, char[] arr) {
        int length = index + arr.length;
        if (length > source.length) return false;
        for (int i = index; i < length; i++) {
            if (source[i] != arr[i - index]) return false;
        }
        return true;
    }


}
