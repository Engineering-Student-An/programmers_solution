import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int[][] rgb = new int[n][3];
        for (int i = 0; i < 3; i++) {
            rgb[0][i] = arr[0][i];
        }
        for (int i = 1; i < n; i++) {
            rgb[i][0] = Math.min(rgb[i-1][1], rgb[i-1][2]) + arr[i][0];
            rgb[i][1] = Math.min(rgb[i-1][0], rgb[i-1][2]) + arr[i][1];
            rgb[i][2] = Math.min(rgb[i-1][0], rgb[i-1][1]) + arr[i][2];
        }

        Arrays.sort(rgb[n-1]);
        System.out.println(rgb[n-1][0]);
    }
}

