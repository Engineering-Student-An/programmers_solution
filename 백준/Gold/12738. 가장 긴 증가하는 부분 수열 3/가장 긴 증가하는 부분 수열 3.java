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
        int index = 1;
        for (int i = 1; i < n; i++) {
            if(arr[i] > result[index - 1]) result[index ++] = arr[i];
            else if(arr[i] < result[index - 1]){
                int nextIndex = find(index - 1, arr[i]);
                result[nextIndex] = arr[i];
            }
        }

        System.out.println(index);
    }

    static int find(int right, int num) {
        int left = 0;
        while(left <= right) {
            int middle = (left + right) / 2;
            if(result[middle] == num) return middle;

            else if(result[middle] > num) right = middle - 1;
            else left = middle + 1;
        }

        return left;
    }
}