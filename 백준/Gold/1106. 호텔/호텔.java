import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        Info[] arr =  new Info[n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int[][] min = new int[n + 1][1201];
        for (int i = 0; i <= 1200; i++) {
            min[0][i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 1200; j++) {
                if(arr[i].plus <= j && min[i][j - arr[i].plus] != Integer.MAX_VALUE) {
                    min[i][j] = Math.min(min[i - 1][j], min[i][j - arr[i].plus] + arr[i].cost);
                } else min[i][j] = min[i-1][j];
            }
        }

        int result = Integer.MAX_VALUE;
        for (int j = c; j < 1201; j++) {
            for (int i = 0; i <= n; i++) {
                result = Math.min(min[i][j], result);
            }
        }
        System.out.println(result);
    }

    static class Info {
        int cost, plus;

        public Info(int cost, int plus) {
            this.cost = cost;
            this.plus = plus;
        }
    }
}