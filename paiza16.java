import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 入力
        String S = sc.nextLine();//ルール
        String T = sc.nextLine();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < T.length(); i++) {
            char c = T.charAt(i);

            // アルファベットの位置（a=0, b=1, ...）
            int index = Character.toLowerCase(c) - 'a';

            // Sの該当文字
            char ruleChar = S.charAt(index);

            // 大文字・小文字を合わせる
            if (Character.isUpperCase(ruleChar)) {
                result.append(Character.toUpperCase(c));
            } else {
                result.append(Character.toLowerCase(c));
            }
        }

        // 出力
        System.out.println(result.toString());
    }
}
