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

        int[][] maxScore = new int[n+1][k+1];

        Info[] arr = new Info[n+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if(arr[i].time > j) maxScore[i][j] = maxScore[i-1][j];
                else {
                    maxScore[i][j] = Math.max(maxScore[i-1][j], maxScore[i-1][j - arr[i].time] + arr[i].score);
                }
            }
        }

        System.out.println(maxScore[n][k]);
    }

    static class Info {
        int time, score;

        public Info(int time, int score) {
            this.time = time;
            this.score = score;
        }
    }
}