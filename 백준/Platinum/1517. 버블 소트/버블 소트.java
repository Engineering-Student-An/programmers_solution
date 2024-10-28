import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static Long count = 0L;
    static Data[] temp;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Data[] arr = new Data[n];
        temp = new Data[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = new Data(Integer.parseInt(st.nextToken()), i);
        }

        mergeSort(arr, 0, n-1);

        System.out.println(count);
    }

    private static void mergeSort(Data[] arr, int start, int end) {

        if(start >= end) return;

        int middle = (start+end)/2;

        mergeSort(arr, start, middle);
        mergeSort(arr, middle + 1, end);

        for (int i = start; i <= end; i++) {
            temp[i] = arr[i];
        }

        int k = start;
        int pl = start;
        int pr = middle+1;
        while(pl <= middle && pr <= end) {
            if(temp[pl].value <= temp[pr].value) {
                arr[k] = temp[pl ++];
                arr[k].index = k;
                k++;
            } else {
                arr[k] = temp[pr ++];
                count += arr[k].index-k;
                arr[k].index = k;
                k++;
            }
        }

        while(pl <= middle) {
            arr[k] = temp[pl ++];
            arr[k].index = k;
            k++;
        }

        while(pr <= end) {
            arr[k] = temp[pr ++];
            arr[k].index = k;
            k++;
        }


    }

    public static class Data {
        int value;
        int index;

        public Data(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}