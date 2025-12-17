import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int childA = sc.nextInt();
            int childB = sc.nextInt();

            boolean isParentStronger = false;

            // 強弱判定のロジック
            if (a > childA) {
                // 1つ目の番号が親のほうが大きい場合
                isParentStronger = true;
            } else if (a < childA) {
                // 1つ目の番号が子のほうが大きい場合
                isParentStronger = false;
            } else {
                // 1つ目の番号が同じなら、2つ目の番号が「小さい」ほうが強い
                if (b < childB) {
                    isParentStronger = true;
                } else {
                    isParentStronger = false;
                }
            }

            // 結果の出力
            if (isParentStronger) {
                System.out.println("High");
            } else {
                System.out.println("Low");
            }
        }

        sc.close();
    }
}