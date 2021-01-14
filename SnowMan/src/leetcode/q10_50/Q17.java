package leetcode.q10_50;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q17 {

    public List<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        HashMap<Character, List<Character>> data = initData();
        StringBuilder stringBuilder = new StringBuilder();
        getResult(data, digits, 0, stringBuilder, result);
        return result;
    }

    private void getResult(HashMap<Character, List<Character>> sourceData, String digits, int index, StringBuilder nowString, ArrayList<String> result) {
        if (index == digits.length() - 1) {
            for (Character c : sourceData.get(digits.charAt(index))) {
                result.add(nowString.toString() + c);
            }
        } else {
            for (Character c : sourceData.get(digits.charAt(index))) {
                getResult(sourceData, digits, index + 1, nowString.append(c), result);
                nowString.deleteCharAt(nowString.length() - 1);
            }
        }
    }

    private HashMap<Character, List<Character>> initData() {
        HashMap<Character, List<Character>> map = new HashMap<>();
        ArrayList<Character> _2 = new ArrayList<>();
        _2.add('a');
        _2.add('b');
        _2.add('c');
        map.put('2', _2);
        ArrayList<Character> _3 = new ArrayList<>();
        _3.add('d');
        _3.add('e');
        _3.add('f');
        map.put('3', _3);
        ArrayList<Character> _4 = new ArrayList<>();
        _4.add('g');
        _4.add('h');
        _4.add('i');
        map.put('4', _4);
        ArrayList<Character> _5 = new ArrayList<>();
        _5.add('j');
        _5.add('k');
        _5.add('l');
        map.put('5', _5);
        ArrayList<Character> _6 = new ArrayList<>();
        _6.add('m');
        _6.add('n');
        _6.add('o');
        map.put('6', _6);
        ArrayList<Character> _7 = new ArrayList<>();
        _7.add('p');
        _7.add('q');
        _7.add('r');
        _7.add('s');
        map.put('7', _7);
        ArrayList<Character> _8 = new ArrayList<>();
        _8.add('t');
        _8.add('u');
        _8.add('v');
        map.put('8', _8);
        ArrayList<Character> _9 = new ArrayList<>();
        _9.add('w');
        _9.add('x');
        _9.add('y');
        _9.add('z');
        map.put('9', _9);
        return map;
    }

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length);
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;
        int low = start;
        int now = low + 1;
        int higher = end;
        while (now < higher) {
            if (arr[now] > arr[low]) swap(arr, now, --higher);
            else if (arr[now] < arr[low]) swap(arr, low++, now++);
            else now++;
        }
        quickSort(arr, start, low);
        quickSort(arr, higher, end);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
