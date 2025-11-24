import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String line = br.readLine();

        boolean[] visit = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if(line.charAt(i) == 'P') {
                for (int j = Math.max(0, i - k); j <= Math.min(n-1, i + k); j++) {
                    if(line.charAt(j) == 'H' && !visit[j]) {
                        visit[j] = true;
                        count ++;
                        break;
                    }
                }
            }
        }

        System.out.println(count);
    }
}