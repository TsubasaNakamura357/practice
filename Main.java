import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // 標準入力からの読み込みにはScannerを使用
        Scanner scanner = new Scanner(System.in);

        // 1行目のファイル名 S を読み込む
        // 入力は1行で、末尾に改行が1つあるため、nextLine()が適切
        String S = scanner.nextLine();

        // 1. 正規表現を定義
        // 連続するハイフン (--、--- など、2つ以上連続するもの) にマッチ
        // JavaのString.replaceAll()は最初の引数に正規表現を取る
        // 正規表現: [-]{2,} または -{2,}
        String regex = "-{2,}"; 

        // 2. 正規表現置換を実行
        // マッチした部分をすべて単一のハイフン "-" に置換する
        String result = S.replaceAll(regex, "-");

        // 結果を出力する
        // 出力最終行の末尾に改行を入れ、余計な文字、空白を含んではいけない
        System.out.println(result);

        scanner.close();
    }
}