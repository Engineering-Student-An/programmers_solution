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

        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        result = new int[n];
        result[0] = arr[0];
        int index = 0;

        for (int i = 1; i < n; i++) {
            if(result[index] < arr[i]) result[++ index] = arr[i];

            else {
                int findIndex = findIndex(0, index, arr[i]);
                result[findIndex] = arr[i];
            }
        }
        System.out.println(n - (index + 1));
    }

    static int findIndex(int l, int r, int num) {

        while(l <= r) {
            int m = (l + r) / 2;

            if(result[m] == num) return m;

            if(result[m] > num) r = m - 1;
            else l = m + 1;
        }

        return l;
    }
}