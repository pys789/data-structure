package cn.pys.list;

import java.util.HashMap;
import java.util.Stack;

public class Num20 {

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("(})"));
        System.out.println(isValid("([])"));
    }

    private static HashMap<Character, Character> map = new HashMap<>();
    static {
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');

    }

    private static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if (s == null || "".equals(s))
            return true;
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()){
                    return false;
                }
                Character value = map.get(stack.pop());
                if (c != value) {
                    return false;
                }
            }
        }
        return stack.isEmpty();

    }

}
