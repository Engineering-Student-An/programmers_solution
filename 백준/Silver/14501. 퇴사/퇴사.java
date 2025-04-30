import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Info[] arr = new Info[n+1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        long[] result = new long[n+2];
        for (int i = 1; i <= n; i++) {
            result[i] = Math.max(result[i-1], result[i]);

            int next = i + arr[i].days;
            if(next > n+1) continue;
            result[next] = Math.max(result[i] + arr[i].value, result[next]);
        }

        System.out.println(Math.max(result[n], result[n+1]));
    }

    static class Info {
        int days;
        int value;

        public Info(int days, int value) {
            this.days = days;
            this.value = value;
        }
    }
}