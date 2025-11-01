import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            int diff1 = Math.abs(b - a);
            int diff2 = Math.abs(b - num);

            if(diff2 < diff1) {
                a = num;
                count = 1;
            }
        }

        count += Math.abs(b - a);

        System.out.println(count);
    }
}