import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 0;
        int end = 1;
        int mul = 1;

        while(true) {
            count ++;
            if(end >= n) break;

            end += (6 * mul++);
        }

        System.out.println(n == 1 ? 1 : count);
    }
}

// 1 -> 7 -> 19 -> 37