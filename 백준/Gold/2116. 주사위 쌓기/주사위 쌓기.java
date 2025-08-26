import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] arr;
    static Map<Integer, Integer> opposite = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][6];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        for (int firstUp = 0; firstUp < 6; firstUp++) {
            int[] up = new int[n];
            up[0] = firstUp;
            int sum = findMax(0, firstUp);
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < 6; j++) {
                    if(arr[i][j] == arr[i-1][up[i-1]]) {
                        if(j == 0) up[i] = 5;
                        else if(j == 1) up[i] = 3;
                        else if(j == 2) up[i] = 4;
                        else if(j == 3) up[i] = 1;
                        else if(j == 4) up[i] = 2;
                        else up[i] = 0;

                        sum += findMax(i, up[i]);
                        break;
                    }
                }
            }

            max = Math.max(max, sum);
        }

        System.out.println(max);
    }

    static int findMax(int i, int up) {
        int max = 0;
        for (int j = 0; j < 6; j++) {
            if((up == 0 || up == 5) && j != 0 && j != 5) {
                max = Math.max(arr[i][j], max);
            } else if((up == 1 || up == 3) && j != 1 && j != 3) {
                max = Math.max(arr[i][j], max);
            } else if((up == 2 || up == 4) && j != 2 && j != 4) {
                max = Math.max(arr[i][j], max);
            }
        }

        return max;
    }
}