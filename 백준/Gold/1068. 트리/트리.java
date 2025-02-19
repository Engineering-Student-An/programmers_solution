import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Integer>[] adjacencyList;
    static int[] arr;
    static boolean[] visit;
    static int result;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        adjacencyList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        arr = new int[n];
        visit = new boolean[n];
        int parent = 0;
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            arr[i] = num;
            if(num >= 0) {
                adjacencyList[num].add(i);
            } else {
                parent = i;
            }
        }
        int target = scanner.nextInt();

        dfs(parent, target);

        System.out.println(result);
    }

    static void dfs(int node, int target) {

        if(node == target) {
            return;
        }
        boolean check = false;

        for (Integer i : adjacencyList[node]) {
            if(i != target && !visit[i]) {
                visit[i] = true;
                dfs(i, target);
                check = true;
            }
        }

        if(!check) {
            result ++;
        }
    }
}