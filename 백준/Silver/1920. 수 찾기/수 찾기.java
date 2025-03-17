import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int t = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int find = Integer.parseInt(st.nextToken());

            sb.append(isExist(find)).append("\n");
        }

        System.out.print(sb);
    }

    static int isExist(int num) {

        int left = 0;
        int right = n-1;
        int middle = 0;

        while (left <= right) {
            middle = (left + right) / 2;

            if(arr[middle] == num) return 1;

            else if(arr[middle] > num) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return (arr[middle] == num) ? 1 : 0;
    }
}