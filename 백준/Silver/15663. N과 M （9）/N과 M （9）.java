import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m, index = 0;
    static int[] temp, arr, s, count, check;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        temp = new int[n];
        count = new int[10001];
        check = new int[10001];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            count[a] ++;
            if(count[a] == 1) temp[index ++] = a;
        }

        arr = new int[index];
        for (int i = 0; i < index; i++) {
            arr[i] = temp[i];
        }

        Arrays.sort(arr);

        s = new int[m];
        for (int i = 0; i < index; i++) {
            s[0] = arr[i];
            check[arr[i]] ++;
            select(1, i);
            check[arr[i]] --;
        }

        System.out.print(sb);
    }

    static void select(int c, int idx) {

        if(c == m) {
            for (int i = 0; i < m; i++) {
                sb.append(s[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < index; i++) {
            if(check[arr[i]] < count[arr[i]]) {
                s[c] = arr[i];
                check[arr[i]]++;
                select(c + 1, i);
                check[arr[i]]--;
            }
        }
    }
}