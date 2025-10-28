import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m, count = 0;
    static int[] a, b;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(T -- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            b = new int[m];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(a);
            Arrays.sort(b);

            count = 0;
            for (int i = 0; i < m; i++) {
                int index = binarySearch(b[i]);
                count += (n - index);
            }

            sb.append(count).append("\n");
        }

        System.out.print(sb);
    }

    static int binarySearch(int num) {
        int l = 0, r = n - 1;
        while(l <= r) {
            int m = (l + r) / 2;

            if(a[m] <= num) l = m + 1;
            else r = m - 1;
        }

        return l;
    }
}