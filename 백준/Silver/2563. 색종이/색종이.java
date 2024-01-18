import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[][] arr = new int[100][100];
        int n = scanner.nextInt();
        for (int ni = 0; ni < n; ni++) {
            int left = scanner.nextInt();
            int down = scanner.nextInt();

            for (int i = 99 - down - 9; i <= 99 - down; i++) {
                for (int j = left; j < left + 10; j++) {
                    arr[i][j] = 1;
                }
            }
        }

        int count = 0;
        for (int[] ints : arr) {
            for (int anInt : ints) {
                if(anInt == 1) count ++;
            }
        }
        System.out.println(count);
    }
}