import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static boolean[] visit;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        result = new int[n];
        visit = new boolean[n+1];

        find(0);

        System.out.print(sb);
    }

    static void find(int index) {
        if(index == n) {
            for (int i = 0; i < n; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");

            return;
        }

        for (int i = 1; i <= n; i++) {
            if(!visit[i]) {
                result[index] = i;
                visit[i] = true;

                find(index + 1);

                visit[i] = false;
            }
        }
    }
}