import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] arr, result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int index = 0;
        result = new int[n];
        result[0] = arr[0];
        for (int i = 1; i < n; i++) {
            if(result[index] < arr[i]) result[++ index] = arr[i];
            else result[findIndex(index, arr[i])] = arr[i];
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if(result[i] == 0) break;
            count ++;
        }

        System.out.println(count);
    }

    static int findIndex(int right, int num) {

        int left = 0;
        while(left <= right) {
            int middle = (left + right) / 2;

            if(result[middle] > num) right = middle - 1;
            else left = middle + 1;
        }

        return left;
    }
}