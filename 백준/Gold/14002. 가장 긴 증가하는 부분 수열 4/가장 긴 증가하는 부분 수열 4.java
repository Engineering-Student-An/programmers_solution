import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] count = new int[n];
        int[] tracking = new int[n];
        count[0] = 1;
        tracking[0] = -1;
        for (int i = 1; i < n; i++) {
            int chk = 0;
            for (int j = 0; j < i; j++) {
                if(arr[j] < arr[i] && count[i] < count[j] + 1) {
                    count[i] = count[j] + 1;
                    tracking[i] = j;
                    chk ++;
                }
            }
            if(chk == 0) {
                count[i] = 1;
                tracking[i] = -1;
            }
        }

        int max = -1;
        int ind = 0;
        for (int i = 0; i < n; i++) {
            if(max < count[i]) {
                max = count[i];
                ind = i;
            }
        }
        System.out.println(max);
        Stack<Integer> stack = new Stack<>();
        while(ind >= 0) {
            stack.add(arr[ind]);
            ind = tracking[ind];
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()). append(" ");
        }
        System.out.println(sb);
    }
}