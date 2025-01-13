import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int n;
    static int m;
    static List<Node> chicken;
    static List<Node> house;
    static List<Node> visit = new ArrayList<>();
    static long min = Integer.MAX_VALUE;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();

        chicken = new ArrayList<>();
        house = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = scanner.nextInt();

                if(num == 1) {
                    house.add(new Node(i, j));
                } else if(num == 2) {
                    chicken.add(new Node(i, j));
                }
            }
        }
        select(0, 0);

        System.out.println(min);
    }

    public static void select(int index, int count) {

        if(count == m) {
            long result = calc();
            min = Math.min(min, result);
            return;
        }

        for (int i = index; i < chicken.size(); i++) {
            Node node = chicken.get(i);
            visit.add(node);
            select(i+1, count + 1);
            visit.remove(node);
        }

    }

    public static long calc() {
        long result = 0;
        for (Node from : house) {
            long minDistance = Integer.MAX_VALUE;
            for (Node to : visit) {
                long distance = Math.abs(from.row - to.row) + Math.abs(from.col - to.col);
                minDistance = Math.min(minDistance, distance);
            }
            result += minDistance;
        }
        return result;
    }

    static class Node {
        int row;
        int col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}