import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Work[] arr = new Work[n+1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int d = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            arr[i] = new Work(d, p);
        }

        long[] result = new long[n+2];
        for (int i = n; i > 0; i--) {
            if(arr[i].day == 1) {
                result[i] = result[i+1] + arr[i].price;
            } else if(i + arr[i].day <= n + 1){
                result[i] = Math.max(result[i + 1], result[i + arr[i].day] + arr[i].price);
            } else {
                result[i] = result[i+1];
            }
        }

        System.out.println(result[1]);
    }

    static class Work {
        int day;
        int price;

        public Work(int day, int price) {
            this.day = day;
            this.price = price;
        }
    }
}