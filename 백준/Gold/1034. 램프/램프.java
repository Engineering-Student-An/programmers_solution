import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, m, k, result = 0;
    static int[][] arr;
    static List<Integer>[] zeros;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        zeros = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            zeros[i] = new ArrayList<>();
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j) - '0';
                if(arr[i][j] == 0) zeros[i].add(j);
            }
        }

        k = Integer.parseInt(br.readLine());

        // 0 ~ n-1 행 -> 그 행을 성공시키려면?
        for (int l = 0; l < n; l++) {
            if(zeros[l].size() % 2 == k % 2 && zeros[l].size() <= k) {

                int count = 0;
                for (int i = 0; i < n; i++) {
                    boolean isContain = true;
                    for (int j = 0; j < m; j++) {
                        int num = (zeros[l].contains(j)) ? (arr[i][j] + 1) % 2 : arr[i][j];

                        if(num == 0) {
                            isContain = false;
                            break;
                        }
                    }
                    if(isContain) count ++;
                }

                result = Math.max(result, count);
            }
        }

        System.out.println(result);
    }
}