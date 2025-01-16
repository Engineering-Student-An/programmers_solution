import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long[][] arr = new long[n+1][k+1];

        Info[] infos = new Info[n+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            infos[i] = new Info(weight, value);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if(infos[i].weight > j) {
                    arr[i][j] = arr[i-1][j];
                } else {
                    arr[i][j] = Math.max(arr[i-1][j], arr[i-1][j-(int) infos[i].weight] + infos[i].value);
                }
            }
        }

        System.out.println(arr[n][k]);
    }

    static class Info {
        long weight;
        long value;

        public Info(long weight, long value) {
            this.weight = weight;
            this.value = value;
        }
    }
}