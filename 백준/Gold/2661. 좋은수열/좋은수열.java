import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= 3; i++) {
            arr = new int[n];
            arr[0] = i;
            if(find(1)) break;
        }
    }

    static boolean find(int index) {
        if(index == n) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) sb.append(arr[i]);

            System.out.println(sb);

            return true;
        }

        for (int i = 1; i <= 3; i++) {
            arr[index] = i;
            if(check(index) && find(index + 1)) return true;
        }

        return false;
    }

    static boolean check(int index) {
        for (int k = 1; k <= (index+1)/2; k++) {
            int same = 0;
            for (int i = 0; i < k; i++) {
                if(arr[index-i] == arr[index-i-k]) same ++;
            }

            if(same == k) return false;
        }

        return true;
    }
}