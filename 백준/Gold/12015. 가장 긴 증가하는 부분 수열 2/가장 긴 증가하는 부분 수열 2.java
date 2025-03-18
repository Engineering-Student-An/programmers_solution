import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] arr;
    static int[] result;

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
        int index = 1;

        for (int i = 1; i < n; i++) {
            if(arr[i] > result[index - 1]) {
                result[index] = arr[i];
                index ++;
            } else if(arr[i] < result[index - 1]){
                int tempIndex = find(0, index-1, arr[i]);
                result[tempIndex] = Math.min(result[tempIndex], arr[i]);
            }
        }

        int len = 0;
        for (int i = 0; i < n; i++) {
            if(result[i] == 0) break;
            len ++;
        }

        System.out.println(len);
    }

    static int find(int start, int end, int num) {

        int middle;
        while (start <= end) {

            middle = (start + end) / 2;

            if (result[middle] == num) {
                return middle;
            } else if (result[middle] < num) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }

        return start;
    }
}