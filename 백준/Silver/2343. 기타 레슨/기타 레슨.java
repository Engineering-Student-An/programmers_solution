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

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        int start = 1;
        int end = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            end += arr[i];
        }

        while(start <= end) {

            int middle = (start + end) / 2;
            int count = 1;
            int sum = 0;

            for (int i = 0; i < n; i++) {
                if(arr[i] > middle) {
                    count = m+1;
                    break;
                }

                if(sum + arr[i] > middle) {
                    sum = arr[i];
                    count ++;
                } else {
                    sum += arr[i];
                }
            }

            if(count <= m) {
                end = middle-1;
            } else {
                start = middle + 1;
            }
        }

        System.out.println(start);
    }
}