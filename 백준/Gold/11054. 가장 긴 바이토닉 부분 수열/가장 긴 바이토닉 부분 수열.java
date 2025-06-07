import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int a = find(i, arr[i], true);
            int b = find(i, arr[i], false);

            max = Math.max(max, a+b-1);
        }
        System.out.println(max);
    }

    static int find(int m, int num, boolean isLeft) {
        int index = 0;
        int[] bi = new int[1002];
        bi[0] = num;
        if(isLeft) {
            for (int i = m - 1; i >= 0; i--) {
                if(arr[i] < bi[index]) {
                    bi[++index] = arr[i];
                } else if(arr[i] > bi[num]) {
                    int tempIndex = index;
                    while(tempIndex > 0) {
                        if(arr[i] >= bi[tempIndex]) tempIndex --;
                        else break;
                    }
                    if(tempIndex == 0 && arr[i] >= bi[0]) continue;
                    bi[tempIndex + 1] = arr[i];
                }
            }
        } else {
            for (int i = m + 1; i < n; i++) {
                if(arr[i] < bi[index]) {
                    bi[++index] = arr[i];
                } else if(arr[i] > bi[num]) {
                    int tempIndex = index;
                    while(tempIndex > 0) {
                        if(arr[i] >= bi[tempIndex]) tempIndex --;
                        else break;
                    }
                    if(tempIndex == 0 && arr[i] >= bi[0]) continue;
                    bi[tempIndex + 1] = arr[i];
                }
            }
        }

        return index + 1;
    }
}