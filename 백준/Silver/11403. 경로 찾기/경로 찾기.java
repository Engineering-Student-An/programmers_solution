import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[][] adjacencyMatrix;
    static int n;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();

        adjacencyMatrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjacencyMatrix[i][j] = scanner.nextInt();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            boolean[] visit = new boolean[n];
            bfs(i, visit);

            for (int j = 0; j < n; j++) {
                sb.append( (visit[j]) ? 1 : 0).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    public static void bfs(int v, boolean[] visit) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);

        while (!queue.isEmpty()) {

            Integer poll = queue.poll();
            for (int i = 0; i < n; i++) {
                if(adjacencyMatrix[poll][i] == 1 && !visit[i]) {
                    queue.add(i);
                    visit[i] = true;
                }
            }
        }
    }
}