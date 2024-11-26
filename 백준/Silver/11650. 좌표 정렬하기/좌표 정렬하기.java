import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[][] arr = new int [n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
        }

        Arrays.sort(arr, new AComparator());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static class AComparator implements Comparator<int[]> {

        @Override
        public int compare(int[] o1, int[] o2) {
            if(o1[0] == o2[0]) {
                return o1[1]-o2[1];
            }

            return o1[0] - o2[0];
        }
    }
}