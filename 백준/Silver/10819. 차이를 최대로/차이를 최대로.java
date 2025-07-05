import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, result = Integer.MIN_VALUE;
    static int[] arr, select;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        select = new int[n];
        visit = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sel(0, -1);

        System.out.println(result);
    }

    static void sel(int count, int index) {
        if(count == n) {
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                sum += Math.abs(select[i] - select[i + 1]);
            }

            result = Math.max(result, sum);
            return;
        }

        for (int i = 0; i < n; i++) {
            if(!visit[i]) {
                select[count] = arr[i];
                visit[i] = true;
                sel(count + 1, i);
                visit[i] = false;
            }
        }
    }
}