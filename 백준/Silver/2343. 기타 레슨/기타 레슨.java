import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        int start = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] > start) start = arr[i];
            end += arr[i];
        }

        System.out.println(findMin(arr, start, end));
    }

    private static int findMin(int[] arr, int start, int end) {

        while(start<=end) {

            int middle = (start + end) / 2;
            int count = 0;
            int sum = 0;

            for (int i = 0; i < n; i++) {
                if(sum + arr[i] > middle) {
                    sum = 0;
                    count ++;
                }

                if(count > m) break;

                sum += arr[i];
            }
            count++;

            if(count > m) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }

        return start;
    }
}