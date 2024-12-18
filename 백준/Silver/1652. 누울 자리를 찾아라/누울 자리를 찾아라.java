import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        char[][] arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = scanner.next();
            for (int j = 0; j < n; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        int rowSum = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;

            for (int j = 0; j < n; j++) {
                if(arr[i][j] == 'X') {
                    if(sum >= 2) {
                        rowSum ++;
                    }
                    sum = 0;
                }
                else {
                    sum ++;
                }
            }

            if(sum >= 2) {
                rowSum ++;
            }
        }

        int colSum = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;

            for (int j = 0; j < n; j++) {
                if(arr[j][i] == 'X') {
                    if(sum >= 2) {
                        colSum ++;
                    }
                    sum = 0;
                }
                else {
                    sum ++;
                }
            }

            if(sum >= 2) {
                colSum ++;
            }
        }

        System.out.println(rowSum + " " + colSum);
    }
}