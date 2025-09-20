import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            String line = br.readLine();
            if(line == null || line.isEmpty()) break;

            int len = Integer.parseInt(line);
            len *= 10000000;

            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(arr);

            int left = 0, right = n-1;
            if(n < 2) right = 0;
            else {
                while (left < right) {
                    int sum = arr[left] + arr[right];
                    if (sum == len) break;

                    if (sum < len) left++;
                    else right--;
                }
            }

            if(left < right) sb.append("yes ").append(arr[left]).append(" ").append(arr[right]).append("\n");
            else sb.append("danger\n");
        }

        System.out.println(sb);
    }
}