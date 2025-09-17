import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];


        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) return Integer.compare(o1[0], o2[0]);

                return Integer.compare(o1[1], o2[1]);
            }
        });

        PriorityQueue<Info> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.v, o2.v));
        for (int i = 0; i < n; i++) {
            queue.add(new Info(arr[i][0], arr[i][1]));

            while(queue.size() > arr[i][1]) {
                queue.poll();
            }
        }

        int sum = 0;
        while (!queue.isEmpty()) {
            sum += queue.poll().v;
        }
        System.out.println(sum);
    }

    static class Info {
        int v, d;

        public Info(int v, int d) {
            this.v = v;
            this.d = d;
        }
    }
}