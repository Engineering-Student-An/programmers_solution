import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static boolean[] visit = new boolean[1000000];

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        System.out.println(bfs(new Node(n, 0), k));
    }

    static long bfs(Node node, int k) {

        long result = 0;

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (true) {
            Node poll = queue.poll();
            visit[(int) poll.index] = true;

            if(poll.index == k) {
                result = poll.time;
                break;
            }

            if(poll.index > 0 && !visit[(int) (poll.index - 1)]) {
                queue.add(new Node(poll.index - 1, poll.time + 1));
            }
            if(!visit[(int) (poll.index + 1)]) {
                queue.add(new Node(poll.index + 1, poll.time + 1));
            }
            if(poll.index <= 100000 && !visit[(int) (poll.index * 2)]) {
                queue.add(new Node(poll.index * 2, poll.time + 1));
            }
        }

        return result;
    }

    static class Node {
        long index;
        long time;

        public Node(long index, long time) {
            this.index = index;
            this.time = time;
        }
    }
}