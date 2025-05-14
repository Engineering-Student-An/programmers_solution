import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int[] arr, seq;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        seq = new int[n];
        int[] count = new int[n];

        count[0] = 1;
        seq[0] = arr[0];
        int size = 1;

        for (int i = 1; i < n; i++) {
            int nextIndex = findIndex(0, size - 1, arr[i]);
            count[i] = nextIndex + 1;
            seq[nextIndex] = arr[i];

            if(nextIndex >= size) size ++;
        }

        int max = -1;
        int index = -1;
        for (int i = 0; i < n; i++) {
            if(max < count[i]) {
                max = count[i];
                index = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(max).append("\n");
        Stack<Integer> stack = new Stack<>();
        for (int i = index; i >= 0; i--) {
            if(count[i] == max) {
                stack.add(arr[i]);
                max --;
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
    }

    static int findIndex(int start, int end, int num) {

        while(start <= end) {
            int middle = (start + end) / 2;
            if(seq[middle] == num) return middle;

            if(seq[middle] > num) end = middle-1;
            else start = middle+1;
        }

        return start;
    }
}