import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, max = Integer.MIN_VALUE;
    static int[] div = new int[4];
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        find(n, 0);

        System.out.println(max);
    }

    static void find(int rem, int index) {
        if(index == 4) {
            max = Math.max(max, findMax());
            return;
        }

        if(index == 3) {
            div[index] = rem;
            find(0, 4);
        } else {
            for (int i = 1; i <= (rem - 3 + index); i++) {
                div[index] = i;
                find(rem - i, index + 1);
            }
        }
    }

    static int findMax() {

        int now = 1;
        int start = div[0];
        for (int i = 0; i < div[0]; i++) {
            now *= arr[i];
        }
        int sum = now;

        for (int i = 1; i < 4; i++) {
            now = 1;
            for (int j = start; j < start + div[i]; j++) {
                now *= arr[j];
            }
            sum += now;
            start += div[i];
        }

        return sum;
    }
}