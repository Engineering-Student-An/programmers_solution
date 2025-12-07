import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String line = br.readLine();
            int n = (int) Math.sqrt(line.length());

            char[][] arr = new char[n][n];
            int index = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = line.charAt(index++);
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sb.append(arr[j][n - i - 1]);
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}

/*
(4,4) -> (0,4)
(3,4) -> (0,3)

(2,3) -> (1,2)
 */