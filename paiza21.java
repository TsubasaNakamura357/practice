import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int D = sc.nextInt();
        int X = sc.nextInt();
        int Y = sc.nextInt();
        int visithome = 0;

        for(int i = 0 ; i < N ; i++)
        {
            int x = sc.nextInt();
            int y = sc.nextInt();

            int distance = 0;
            

            distance = Math.abs(X - x) + Math.abs(Y - y);
            if(distance <= D)
            {
                visithome++;
            }
        }
        System.out.println(visithome);
        sc.close();
    }
}