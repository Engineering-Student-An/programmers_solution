import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, result = Integer.MAX_VALUE;
    static boolean[] visit;
    static int[] seq;
    static int[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 플로이드 워셜 : 모든 노드 -> 다른 모든 노드까지 최단 거리 계산
        for (int k = 0; k < n; k++) {
            for (int s = 0; s < n; s++) {
                for (int e = 0; e < n; e++) {
                    arr[s][e] = Math.min(arr[s][k] + arr[k][e], arr[s][e]);
                }
            }
        }

        seq = new int[n];
        seq[0] = m;
        visit = new boolean[n];
        visit[m] = true;
        find(1);

        System.out.println(result);
    }

    static void find(int count) {
        if(count == n) {
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                sum += arr[seq[i]][seq[i + 1]];
            }

            result = Math.min(result, sum);
            return;
        }

        for (int i = 0; i < n; i++) {
            if(!visit[i]) {
                seq[count] = i;
                visit[i] = true;
                find(count + 1);
                visit[i] = false;
            }
        }
    }
}