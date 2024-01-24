import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        int[][] arr = new int[101][101];
        for (int i = 0; i < 4; i++) {
            int fc = scanner.nextInt();
            int fr = scanner.nextInt();
            int sc = scanner.nextInt();
            int sr = scanner.nextInt();

            for (int j = fr; j < sr; j++) {
                for (int k = fc; k < sc; k++) {
                    arr[j][k] = 1;
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                if(arr[i][j] == 1) cnt ++;
            }
        }
        System.out.println(cnt);

    }
}
