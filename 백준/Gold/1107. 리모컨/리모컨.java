import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] arr = new int[m];
        if(m > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
        }

        int result = Math.abs(n - 100);
        for (int num = 0; num < 1000000; num++) {
            int temp = num;

            boolean possible = true;
            int count = 0;
            do {
                int jari = temp % 10;
                count ++;
                if(m > 0) {
                    for (int i = 0; i < m; i++) {
                        if (jari == arr[i]) {
                            possible = false;
                            break;
                        }
                    }
                    if (!possible) break;
                }

                temp /= 10;
            } while(temp > 0);

            if(!possible) continue;

            count += Math.abs(n - num);
            result = Math.min(result, count);
        }

        System.out.println(result);
    }
}