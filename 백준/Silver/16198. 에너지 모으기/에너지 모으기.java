import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, result = 0;
    static int[] arr, temp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n - 1; i++) {
            temp = new int[n];
            for (int j = 0; j < n; j++) {
                temp[j] = arr[j];
            }

            temp[i] = 0;
            find(1,temp[i-1] * temp[i+1]);
        }

        System.out.println(result);
    }

    static void find(int count, int sum) {
        if(count == n-2) {
            result = Math.max(result, sum);
            return;
        }

        for (int i = 1; i < n - 1; i++) {
            if(temp[i] > 0) {
                temp[i] = 0;
                find(count + 1, sum + calc(i));
                temp[i] = arr[i];
            }
        }
    }

    static int calc(int index) {
        int left = index - 1;
        while(left >= 0 && temp[left] == 0) {
            left --;
        }

        int right = index + 1;
        while(right < n && temp[right] == 0) {
            right ++;
        }

        return temp[left] * temp[right];
    }
}