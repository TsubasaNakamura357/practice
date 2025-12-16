import java.util.Scanner;

public class CheapestSupermarketCount {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String S = scanner.nextLine();
        scanner.close();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            if ("AEIOUaeiou".indexOf(c) == -1) {
                result.append(c);
            }
        }

        System.out.println(result.toString());
    }
}
