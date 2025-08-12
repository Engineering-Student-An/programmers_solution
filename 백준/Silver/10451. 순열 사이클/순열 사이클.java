import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] arr;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T -- > 0) {
            n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr = new int[n+1];
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int count = 0;
            visit = new boolean[n+1];
            for (int i = 1; i <= n; i++) {
                if(!visit[i]) {
                    count ++;
                    dfs(i);
                }
            }
            sb.append(count).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int num) {
        if(visit[num]) return;

        visit[num] = true;
        dfs(arr[num]);
    }
}