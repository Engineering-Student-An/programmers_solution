import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int d = scanner.nextInt();
        int k = scanner.nextInt();
        int c = scanner.nextInt();

        int[] arr = new int[n + k-1];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        for (int i = n; i < n + k - 1; i++) {
            arr[i] = arr[i - n];
        }

        int start_idx = 0;
        int end_idx = k-1;
        int max = 0;

        while (end_idx < n + k - 1) {
            boolean[] chk = new boolean[d+1];
            int cnt = 0;
            for (int i = start_idx; i <= end_idx; i++) {
                if(!chk[arr[i]]) {
                    cnt ++;
                    chk[arr[i]] = true;
                }
            }
            if(!chk[c]) cnt++;
            if(cnt > max) max = cnt;

            end_idx ++;
            start_idx ++;
        }

        System.out.println(max);
    }
}