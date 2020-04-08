package tech.hiyinyougen.demo;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author yinyg
 * @date 2019/4/22
 */
public class HelloWorld {
    private static final Map<String, String> map = new HashMap<String, String>() {
        {
            put("0", "0");
            put("1", "1");
            put("2", "2");
            put("3", "3");
            put("4", "4");
            put("5", "5");
            put("6", "6");
            put("7", "7");
            put("8", "8");
            put("9", "9");
            put("10", "A");
            put("11", "B");
            put("12", "C");
            put("13", "D");
            put("14", "E");
            put("15", "F");
        }
    };

    public static void main(String[] args) {
        String hex = toHex(12500);
        if (hex.equalsIgnoreCase("30D4")) {
            System.out.println("测试通过");
        } else {
            System.out.println("测试失败");
        }
    }

    static String toHex(int n) {
        StringBuilder result = new StringBuilder();
        int num = n;
        Deque<String> stsck = new LinkedList<>();
        do {
            stsck.push(map.get(String.valueOf(num % 16)));
            num = num / 16;
        } while (num > 0);
        while (stsck.size() > 0) {
            result.append(stsck.pop());
        }
        return result.toString();
    }
}
