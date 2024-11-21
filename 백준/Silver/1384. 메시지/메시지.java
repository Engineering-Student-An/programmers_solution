import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();

        int index = 0;
        while (true) {
            int n = scanner.nextInt();
            if(n == 0) break;

            String[] names = new String[n];
            String[][] p = new String[n][n];

            for (int i = 0; i < n; i++) {
                names[i] = scanner.next();

                for (int j = 1; j < n; j++) {
                    p[i][j] = scanner.next();
                }
            }

            sb.append("Group ").append(++index).append("\n");

            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < n; j++) {
                    if(p[i][j].equals("N")) {
                        count ++;
                        sb.append(names[(i + n-j)%n]).append(" was nasty about ").append(names[i]).append("\n");
                    }
                }
            }

            if(count == 0) sb.append("Nobody was nasty").append("\n");

            sb.append("\n");

        }

        System.out.print(sb);
    }
}