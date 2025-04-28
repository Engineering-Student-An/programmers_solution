import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        boolean[] visit = new boolean[n+1];
        long[] arr = new long[n+1];
        arr[n] = 1;
        for (int i = n-1; i > 0; i--) {
            arr[i] = arr[i + 1] * (n - i + 1);
        }

        int q = Integer.parseInt(st.nextToken());
        if(q == 1) {
            long k = Long.parseLong(st.nextToken());
            int[] ans = new int[n+1];

            for (int i = 1; i <= n-1; i++) {
                int count = 1;
                for (int j = 1; j <= n; j++) {
                    if(visit[j]) continue;
                    if(arr[i+1] * count >= k) {
                        k -= (arr[i+1] * (count-1));
                        visit[j] = true;
                        ans[i] = j;
                        break;
                    } else {
                        count ++;
                    }
                }
            }
            for (int i = 1; i <= n; i++) {
                if(!visit[i]) {
                    ans[n] = i;
                    break;
                }
            }
            for (int i = 1; i <= n; i++) {
                System.out.print(ans[i] + " ");
            }

        } else {
            int[] p = new int[n+1];
            for (int i = 1; i <= n; i++) {
                p[i] = Integer.parseInt(st.nextToken());
            }

            long ans = 1;
            for (int i = 1; i <= n-1; i++) {
                int count = 0;
                for (int j = 1; j <= n; j++) {
                    if(visit[j]) continue;
                    if(p[i] == j) {
                        ans += count * arr[i+1];
                        visit[j] = true;
                        break;
                    } else {
                        count ++;
                    }
                }
            }
            System.out.println(ans);
        }
    }
}