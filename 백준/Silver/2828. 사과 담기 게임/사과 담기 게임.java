import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int k = Integer.parseInt(br.readLine());
        int left = 1;
        int right = m;

        int count = 0;
        for (int i = 0; i < k; i++) {
            int j = Integer.parseInt(br.readLine());

            if(left <= j && j <= right) continue;

            if(left > j) {
                count += (left - j);
                right -= (left - j);
                left = j;
            } else {
                count += (j - right);
                left += (j - right);
                right = j;
            }
        }

        System.out.println(count);
    }
}