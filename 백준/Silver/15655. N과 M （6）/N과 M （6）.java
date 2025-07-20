import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] arr, temp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < n - m + 1; i++) {
            temp = new int[m];
            temp[0] = arr[i];
            find(i, 1);
        }

        System.out.print(sb);
    }

    static void find(int ind, int cnt) {
        if(cnt == m) {
            for (int i = 0; i < m; i++) {
                sb.append(temp[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = ind + 1; i < n; i++) {
            temp[cnt] = arr[i];
            find(i, cnt + 1);
        }
    }
}