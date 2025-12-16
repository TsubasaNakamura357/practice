import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1行目: 校正ルール S を読み取る (長さ26)
        String S = scanner.nextLine();
        
        // 2行目: 校正前の文字列 T を読み取る
        String T = scanner.nextLine();
        
        scanner.close();

        // 結果を格納するためのStringBuilder
        StringBuilder correctedString = new StringBuilder();

        // ルールSから、各アルファベット（A/a, B/b, ...）の校正後の状態を高速に参照できるように、
        // 辞書/配列のようなものを作成する。
        // ここでは、アルファベットをインデックス（0:A/a, 1:B/b, ... 25:Z/z）に変換してSを参照する。
        
        // 校正前の文字列 T を1文字ずつ処理
        for (char originalChar : T.toCharArray()) {
            char correctedChar;
            
            // 処理対象は英字のみ
            if (Character.isLetter(originalChar)) {
                
                // (1) アルファベットのインデックス（0～25）を計算
                // 大文字・小文字に関わらず、'A'/'a'を0、'B'/'b'を1とする
                int index;
                if (Character.isUpperCase(originalChar)) {
                    index = originalChar - 'A';
                } else {
                    index = originalChar - 'a';
                }
                
                // (2) 校正ルールSの対応する文字を取得
                char ruleChar = S.charAt(index);
                
                // (3) 校正ルールSの文字が大文字か小文字かで、originalCharを変換
                if (Character.isUpperCase(ruleChar)) {
                    // Sのルールが「大文字」を要求している
                    correctedChar = Character.toUpperCase(originalChar);
                } else {
                    // Sのルールが「小文字」を要求している
                    correctedChar = Character.toLowerCase(originalChar);
                }
            } else {
                // 英字でない文字（問題文の例では英字のみだが、一般的なロジックとして）
                correctedChar = originalChar;
            }
            
            correctedString.append(correctedChar);
        }

        // 結果を出力
        System.out.println(correctedString.toString());
    }
}