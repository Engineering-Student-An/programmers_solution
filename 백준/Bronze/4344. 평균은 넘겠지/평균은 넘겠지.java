import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] arr = new int [n];

            double sum = 0;
            double avg = 0;
            for (int j = 0; j < n; j++) {
                arr[j] = scanner.nextInt();
                sum += (double) arr[j];
            }
            avg = sum / n;

            int chk = 0;
            for (int j = 0; j < n; j++) {
                if(arr[j] > avg) {
                    chk ++;
                }
            }
            avg = (double) chk/n * 100;
            sb.append(String.format("%.3f",avg));
            sb.append("%");
            sb.append("\n");

        }

        System.out.print(sb);

    }
}