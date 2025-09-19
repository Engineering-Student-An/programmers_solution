import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0, r = n - 1;
        int ans = Integer.MAX_VALUE;
        while(l < r) {
            int sum = arr[l] + arr[r];

            if(Math.abs(sum) < Math.abs(ans)) ans = sum;
            if(sum == 0) break;
            else if(sum > 0) r --;
            else l ++;
        }

        System.out.println(ans);
    }
}