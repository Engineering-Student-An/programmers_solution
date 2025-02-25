import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String first = scanner.nextLine();
        String second = scanner.nextLine();

        int f = first.length();
        int s = second.length();
        int[][] lcs = new int[f + 1][s + 1];

        for (int i = 1; i < f + 1; i++) {
            for (int j = 1; j < s + 1; j++) {

                if(first.charAt(i-1) == second.charAt(j-1)) {
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
                }
            }
        }

        int len = lcs[f][s];
        System.out.println(len);

        if (len > 0) {
            int row = f;
            int col = s;
            String result = "";

            while(row >= 1 && col >= 1) {
                if(first.charAt(row - 1) == second.charAt(col - 1)) {
                    result += first.charAt(row - 1);
                    row --;
                    col --;
                } else {
                    if(lcs[row-1][col] > lcs[row][col-1]) {
                        row --;
                    } else {
                        col --;
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = result.length() - 1; i >= 0; i--) {
                sb.append(result.charAt(i));
            }

            System.out.print(sb);
        }
    }
}