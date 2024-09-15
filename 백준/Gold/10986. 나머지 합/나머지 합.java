import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] mod = new int[n];

        mod[0] = scanner.nextInt() % m;
        for (int i = 1; i < n; i++) {
            mod[i] = (mod[i-1] + scanner.nextInt()) % m;
        }

        int[] cnt = new int[m];
        cnt[0] = 1;
        for (int i = 0; i < n; i++) {
            cnt[mod[i]] ++;
        }

        long result = 0;
        for (int i = 0; i < m; i++) {
            if(cnt[i] > 1) {
                result += ((long) cnt[i] * (cnt[i]-1)) / 2;
            }
        }

        System.out.println(result);
    }
}


