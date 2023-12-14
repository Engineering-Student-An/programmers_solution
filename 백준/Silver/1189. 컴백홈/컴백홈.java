import java.util.Scanner;


public class Main{
    public static int answer = 0;
    public static class Dir{
        static int[] nextRow = {-1, 0, 1, 0};
        static int[] nextCol = {0, 1, 0, -1};
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] arr = new int [r][c];
        int[][] chk = new int [r][c];
        for (int i = 0; i < r; i++) {
            String tmp = scanner.next();
            for (int j = 0; j < c; j++) {
                arr[i][j] = (tmp.charAt(j) == '.') ? 0 : 1;
            }
        }
        chk[r-1][0] = 1;
        dfs(arr, chk, r-1, 0, 1, k);

        System.out.println(answer);
    }

    private static void dfs(int[][] arr, int[][] chk, int r, int c, int distance, int k) {
        if(distance == k){
            if(r==0 && c ==arr[0].length-1){
                answer ++;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextRow = r+Dir.nextRow[i];
            int nextCol = c+Dir.nextCol[i];
            if(nextRow >= 0 && nextRow < arr.length && nextCol >= 0 && nextCol<arr[0].length
                    && chk[nextRow][nextCol] == 0 && arr[nextRow][nextCol] == 0){
                chk[nextRow][nextCol] = 1;
                dfs(arr, chk, nextRow, nextCol, distance+1, k);
                chk[nextRow][nextCol] = 0;
            }
        }
    }
}