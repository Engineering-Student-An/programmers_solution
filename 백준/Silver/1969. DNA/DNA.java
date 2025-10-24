import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        char[] dna = {'A', 'C', 'G', 'T'};
        int[][] dist = new int[4][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 4; j++) {
                char c = dna[j];
                int sum = 0;
                for (int k = 0; k < n; k++) {
                    if(arr[k].charAt(i) != c) sum ++;
                }

                dist[j][i] = sum;
            }
        }

        String ans = "";
        int result = 0;
        for (int i = 0; i < m; i++) {
            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int j = 0; j < 4; j++) {
                if(dist[j][i] < min) {
                    min = dist[j][i];
                    index = j;
                }
            }

            ans += dna[index];
            result += min;
        }

        System.out.println(ans);
        System.out.println(result);
    }
}