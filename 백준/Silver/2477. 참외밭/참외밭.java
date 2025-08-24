import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());

        boolean[] check = new boolean[5];
        int[][] arr = new int[6][2];
        int minusArea = 0;

        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        while(true) {
            boolean isFound = false;

            for (int i = 2; i < 5; i++) {
                if(arr[i][0] == arr[i-2][0] && arr[i+1][0] == arr[i-1][0]) {
                    isFound = true;
                    break;
                }
            }

            if(isFound) break;

            int[] temp = {arr[0][0], arr[0][1]};
            for (int i = 0; i < 5; i++) {
                arr[i][0] = arr[i+1][0];
                arr[i][1] = arr[i+1][1];
            }
            arr[5][0] = temp[0];
            arr[5][1] = temp[1];
        }

        for (int i = 0; i < 6; i++) {
            if(check[arr[i][0]]) {
                if(minusArea == 0) minusArea = arr[i][1] * arr[i-1][1];
                check[arr[i][0]] = false;
            } else {
                check[arr[i][0]] = true;
            }
        }

        int area = 1;
        for (int i = 0; i < 6; i++) {
            if(check[arr[i][0]]) area *= arr[i][1];
        }
        System.out.println((area - minusArea) * k);
    }
}