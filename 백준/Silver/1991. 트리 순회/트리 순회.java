import java.io.IOException;
import java.util.Scanner;

public class Main {

    static char[][] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();
        arr = new char[n][3];
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();

            String[] split = line.split(" ");

            arr[split[0].charAt(0) - 'A'][1] = split[0].charAt(0);
            arr[split[0].charAt(0) - 'A'][0] = split[1].charAt(0);
            arr[split[0].charAt(0) - 'A'][2] = split[2].charAt(0);
        }

        first(0, 1);
        sb.append("\n");
        second(0, 1);
        sb.append("\n");
        third(0, 1);

        System.out.println(sb);
    }

    private static void first(int i, int j) {

        if(arr[i][j] == '.') return;

        sb.append(arr[i][j]);

        if(arr[i][j-1] != '.') first(arr[i][j-1] - 'A', 1);
        if(arr[i][j+1] != '.') first(arr[i][j+1] - 'A', 1);

    }

    private static void second(int i, int j) {

        if(arr[i][j] == '.') return;

        if(arr[i][j-1] != '.') second(arr[i][j-1] - 'A', 1);
        sb.append(arr[i][j]);
        if(arr[i][j+1] != '.') second(arr[i][j+1] - 'A', 1);

    }

    private static void third(int i, int j) {

        if(arr[i][j] == '.') return;

        if(arr[i][j-1] != '.') third(arr[i][j-1] - 'A', 1);
        if(arr[i][j+1] != '.') third(arr[i][j+1] - 'A', 1);
        sb.append(arr[i][j]);
    }
}