package cn.pys;

public class Leetcode {
    public static void main(String[] args) {
        System.out.println(new Leetcode().isMatch("abcd", "d*"));
        //System.out.println(new Leetcode().isMatch2("mississippi", "mis*is*p*."));
        System.out.println(new Leetcode().isMatch2("abcd", "d*"));

    }

    public boolean isMatch(String s, String p) {
        int row = s.length();
        int col = p.length();
        boolean[][] f = new boolean[row + 1][col + 1];
        // 空字符串匹配空的正则表达式  aaaaabc  a*bc   c*a*bc
        f[0][0] = true;
        // 匹配第 1 行，空字符串与正则表达式串
        for (int i = 1; i <= col; i++) {
            if (p.charAt(i - 1) == '*') {
                // 匹配符第一个字符串按照题意不可能出现 *，直接跳出循环
                if (i == 1) continue;
                f[0][i] = f[0][i - 2];
            }
        }
        // 字符串 i=0 从匹配空串开始
        for (int i = 1; i <= row; i++) {
            char sch = s.charAt(i - 1);
            for (int j = 1; j <= col; j++) {
                char pch = p.charAt(j - 1);
                if (sch == pch || pch == '.') {
                    // 字符相同就匹配两个串都回退一个字符的匹配结果
                    f[i][j] = f[i - 1][j - 1];
                } else if (pch == '*') {
                    // 匹配符第一个字符串按照题意不可能出现 *，直接跳出循环
                    if (j == 1) continue;
                    // 先匹配同行，第 j - 2 列
                    if (f[i][j - 2]) {
                        // * 前面的字符出现0次
                        f[i][j] = true;
                    } else {
                        char prev = p.charAt(j - 2);
                        if (prev == sch || prev == '.') {
                            // * 前面的字符出现多次
                            f[i][j] = f[i - 1][j];
                        }
                    }
                }
            }
        }
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= col; j++) {
                System.out.print(f[i][j]?"1 ":"0 ");
            }
            System.out.println();
        }
        return f[row][col];
    }

    public boolean isMatch2(String s, String p) {
        int row = s.length();
        int col = p.length();
        boolean[][] f = new boolean[2][col + 1];
        // 空字符串匹配空的正则表达式  aaaaabc  a*bc   c*a*bc
        f[0][0] = true;
        // 匹配第 1 行，空字符串与正则表达式串
        for (int i = 1; i <= col; i++) {
            if (p.charAt(i - 1) == '*') {
                // 匹配符第一个字符串按照题意不可能出现 *，直接跳出循环
                if (i == 1) continue;
                f[0][i] = f[0][i - 2];
            }
        }
        for (int j = 0; j <= col; j++) {
            System.out.print(f[0][j]?"1 ":"0 ");
        }
        System.out.println();

        // 字符串 i=0 从匹配空串开始
        for (int i = 1; i <= row; i++) {
            char sch = s.charAt(i - 1);
            for (int j = 1; j <= col; j++) {
                char pch = p.charAt(j - 1);
                if (sch == pch || pch == '.') {
                    // 字符相同就匹配两个串都回退一个字符的匹配结果
                    f[i % 2][j] = f[(i - 1) % 2][j - 1];
                } else if (pch == '*') {
                    // 匹配符第一个字符串按照题意不可能出现 *，直接跳出循环
                    if (j == 1) continue;
                    // 先匹配同行，第 j - 2 列
                    if (f[i % 2][j - 2]) {
                        // * 前面的字符出现0次
                        f[i % 2][j] = true;
                    } else {
                        char prev = p.charAt(j - 2);
                        if (prev == sch || prev == '.') {
                            // * 前面的字符出现多次
                            f[i % 2][j] = f[(i - 1) % 2][j];
                        }
                    }
                }
            }
            // 重置前一行数据
            for (int j = 1; j <= col; j++) {
                f[(i - 1) % 2][j] = false;
            }

            for (int j = 0; j <= col; j++) {
                System.out.print(f[i%2][j]?"1 ":"0 ");
            }
            System.out.println();
        }
        return f[row % 2][col];
    }
}
