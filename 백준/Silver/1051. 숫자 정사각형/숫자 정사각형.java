import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] arr = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            String string = scanner.next();
            for (int j = 0; j < m; j++) {
                arr[i][j+1] = (int) (string.charAt(j)-'0');
            }
        }
        int answer = 51;
        Boolean solve = false;
        for (int i = Math.min(n, m); i > 1; i--) {
            for (int i1 = 1; i1 <= n-i+1; i1++) {
                for(int j1 = 1; j1 <= m-i+1; j1++){
                    int check = arr[i1][j1];
                    if(arr[i1+i-1][j1] == check && arr[i1][j1+i-1] == check && arr[i1+i-1][j1+i-1] == check){
                        solve = true;
                        answer = i;
                    }
                    if(solve) break;
                }
                if(solve) break;
            }
            if(solve) break;
        }

        if(answer == 51) answer = 1;
        System.out.println(answer*answer);
    }
}