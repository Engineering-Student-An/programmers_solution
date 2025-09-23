import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m, l;
    static int[] diff;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int before = 0;
        diff = new int[n + 1];
        if(n > 0) {
            
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            int index = 0;
            for (int i = 0; i < n; i++) {
                diff[index ++] = arr[i] - before;
                before = arr[i];
            }
        }
        diff[n] = l - before;

        int left = 1, right = l;
        while(left <= right) {
            int middle = (left + right) / 2;

            boolean isPossible = check(middle);
            if(isPossible) right = middle - 1;
            else left = middle + 1;
        }

        System.out.println(left);
    }

    static boolean check(int middle) {
        int count = 0;

        for (int i = 0; i <= n; i++) {
            if(diff[i] < middle) continue;

            count += diff[i] / middle;
            count -= (diff[i] % middle == 0) ? 1 : 0;
        }

        return count <= m;
    }
}