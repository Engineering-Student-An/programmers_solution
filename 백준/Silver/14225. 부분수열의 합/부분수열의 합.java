import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int[] arr;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        int total = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
        }
        Arrays.sort(arr);

        check = new boolean[total + 2];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n; j++) {
                find(j, 1, arr[j], i);
            }
        }

        for (int i = 1; i <= total + 1; i++) {
            if(!check[i]) {
                System.out.println(i);
                break;
            }
        }
    }

    static void find(int index, int count, int sum, int full) {
        if(count == full) {
            check[sum] = true;
            return;
        }

        for (int i = index + 1; i < n; i++) {
            find(i, count + 1, sum + arr[i], full);
        }
    }
}