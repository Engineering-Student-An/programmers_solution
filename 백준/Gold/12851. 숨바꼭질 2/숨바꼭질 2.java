import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int n;
    static int k;
    static boolean[] visit;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();

        visit = new boolean[2000000];

        long[] results = find();
        System.out.print(results[0] + "\n" + results[1]);
    }

    static long[] find() {

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(n, 0));

        boolean isFound = false;
        long result = Integer.MAX_VALUE;
        long count = 0;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            visit[now.index] = true;

            if(!isFound && now.index == k) {
                isFound = true;
                result = now.count;
                count ++;
            } else if(isFound && now.count == result  && now.index == k) {
                count ++;
            } else if(isFound && now.count > result) {
                break;
            }

            int minus = now.index - 1;
            int plus = now.index + 1;
            int multiply = now.index * 2;

            if(minus >= 0 && !visit[minus]) {
                queue.add(new Node(minus, now.count + 1));
            }

            if(plus < 2000000 && !visit[plus]) {
                queue.add(new Node(plus, now.count + 1));
            }

            if(multiply>=0 && multiply < 2000000 && !visit[multiply]) {
                queue.add(new Node(multiply, now.count + 1));
            }
        }

        return new long[] {result, count};
    }

    static class Node {
        int index;
        int count;

        public Node(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }
}