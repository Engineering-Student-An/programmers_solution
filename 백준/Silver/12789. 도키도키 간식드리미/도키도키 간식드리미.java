import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
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

        int index = 0;
        int num = 1;
        Stack<Integer> line = new Stack<>();
        boolean isPossible = true;
        while(num <= n) {

            if(index >= n) {
                if(line.isEmpty() || line.peek() != num) {
                    isPossible = false;
                    break;
                } else {
                    line.pop();
                }
            } else if(!line.isEmpty() && line.peek() == num) {
                line.pop();
            } else {
                if(arr[index] == num) {
                    index ++;
                } else {
                    while(true) {
                        if(index >= n) {
                            isPossible = false;
                            break;
                        }
                        if(arr[index] == num) {
                            index ++;
                            break;
                        }

                        line.push(arr[index ++]);
                    }

                    if(!isPossible) break;
                }
            }

            num ++;
        }
        System.out.println((isPossible) ? "Nice" : "Sad");
    }
}