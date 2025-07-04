import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static boolean[] visit;
    static int[] arr, s;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        s = new int[n];
        visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        select(0);

        System.out.print(sb);
    }

    static void select(int count) {

        if(count == m) {
            for (int i = 0; i < m; i++) {
                sb.append(s[i]).append(" ");
            }
            sb.append("\n");

            return;
        }

        for (int i = 0; i < n; i++) {
            if(!visit[i]) {
                visit[i] = true;
                s[count] = arr[i];
                select(count + 1);
                visit[i] = false;
            }
        }
    }
}