import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());

        int[] arr = new int[n];
        int[] ans = new int[n];

        String[] strings = bufferedReader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(strings[i]);
            ans[i] = -1;
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if(stack.isEmpty()) {
                stack.push(i);
            } else {
                while(!stack.isEmpty()) {
                    int top = stack.peek();
                    if(arr[top] < arr[i]) {
                        ans[top] = arr[i];
                        stack.pop();
                    } else {
                        break;
                    }
                }
                stack.push(i);
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int an : ans) {
            bw.write(an + " ");
        }
        bw.flush();
        bw.close();
    }

}