import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String line = br.readLine();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = line.charAt(i) - '0';
        }

        int[] ans = new int[n-k];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = Integer.MAX_VALUE;
        }

        int index = 0;
        for (int i = 0; i < n; i++) {
            if(k == 0 && index < ans.length) {
                ans[index ++] = arr[i];
            } else {
                while (index > 0 && k > 0) {
                    if(ans[index - 1] == Integer.MAX_VALUE || arr[i] <= ans[index - 1]) break;
                    index--;
                    k--;
                }
                if(index >= ans.length) continue;
                ans[index ++] = arr[i];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ans.length; i++) {
            sb.append(ans[i]);
        }
        System.out.println(sb);
    }
}