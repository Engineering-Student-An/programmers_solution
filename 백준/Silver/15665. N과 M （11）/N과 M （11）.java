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
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        Set<Integer> set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        n = set.size();
        arr = new int[n];
        int index = 0;
        for (Integer i : set) {
            arr[index ++] = i;
        }
        Arrays.sort(arr);

        result = new int[m];
        for (int i = 0; i < n; i++) {
            result[0] = arr[i];
            find(1);
        }

        System.out.print(sb);
    }

    static void find(int count) {

        if(count == m) {
            for (int i = 0; i < m; i++) {
                sb.append(result[i]).append(" ");
            }

            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            result[count] = arr[i];
            find(count + 1);
        }
    }
}