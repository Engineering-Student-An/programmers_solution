import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int time = 1;
        int index = 1;
        int total = arr[0];
        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(1, arr[0]));

        while (!queue.isEmpty()) {
            time ++;
            if(time - queue.peek().start >= w) {
                total -= queue.peek().weight;
                queue.poll();
            }

            if(index < n && total + arr[index] <= l) {
                queue.add(new Info(time, arr[index]));
                total += arr[index ++];
            }
        }

        System.out.println(time);
    }

    static class Info {
        int start;
        int weight;

        public Info(int start, int weight) {
            this.start = start;
            this.weight = weight;
        }
    }
}