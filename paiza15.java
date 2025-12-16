import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // --- 1. 入力データの読み込みとSetへの格納 ---
        
        // バンドAのライブ日程を読み込む
        int M = scanner.nextInt();
        Set<Integer> liveDaysA = new HashSet<>();
        for (int i = 0; i < M; i++) {
            liveDaysA.add(scanner.nextInt());
        }

        // バンドBのライブ日程を読み込む
        int N = scanner.nextInt();
        Set<Integer> liveDaysB = new HashSet<>();
        for (int i = 0; i < N; i++) {
            liveDaysB.add(scanner.nextInt());
        }
        
        scanner.close();

        // --- 2. ライブスケジュールの決定と出力 ---

        // ライブが重なった日について、直前にAを選んだかどうかを追跡するフラグ
        // true: 直前はAを選択した -> 今回はBを選択
        // false: 直前はBを選択した（または最初の重なりである） -> 今回はAを選択
        // ※問題のルール「最初の日（重なり）はA」を反映させるため、初期値は適当な値で、
        //   最初の重なりが来たら強制的にAにしてフラグを更新するのが最も簡単。
        
        // このフラグは、過去にライブが重なり、かつその日にAを選んだかどうかを記憶
        // falseで初期化しておき、最初の重なりではAを選ぶロジックとする
        boolean lastOverlappingLiveWasA = false;
        
        // 31日分のライブスケジュール結果を保持するリスト
        ArrayList<String> schedule = new ArrayList<>();

        // 1日から31日までループ
        for (int day = 1; day <= 31; day++) {
            boolean isLiveA = liveDaysA.contains(day);
            boolean isLiveB = liveDaysB.contains(day);

            String result;

            if (isLiveA && isLiveB) {
                // (1) ライブが重なっている日
                
                // 最初の重なりはA、それ以降は交互
                if (lastOverlappingLiveWasA) {
                    // 前回Aだったので今回はB
                    result = "B";
                    lastOverlappingLiveWasA = false; // 次はA
                } else {
                    // 前回Aではなかったので今回はA (最初の重なりを含む)
                    result = "A";
                    lastOverlappingLiveWasA = true; // 次はB
                }
            } else if (isLiveA) {
                // (2) Aのライブのみがある日
                result = "A";
            } else if (isLiveB) {
                // (3) Bのライブのみがある日
                result = "B";
            } else {
                // (4) ライブがない日
                result = "x";
            }
            
            schedule.add(result);
        }

        // --- 3. 結果の出力 ---
        // 31行に分けて出力する
        for (String live : schedule) {
            System.out.println(live);
        }
    }
}