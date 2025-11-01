import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int digit = Integer.parseInt(st.nextToken());

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += count(i, digit);
        }

        System.out.println(ans);
    }

    static int count(int num, int digit) {
        int count = 0;
        while(num > 0) {
            if(num % 10 == digit) count ++;
            num /= 10;
        }

        return count;
    }
}