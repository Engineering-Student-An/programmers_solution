import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, arr[i][j]);
                min = Math.min(min, arr[i][j]);
            }
        }

        int ansT = Integer.MAX_VALUE, ansH = 0;
        for (int h = max; h >= min; h--) {
            int bag = b;
            int time = 0;
            // 땅 파기
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(arr[i][j] > h) {
                        time += 2 * (arr[i][j] - h);
                        bag += (arr[i][j] - h);
                    }
                }
            }

            // 땅 쌓기
            boolean isPossible = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(arr[i][j] < h) {
                        if(bag < h - arr[i][j]) {
                            isPossible = false;
                            break;
                        }

                        bag -= (h - arr[i][j]);
                        time += (h - arr[i][j]);
                    }
                }

                if(!isPossible) break;
            }

            if(!isPossible) continue;

            if(ansT > time) {
                ansT = time;
                ansH = h;
            }
        }

        System.out.println(ansT + " " + ansH);
    }
}