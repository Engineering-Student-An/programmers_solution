import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int testCase = Integer.parseInt(st.nextToken());

            int[] arr = new int[20];
            for (int i = 0; i < 20; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int count = 0;
            for (int i = 0; i < 19; i++) {
                for (int j = 0; j < 19 - i; j++) {
                    if(arr[j] > arr[j + 1]) {
                        count ++;
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }

            sb.append(testCase).append(" ").append(count).append("\n");
        }

        System.out.print(sb);
    }
}