import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, k, count = 0;
    static int[] arr, seq;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        visit = new boolean[n];
        seq = new int[n];
        find(0);

        System.out.println(count);
    }

    static void find(int index) {
        if(index == n) {
            int w = 500;
            boolean isPossible = true;
            for (int i = 0; i < n; i++) {
                w -= k;
                w += arr[seq[i]];

                if(w < 500) {
                    isPossible = false;
                    break;
                }
            }

            if(isPossible) count ++;

            return;
        }

        for (int i = 0; i < n; i++) {
            if(!visit[i]) {
                seq[index] = i;
                visit[i] = true;
                find(index + 1);
                visit[i] = false;
            }
        }
    }
}