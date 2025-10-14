import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][][] distance;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] arr = new int[n+1][n+1];
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if(arr[s][e] == 0) arr[s][e] = v;
            else arr[s][e] = Math.min(arr[s][e], v);
        }

        distance = new int[2][n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i == j) continue;
                distance[0][i][j] = (arr[i][j] != 0) ? arr[i][j] : Integer.MAX_VALUE;
            }
        }

        for (int k = 1; k <= n; k++) {
            for (int s = 1; s <= n; s++) {
                for (int e = 1; e <= n; e++) {
                    if(distance[0][s][k] != Integer.MAX_VALUE && distance[0][k][e] != Integer.MAX_VALUE && distance[0][s][e] > distance[0][s][k] + distance[0][k][e]) {
                        distance[0][s][e] = distance[0][s][k] + distance[0][k][e];
                        distance[1][s][e] = k;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int s = 1; s <= n; s++) {
            for (int e = 1; e <= n; e++) {
                sb.append(distance[0][s][e] != Integer.MAX_VALUE ? distance[0][s][e] : 0).append(" ");
            }
            sb.append("\n");
        }

        for (int s = 1; s <= n; s++) {
            for (int e = 1; e <= n; e++) {
                if(distance[0][s][e] == 0 || distance[0][s][e] == Integer.MAX_VALUE) sb.append(0).append("\n");
                else {
                    List<Integer> list = find(s, e);
                    sb.append(list.size() + 2).append(" ");
                    sb.append(s).append(" ");
                    for (int i = 0; i < list.size(); i++) {
                        sb.append(list.get(i)).append(" ");
                    }
                    sb.append(e).append("\n");
                }
            }
        }

        System.out.print(sb);
    }

    static List<Integer> find(int s, int e) {

        if(distance[1][s][e] == 0) return new ArrayList<>();

        List<Integer> before = find(s, distance[1][s][e]);
        List<Integer> next = find(distance[1][s][e], e);

        before.add(distance[1][s][e]);
        before.addAll(next);

        return before;
    }
}