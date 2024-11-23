import java.util.Scanner;

public class Main {

    static int[] city;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] adjMatrix = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                adjMatrix[i][j] = scanner.nextInt();
            }
        }

        city = new int[n+1];
        for (int i = 1; i <= n; i++) {
            city[i] = i;
        }

        int[] plan = new int[m];
        for (int i = 0; i < m; i++) {
            plan[i] = scanner.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(adjMatrix[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        int result = find(plan[0]);
        boolean chk = true;
        for (int i = 1; i < m; i++) {
            if(result!=find(plan[i])) {
                chk = false;
                break;
            }
        }
        System.out.println((chk) ? "YES" : "NO");
    }

    public static void union(int i, int j) {
        i = find(i);
        j = find(j);

        if(i!=j) {
            city[i] = j;
        }
    }

    private static int find(int i) {
        if(i == city[i]) {
            return i;
        } else {
            return city[i] = find(city[i]);
        }
    }
}