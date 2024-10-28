import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int[] temp;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        temp = new int[n];
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(arr, 0, n-1);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i : arr) {
            bw.write(i + "\n");
        }

        bw.flush();
        bw.close();
    }

    private static void mergeSort(int[] arr, int start, int end) {

        if(start >= end) return;

        int middle = (start + end) / 2;

        mergeSort(arr, start, middle);
        mergeSort(arr, middle+1, end);

        for (int i = start; i <= end; i++) {
            temp[i] = arr[i];
        }

        int k = start;
        int pl = start;
        int pr = middle+1;

        while(pl <= middle && pr <= end){
            if(temp[pl] < temp[pr]) {
                arr[k++] = temp[pl++];
            } else {
                arr[k++] = temp[pr++];
            }
        }

        while(pl <= middle) {
            arr[k++] = temp[pl++];
        }
        while(pr <= end) {
            arr[k++] = temp[pr++];
        }
    }
}