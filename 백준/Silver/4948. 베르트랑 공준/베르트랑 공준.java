import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        boolean[] prime = new boolean[246913];
        for (int i = 2; i <= 246912; i++) {
            prime[i] = true;
        }


        for (int i = 2; i*i <= 246912; i++) {
            if(prime[i]) {
                int j = 2;
                while(i*j <= 246912) {
                    prime[i*j] = false;
                    j++;
                }
            }
        }


        while (true) {
            int n = scanner.nextInt();
            if(n==0) break;

            int ans = 0;
            for (int i = n+1; i <= 2*n ; i++) {
                if(prime[i]) {
                    ans ++;
                }
            }
            sb.append(ans);
            sb.append("\n");

        }

        System.out.print(sb);
    }
}