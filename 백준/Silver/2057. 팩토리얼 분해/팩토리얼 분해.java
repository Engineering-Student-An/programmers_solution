import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static long[] arr;
    static long n;
    static long max = 1_000_000_000_000_000_000L;
    static boolean isPossible = false;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Long.parseLong(br.readLine());

        arr = new long[20];
        arr[0] = 1;
        arr[1] = 1;

        if(n == 1) isPossible = true;
        else {
            for (int i = 2; i < 20; i++) {
                arr[i] = arr[i - 1] * i;
                if(n == arr[i]) {
                    isPossible = true;
                    break;
                }
            }

            if(!isPossible) {
                find(0, 0);
            }
        }

        System.out.println((isPossible && n != 0) ? "YES" : "NO");

    }

    static void find(int index, long sum) {
        if(sum == n) {
            isPossible = true;
            return;
        }
        if(index == 20) return;

        find(index + 1, sum + arr[index]);
        if(isPossible) return;
        find(index + 1, sum);
    }
}