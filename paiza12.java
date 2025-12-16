import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int totalMinutes = 0;

        for (int i = 0; i < N; i++) {
            String enter = sc.next();
            String leave = sc.next();

            int enterMinutes = toMinutes(enter);
            int leaveMinutes = toMinutes(leave);

            totalMinutes += (leaveMinutes - enterMinutes);
        }

        int hours = totalMinutes / 60;
        int minutes = totalMinutes % 60;

        System.out.println(hours + " " + minutes);
    }

    private static int toMinutes(String time) {
        String[] parts = time.split(":");
        int hh = Integer.parseInt(parts[0]);
        int mm = Integer.parseInt(parts[1]);
        return hh * 60 + mm;
    }
}
