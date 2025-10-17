import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static Info[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new Info[4];
        for (int i = 1; i <= 3; i++) {
            arr[i] = new Info(i, 0, 0, 0, 0);
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            plus(1, a);
            plus(2, b);
            plus(3, c);
        }

        PriorityQueue<Info> queue = new PriorityQueue<>();
        for (int i = 1; i <= 3; i++) {
            queue.add(arr[i]);
        }

        Info first = queue.poll();
        Info second = queue.poll();

        if(first.total == second.total && first.three == second.three && first.two == second.two) {
            System.out.println(0 + " " + first.total);
        } else {
            System.out.println(first.num + " " + first.total);
        }
    }

    static void plus(int num, int score) {
        if(score == 1) {
            arr[num].total += 1;
            arr[num].one ++;
        } else if(score == 2) {
            arr[num].total += 2;
            arr[num].two ++;
        } else {
            arr[num].total += 3;
            arr[num].three ++;
        }
    }

    static class Info implements Comparable<Info> {
        int num, total, one, two, three;

        public Info(int num, int total, int one, int two, int three) {
            this.num = num;
            this.total = total;
            this.one = one;
            this.two = two;
            this.three = three;
        }

        @Override
        public int compareTo(Info o) {
            if(this.total == o.total) {
                if(this.three == o.three) {
                    return Integer.compare(o.two, this.two);
                }
                return Integer.compare(o.three, this.three);
            }
            return Integer.compare(o.total, this.total);
        }
    }
}