import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String first = scanner.next();
        String second = scanner.next();

        int[][] arr = new int[first.length() + 1][second.length() + 1];

        for (int i = 0; i <= first.length(); i++) {
            for (int j = 0; j <= second.length(); j++) {
                if(i == 0 || j == 0) {
                    arr[i][j] = 0;
                }
                else if(first.charAt(i-1) != second.charAt(j-1)) {
                    arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1]);
                } else {
                    arr[i][j] = arr[i-1][j-1] + 1;
                }
            }
        }

        System.out.println(arr[first.length()][second.length()]);
    }
}