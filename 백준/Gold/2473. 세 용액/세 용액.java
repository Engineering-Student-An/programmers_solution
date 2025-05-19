import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static long[] arr;
    static long[] liquid = new long[3];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        boolean found = false;
        long min = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i+2; j < n; j++) {
                long twoSum = arr[i] + arr[j];

                int foundIndex = binarySearch(i + 1, j - 1, twoSum * -1);
                long threeSum = twoSum + arr[foundIndex];

                if(Math.abs(min) > Math.abs(threeSum)) {
                    min = threeSum;
                    liquid = new long[]{arr[i], arr[foundIndex], arr[j]};
                }
                if(threeSum == 0)  {
                    found = true;
                    break;
                }
            }
            if(found) break;
        }

        for (int i = 0; i < 3; i++) {
            System.out.print(liquid[i] + " ");
        }
    }

    static int binarySearch(int start, int end, long num) {

        int closest = start;

        while(start <= end) {
            int middle = (start + end) / 2;

            if(Math.abs(num - arr[middle]) < Math.abs(num - arr[closest])) {
                closest = middle;
            }

            if(arr[middle] == num) return middle;
            else if(arr[middle] < num){
                start = middle + 1;
            }
            else {
                end = middle - 1;
            }
        }

        return closest;
    }
}