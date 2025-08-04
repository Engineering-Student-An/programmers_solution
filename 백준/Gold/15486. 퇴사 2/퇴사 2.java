import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Info[] arr = new Info[n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int ans = 0;
        int max = 0;
        int[] result = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            int next = arr[i].d + i;
            result[i] = Math.max(max, result[i]);
            if(next <= n + 1 && result[next] < result[i] + arr[i].p) {
                result[next] = result[i] + arr[i].p;
                ans = Math.max(ans, result[next]);
            }

            max = Math.max(max, result[i]);
        }

        System.out.println(ans);
    }

    static class Info {
        int d, p;

        public Info(int d, int p) {
            this.d = d;
            this.p = p;
        }
    }
}