import java.util.Scanner;

public class Main {

    public static class dir{
        static int[] row = {-1, -1, 0, 1, 1,  1, 0, -1};
        static int[] col = {0, 1, 1, 1, 0, -1, -1, -1};
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String line = scanner.next();
            for (int j = 0; j < n; j++) {
                if(line.charAt(j) == '.'){
                    arr[i][j] = 0;
                } else{
                    arr[i][j] = (int) (line.charAt(j) - '0');
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j] != 0){
                    sb.append('*');
                    continue;
                }
                int cnt = 0;
                for (int d = 0; d < 8; d++) {
                    if (i + dir.row[d] >= 0 && i + dir.row[d] < n && j + dir.col[d] >= 0 && j + dir.col[d] < n) {
                        cnt += arr[i+dir.row[d]][j+dir.col[d]];
                    }
                }if(cnt >= 10){
                    sb.append('M');
                } else {
                    sb.append(cnt);
                }
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}