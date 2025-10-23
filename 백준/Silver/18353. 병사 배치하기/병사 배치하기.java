import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[n];
        result[0] = arr[0];

        int index = 1;
        for (int i = 1; i < n; i++) {
            if(result[index - 1] > arr[i]) result[index ++] = arr[i];
            else {
                int findIndex = findIndex(index, result, arr[i]);
                result[findIndex] = arr[i];
            }

//            for (int j = 0; j < index; j++) {
//                System.out.print(result[j] + " ");
//            }
//            System.out.println();
        }



        System.out.println(n - index);
    }

    static int findIndex(int index, int[] result, int num) {
        int l = 0, r = index - 1;
        while(l <= r) {
            int m = (l + r) / 2;
            if(result[m] == num) return m;

            if(result[m] < num) r = m - 1;
            else l = m + 1;
        }

        return l;
    }
}