import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // パイザ記法の数式 E を取得
        if (!sc.hasNextLine()) return;
        String e = sc.nextLine();
        
        // 1. "+" 記号で数式を分割して各項（整数）を取り出す
        // splitの中で "+" は正規表現の予約語なので "\\" でエスケープします
        String[] terms = e.split("\\+");
        
        long totalSum = 0;
        
        // 2. 各項を数値に変換して合計する
        for (String term : terms) {
            int value = 0;
            
            // 文字列を一文字ずつ確認
            for (int i = 0; i < term.length(); i++) {
                char c = term.charAt(i);
                if (c == '<') {
                    // "<" は10の位を表す
                    value += 10;
                } else if (c == '/') {
                    // "/" は1の位を表す
                    value += 1;
                }
            }
            totalSum += value;
        }
        
        // 3. 結果を出力
        System.out.println(totalSum);
        
        sc.close();
    }
}