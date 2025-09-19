import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n, count = 10;
    static boolean isFound = false;
    static int[] result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        if(n < 11) {
            System.out.println(n - 1);
        } else {
            for (int k = 2; k <= 10; k++) {
                result = new int[k];
                for (int i = k - 1; i < 10; i++) {
                    result[0] = i;
                    check(k, 1, i);
                    if(isFound) break;
                }
                if(isFound) break;
            }
            if(!isFound) System.out.println(-1);
        }


    }

    static void check(int k, int jarisu, int before) {
        if(jarisu == k) {
            count ++;
            if(count == n) {
                for (int i = 0; i < k; i++) {
                    System.out.print(result[i]);
                }

                isFound = true;
                return;
            }
            return;
        }

        for (int i = k - jarisu - 1; i <= before - 1; i++) {
            result[jarisu] = i;
            check(k, jarisu + 1, i);
            if(isFound) return;
        }
    }
}