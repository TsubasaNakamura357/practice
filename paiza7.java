import java.util.Scanner;

public class LeetConverter {

    /**
     * 指定されたLeet規則に従って文字列を変換するメソッド
     * @param input 変換したい文字列
     * @return Leet変換された文字列
     */
    public static String convertToLeet(String input) {

        StringBuilder leetString = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char originalChar = input.charAt(i);

            switch (originalChar) {
                case 'A':
                    leetString.append('4');
                    break;
                case 'E':
                    leetString.append('3');
                    break;
                case 'G':
                    leetString.append('6');
                    break;
                case 'I':
                    leetString.append('1');
                    break;
                case 'O':
                    leetString.append('0');
                    break;
                case 'S':
                    leetString.append('5');
                    break;
                case 'Z':
                    leetString.append('2');
                    break;
                default:

                    leetString.append(originalChar);
                    break;
            }
        }
        return leetString.toString();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String inputLine = scanner.nextLine(); 
        scanner.close();

        String result = convertToLeet(inputLine);
        System.out.println(result);
    }
}