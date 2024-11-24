import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean[][] check = new boolean[6][6];

        boolean result = true;

        int[] row = new int[36];
        int[] col = new int[36];

        for (int i = 0; i < 36; i++) {
            String line = scanner.next();
            row[i] = 6 - Integer.parseInt(String.valueOf(line.charAt(1)));
            col[i] = line.charAt(0) - 'A';

            // 방문 했는지
            if(check[row[i]][col[i]]) {
                result = false;
                break;
            }
            check[row[i]][col[i]] = true;

            // 이동 가능한지
            if(i > 0) {
                int rowDiff = Math.abs(row[i] - row[i - 1]);
                int colDiff = Math.abs(col[i] - col[i - 1]);

                if(! ((rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2))) {
                    result = false;
                    break;
                }
            }
        }

        int rowD = Math.abs(row[35] - row[0]);
        int colD = Math.abs(col[35] - col[0]);

        if(! ((rowD == 2 && colD == 1) || (rowD == 1 && colD == 2))) {
            result = false;
        }

        System.out.println(result ? "Valid" : "Invalid");
    }
}