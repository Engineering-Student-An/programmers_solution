import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] arr;
    static int[] temp;
    static long result = 0;

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

        int index = start;
        int left = start;
        int right = middle + 1;
        while(left <= middle && right <= end) {
            int l = arr[left];
            int r = arr[right];

            if(l <= r) {
                temp[index ++] = l;
                left ++;
            } else {
                temp[index ++] = r;
                result += (right - index + 1);
                right ++;
            }
        }

        while(left <= middle) {
            temp[index ++] = arr[left ++];
        }
        while(right <= end) {
            temp[index ++] = arr[right ++];
        }

        for (int i = start; i <= end; i++) {
            arr[i] = temp[i];
        }
    }
}