import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(0, n-1, arr);

        System.out.print(arr[k-1]);
    }

    private static void quickSort(int start, int end, int[] arr) {

        int left = start;
        int right = end;
        int pivot = arr[(start + end) / 2];
        do {
            while(arr[left] < pivot) left ++;
            while(arr[right] > pivot) right --;
            if(left <= right) swap(left ++, right --, arr);
        } while(left <= right);

        if(start < right) quickSort(start, right, arr);
        if(end > left) quickSort(left, end, arr);
    }

    private static void swap(int left, int right, int[] arr) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}