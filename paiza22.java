import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int needed_cakes = 0;

        if(n % 6 == 0){
            needed_cakes = n / 6;
        }
        else{
            needed_cakes = n / 6 + 1;
        }
        
        System.out.println(needed_cakes);
    }
}

