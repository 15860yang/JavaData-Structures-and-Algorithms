package money;


import java.io.*;
import java.util.HashMap;

public class FileProcess {

    public static HashMap<Data, Integer> initFile(String filePath, Data[] base) {
        return initFile(filePath, base, 0);
    }

    public static HashMap<Data, Integer> initFile(String filePath, Data[] base, int ignoreRows) {
        File res;
        HashMap<Data, Integer> result = new HashMap<>();
        res = new File(filePath);
        if (res == null) {
            System.out.println("数据地址无效");
        } else {
            try {
                FileReader reader = new FileReader(res);
                BufferedReader bReader = new BufferedReader(reader);
                for (int i = 0; i < ignoreRows; i++) bReader.readLine();
                char[] buffer = new char[1024 * 10];
                String plus = "";
                int l;
                while ((l = bReader.read(buffer)) != -1) {
                    String value = String.valueOf(buffer, 0, l);
                    char c = value.charAt(value.length() - 1);
                    String[] strings = (plus + value).trim().split(" ");
                    if (c == ' ') {
                        plus = "";
                    } else {
                        plus = strings[strings.length - 1];
                    }
                    for (int i = 1; i < strings.length - 1; i++) {
                        double i1 = Double.parseDouble(strings[i]);
                        dealWith(i1, base, result);
                    }
                }
                if (plus == null || plus.length() == 0) {
                    double i1 = Double.parseDouble(plus);
                    dealWith(i1, base, result);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    private static void dealWith(double i1, Data[] base, HashMap<Data, Integer> result) {
        for (Data data : base) {
            if (i1 > data.left && i1 <= data.right) {
                result.put(data, result.getOrDefault(data, 0) + 1);
                break;
            }
        }
    }
}
