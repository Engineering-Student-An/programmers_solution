import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] arr, select;
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
        int ind = 0;
        for (Integer i : set) {
            arr[ind ++] = i;
        }

        Arrays.sort(arr);

        select = new int[m];
        for (int i = 0; i < n; i++) {
            select[0] = arr[i];
            sel(1, i);
        }

        System.out.print(sb);
    }

    static void sel(int count, int index) {

        if(count == m) {
            for (int i = 0; i < m; i++) {
                sb.append(select[i]).append(" ");
            }
            sb.append("\n");

            return;
        }

        for (int i = index; i < n; i++) {
            select[count] = arr[i];
            sel(count + 1, i);
        }
    }
}