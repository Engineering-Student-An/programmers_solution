import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if(n == 0 && m == 0) break;

            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            int count = 0;
            for (int i = 0; i < m; i++) {
                int num = Integer.parseInt(br.readLine());

                if(find(num)) count ++;
            }

            sb.append(count).append("\n");
        }

        System.out.print(sb);

    }

    static boolean find(int num) {

        int l = 0, r = arr.length - 1;
        while(l <= r) {
            int m = (l + r) / 2;
            if(arr[m] == num) return true;

            if(arr[m] > num) r = m - 1;
            else l = m + 1;
        }

        return false;
    }
}