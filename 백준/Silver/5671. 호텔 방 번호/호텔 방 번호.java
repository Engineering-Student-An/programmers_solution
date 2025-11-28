import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] result = new int[5001];
        result[1] = 1;
        for (int i = 2; i <= 10; i++) {
            result[i] = result[i-1] + 1;
        }

        for (int i = 11; i <= 5000; i++) {
            if(isPossible(i)) result[i] = result[i-1] + 1;
            else result[i] = result[i-1];
        }

        StringBuilder sb = new StringBuilder();
        while(true) {
            String line = br.readLine();
            if(line == null || line.isEmpty()) break;

            StringTokenizer st = new StringTokenizer(line);

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            sb.append(result[m] - result[n - 1]).append("\n");
        }


        System.out.print(sb);
    }

    static boolean isPossible(int num) {
        boolean[] visit = new boolean[10];

        while(num > 0) {
            int mod = num % 10;
            if(visit[mod]) return false;

            visit[mod] = true;
            num /= 10;
        }

        return true;
    }
}