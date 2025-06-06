import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static long result = 0;
    static int[] arr;
    static int[] temp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        temp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(0, n-1);

        System.out.println(result);
    }

    static void mergeSort(int start, int end) {

        if(start >= end) return;

        int middle = (start + end) / 2;

        mergeSort(start, middle);
        mergeSort(middle + 1, end);

        for (int i = start; i <= end; i++) {
            temp[i] = arr[i];
        }

        int left = start;
        int right = middle + 1;
        int index = start;

        while(left <= middle && right <= end) {
            if(temp[left] <= temp[right]) {
                arr[index ++] = temp[left ++];
            } else {
                result += (right - index);
                arr[index++] = temp[right++];
            }
        }

        while(left <= middle) {
            arr[index ++] = temp[left ++];
        }
        while(right <= end) {
            arr[index ++] = temp[right ++];
        }
    }
}