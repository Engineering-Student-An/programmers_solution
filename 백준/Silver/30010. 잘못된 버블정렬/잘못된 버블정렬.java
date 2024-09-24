import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        StringBuilder sb = new StringBuilder();

        sb.append(n).append(" ");

        for (int i = 1; i < n; i++) {
            sb.append(i).append(" ");
        }

        System.out.print(sb);
    }
}