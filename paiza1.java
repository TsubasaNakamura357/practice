import java.util.Scanner;

public class paiza1 {

    public static void main(String[] args) {
        // 標準入力からの読み込みにはScannerを使用
        Scanner scanner = new Scanner(System.in);

        // 1行目の N (紙の枚数) と D (一辺の長さ) を読み込む
        // N と D は半角スペース区切りで与えられる
        int N = scanner.nextInt();
        int D = scanner.nextInt();

        // 2行目以降の d_i (重なりの幅) を読み込む
        // 重なりは N-1 個ある (d_2 から d_N まで)
        // ルールに基づいた計算では、全体の幅を求め、それに D を掛ける

        // 1枚目の幅は D
        int totalWidth = D;
        
        // 2枚目以降 (i=2 から i=N まで) の純粋な追加幅を合計する
        // 入力では i+1 行目に d_{i+1} が与えられるため、
        // 2行目から N行目までループを回し、d_2 から d_N を読み込む
        for (int i = 2; i <= N; i++) {
            // d_i (i枚目の紙とi-1枚目の紙の重なりの幅)
            int overlap_d_i = scanner.nextInt();
            
            // i枚目の紙による純粋な幅の追加分は (D - d_i)
            // この値が全体の幅に追加される
            int addedWidth = D - overlap_d_i;
            totalWidth += addedWidth;
        }

        // 垂れ幕の面積を計算: 面積 = D * (全体の幅)
        // 条件より N, D, d_i は整数であり、出力も整数で求められているため、
        // 計算結果は long ではなく int で十分だが、D*D*N が最大 100 * 10 * 10 = 10000 程度なので int で十分。
        long totalArea = (long)D * totalWidth;

        // 結果を出力する
        // 出力最終行の末尾に改行を入れ、余計な文字、空白を含んではいけない
        System.out.println(totalArea);

        scanner.close();
    }
}