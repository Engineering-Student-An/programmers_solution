import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int it = 0; it < t; it++) {
            int r = scanner.nextInt();
            int c = scanner.nextInt();

            char[][] arr = new char[r][c];
            int[][] check = new int[r][c];
            for (int i = 0; i < r; i++) {
                String line = scanner.next();
                for (int j = 0; j < c; j++) {
                    arr[i][j] = line.charAt(j);
                }
            }

            int ans = 0;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if(arr[i][j] == 'o'){
                        // 위아래 검사
                        if (i - 1 >= 0 && i + 1 < r
                                && arr[i - 1][j] == 'v' && arr[i + 1][j] == '^'
                                && check[i-1][j] == 0 && check[i+1][j] == 0) {
                            check[i-1][j] = 1; check[i][j] = 1; check[i+1][j]=1;
                            ans++;
                        }

                        // 좌우 검사
                        if (j - 1 >= 0 && j + 1 < c
                                && arr[i][j-1] == '>' && arr[i][j+1] == '<'
                                && check[i][j-1] == 0 && check[i][j+1] == 0) {
                            check[i][j-1] = 1; check[i][j] = 1; check[i][j+1]=1;
                            ans++;
                        }
                    }
                }
            }

            System.out.println(ans);



        }
    }
}
