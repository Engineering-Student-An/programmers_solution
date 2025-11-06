import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        boolean[] visit = new boolean[n + 1];
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            if(arr[i] <= n && !visit[arr[i]]) {
                visit[arr[i]] = true;
                arr[i] = 0;
            }
        }

        Arrays.sort(arr);
        int index = 0;
        for (int i = 0; i < n; i++) {
            if(arr[i] == 0) continue;

            index = i;
            break;
        }

        long result = 0;
        for (int i = 1; i <= n; i++) {
            if(visit[i]) continue;

            result += Math.abs(arr[index] - i);
            index ++;
        }

        System.out.println(result);
    }
}