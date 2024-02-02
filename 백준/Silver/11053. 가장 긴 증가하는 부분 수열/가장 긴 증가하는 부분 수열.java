import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] arr = new int[n+1];

        for (int i = 1; i <= n; i++) {
            arr[i] = scanner.nextInt();
        }

        int ans_max = -1;
        int[] ans = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int max = -1;
            int ind = 0;
            for (int j = 0; j < i; j++) {
                if(arr[i]>arr[j] && ans[j] > max){
                    ind = j;
                    max = ans[j];
                }
            }
            ans[i] = ans[ind] + 1;
            if(ans_max < ans[i]) ans_max = ans[i];
        }

        System.out.println(ans_max);
    }
}