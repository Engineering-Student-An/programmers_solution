import java.util.Scanner;

public class Main {

    static StringBuilder sb;
    static int n;
    static int m;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        sb = new StringBuilder();

        int[] arr = new int[m+1];
        make(1, arr);

        System.out.print(sb);
    }

    private static void make(int count, int[] arr) {

        if(count > m) {
            for (int i = 1; i <= m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int j = 1; j <= n; j++) {
            arr[count] = j;
            make(count+1, arr);
        }
    }
}