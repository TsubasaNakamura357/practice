import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class BizaTravel {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        int[] dailyHours = new int[N];
        
    
        int minHours = 48; 
        int maxHours = 0; 

        for (int i = 0; i < N; i++) {
            // s_i f_i t_i を1行から読み込む
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken()); // 出発地 現地時間
            int f = Integer.parseInt(st.nextToken()); // 飛行時間
            int t = Integer.parseInt(st.nextToken()); // 到着地 現地時間
            
            int timeDifference = t - s - f;
            
            int dailyTime = 24 - timeDifference;
            
            dailyHours[i] = dailyTime;
            
            
            minHours = Math.min(minHours, dailyTime);
            maxHours = Math.max(maxHours, dailyTime);
        }

        System.out.println(minHours);
        
        System.out.println(maxHours);
        
    }
}