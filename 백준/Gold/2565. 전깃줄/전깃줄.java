import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int[] count = new int[n];
        int max = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[i][0] > arr[j][0]) {
                    count[i] = Math.max(count[i], count[j] + 1);
                    max = Math.max(count[i], max);
                }
            }

            if(count[i] == 0) count[i] = 1;
        }

        System.out.println(n - max);
    }
}