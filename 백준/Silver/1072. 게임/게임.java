import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());


        long before = m * 100 / n;

        if(before >= 99) {
            System.out.println(-1);
        } else {

            long left = 1;
            long right = n;

            while (left <= right) {
                long middle = (left + right) / 2;

                long now = (m + middle) * 100 / (n + middle);

                if (now > before) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }

            System.out.println(left);
        }
    }
}