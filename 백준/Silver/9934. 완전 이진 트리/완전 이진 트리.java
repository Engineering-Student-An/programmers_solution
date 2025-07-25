import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, k, index = 1;
    static int[] result, arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());

        n = (int) Math.pow(2, k);
        result = new int[n];
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        find(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            for (int j = (int) Math.pow(2, i); j < (int) Math.pow(2, i + 1); j++) {
                sb.append(result[j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void find(int i) {

        if(i >= n || result[i] != 0) {
            return;
        }

        find(i * 2);
        result[i] = arr[index ++];
        find(i * 2 + 1);
    }
}