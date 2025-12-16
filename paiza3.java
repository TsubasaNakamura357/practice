import java.util.Scanner;

public class ShiritoriChecker {

    public static void main(String[] args) {
        // 標準入力からの読み込みにはScannerを使用
        Scanner scanner = new Scanner(System.in);

        // 1行目の N (単語の数) を読み込む
        int N = scanner.nextInt();
        
        // nextInt()は改行を消費しないため、ここで空の行を消費するか、
        // 次の nextLine() で対応する (今回は次の nextLine() で対応するため、特に処理不要)

        // 単語を格納する配列 (String[] s = new String[N];) を使っても良いが、
        // 単語を読み込みながらチェックを行う方がメモリ効率が良い
        
        String[] words = new String[N];
        
        // 2行目以降の N 個の単語 s_1, s_2, ... s_N を読み込む
        for (int i = 0; i < N; i++) {
            words[i] = scanner.next(); // next() はスペースまたは改行までを読み込む
        }

        scanner.close();

        // しりとり判定処理
        
        // N個の単語があるとき、チェックするペアは N-1 組 (i=0 と i=1, i=1 と i=2, ..., i=N-2 と i=N-1)
        for (int i = 0; i < N - 1; i++) {
            String currentWord = words[i];
            String nextWord = words[i + 1];

            // 1. i番目の単語の末尾の文字を取得
            // String.charAt(index) を使用。末尾のインデックスは length() - 1
            char endChar = currentWord.charAt(currentWord.length() - 1);

            // 2. i+1番目の単語の先頭の文字を取得
            char startChar = nextWord.charAt(0);

            // 3. 比較 (小文字と大文字を区別することに注意)
            if (endChar != startChar) {
                // 初めてしりとりが成立しなかった場合
                // 1つ目の単語の末尾の文字 (x) と 2つ目の単語の先頭の文字 (y) を出力
                // char を String に変換して半角スペース区切りで出力する
                System.out.println(endChar + " " + startChar);
                return; // プログラムを終了
            }
        }

        // ループを全て回りきったら、しりとりが成立
        System.out.println("Yes");
    }
}