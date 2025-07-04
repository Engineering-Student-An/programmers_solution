import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[1229];
        arr[0] = 2;
        int index = 1;

        for (int i = 3; i < 10000; i+=2) {
            boolean chk = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if(i % j == 0) {
                    chk = false;
                    break;
                }
            }

            if(chk) arr[index ++] = i;
        }

        int Testcase = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(Testcase -- > 0) {
            int n = Integer.parseInt(br.readLine());

            int[] result = new int[2];
            int diff = Integer.MAX_VALUE;
            for (int i = 0; i < 1229; i++) {
                if(arr[i] >= n) break;

                for (int j = i; j < 1229; j++) {
                    if(arr[i] + arr[j] > n) break;

                    if (arr[i] + arr[j] == n && diff > arr[j] - arr[i]) {
                        diff = arr[j] - arr[i];
                        result[0] = arr[i];
                        result[1] = arr[j];
                        break;
                    }
                }
            }

            sb.append(result[0] + " " + result[1]).append("\n");
        }
        System.out.print(sb);
    }
}