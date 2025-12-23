import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        
        int N = Integer.parseInt(br.readLine().trim());

        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        
        st = new StringTokenizer(br.readLine());

        int countOverK = 0;
        int sum = 0;

        for (int i = 0; i < N; i++) {
            int q = Integer.parseInt(st.nextToken());
            sum += q;
            if (q >= K) {
                countOverK++;
            }
        }

        if (countOverK >= 3 && sum >= M) {
            System.out.println("silver");
        } else {
            System.out.println("bronze");
        }
    }
}
