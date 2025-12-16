import java.util.Scanner;
import java.lang.Math; // Math.abs() を使用するため

public class Main {
    public static void main(String[] args) {
        // 標準入力から値を読み取るためのScannerを準備
        Scanner scanner = new Scanner(System.in);

        // 1行目: ログの行数（停止回数）N を読み取る
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int N = scanner.nextInt();

        // 総移動距離を格納する変数
        // 問題の制約 (N <= 100, f_j <= 100) から、最大移動距離は 100 * 100 = 10000 程度であり、
        // int型 (最大約21億) で十分だが、安全のためlongを使用しても良い
        int totalMovement = 0;

        // エレベーターの直前の停止階。初期位置を1階とする（図と出力例1に合わせる）
        int previousFloor = 1;

        // N回分の停止階を順番に読み込み、移動距離を計算
        for (int i = 0; i < N; i++) {
            // N行のデータがない場合のためにチェック
            if (!scanner.hasNextInt()) {
                break;
            }
            
            // 現在の停止階 f_j を読み取る
            int currentFloor = scanner.nextInt();

            // 直前の階からの移動距離を計算し、総移動距離に加算
            // 移動距離 = |現在の階 - 直前の階|
            totalMovement += Math.abs(currentFloor - previousFloor);

            // 現在の停止階を、次の移動のための「直前の階」として更新
            previousFloor = currentFloor;
        }

        scanner.close();

        // 結果を出力
        System.out.println(totalMovement);
    }
}