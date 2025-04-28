import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] arr;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            if(n == 0) break;

            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            visit = new boolean[n];
            make(0, 0);

            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void make(int ind, int count) {
        if(count > 6) return;

        if(count == 6) {
            for (int i = 0; i < n; i++) {
                if(visit[i]) sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = ind; i < n; i++) {
            if(!visit[i]) {
                visit[i] = true;
                make(i+1, count + 1);
                visit[i] = false;
            }
        }
    }
}