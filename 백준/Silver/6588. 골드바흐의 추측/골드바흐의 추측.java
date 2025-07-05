import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean[] prime = new boolean[1000001];
        for (int i = 0; i < 1000001; i++) {
            prime[i] = true;
        }

        // 100만 이하의 소수 미리 구하기
        for (int i = 2; i <= 1000000; i++) {
            if(prime[i]) {
                for (int j = 2; j * i <= 1000000; j++) {
                    prime[j*i] = false;
                }
            }
        }
        prime[2] = false;

        while(true) {
            int n = Integer.parseInt(br.readLine());

            if(n == 0) break;

            boolean found = false;
            for (int i = 3; i <= 500000; i++) {
                if(prime[i] && prime[n - i]) {
                    sb.append(n).append(" = ").append(i).append(" + ").append(n - i).append("\n");
                    found = true;
                    break;
                }
            }

            if(!found) sb.append("Goldbach's conjecture is wrong.").append("\n");

        }

        System.out.print(sb);
    }
}