import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    
    static int n, m;
    static int[] arr, result;
    static Set<String> set = new HashSet<>();
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
        
        result = new int[m];
        for (int i = 0; i < n - m + 1; i++) {
            result[0] = arr[i];
            seq(i + 1, 1);
        }

        System.out.print(sb);
    }

    static void seq(int index, int count) {
        if(count == m) {
            String ans = "";
            for (int i = 0; i < m; i++) ans += result[i] + " ";

            if(set.contains(ans)) return;

            set.add(ans);
            sb.append(ans).append("\n");
            return;
        }

        for (int i = index; i < n - (m - count) + 1; i++) {
            result[count] = arr[i];
            seq(i + 1, count + 1);
        }
    }
}