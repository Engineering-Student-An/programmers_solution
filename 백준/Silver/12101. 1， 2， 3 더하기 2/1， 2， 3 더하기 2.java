import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, k, count = 0;
    static boolean found = false;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        find("", 0);
        sb.delete(0, 1);
        if(!found) System.out.println(-1);
        else System.out.print(sb);
    }

    static void find(String line, int sum) {

        if(sum == n) {
            if(count + 1 == k) {
                sb.append(line);
                found = true;
            } else {
                count ++;
            }

            return;
        }

        for (int i = 1; i <= 3; i++) {
            if(sum + i <= n) find(line + "+" + i, sum + i);
            if(found) return;
        }

    }
}