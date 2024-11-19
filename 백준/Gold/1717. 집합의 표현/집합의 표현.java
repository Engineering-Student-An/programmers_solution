import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n+1];
        for (int i = 0; i <= n; i++) {
            arr[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(type == 0) {
                union(a, b);
            } else {
                sb.append(checkSame(a, b) ? "YES" : "NO").append("\n");
            }
        }

        System.out.print(sb);
    }

    public static void union(int a, int b) {

        a = find(a);
        b = find(b);

        if(a != b) {
            arr[b] = a;
        }
    }

    public static boolean checkSame(int a, int b) {

        return (find(a) == find(b));
    }

    public static int find(int a) {

        if(arr[a] == a) {
            return a;
        }
        return arr[a] = find(arr[a]);
    }
}