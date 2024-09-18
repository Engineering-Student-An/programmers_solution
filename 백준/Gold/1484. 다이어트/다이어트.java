import java.util.Scanner;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int g = scanner.nextInt();

        int fin = g/2+1;
        int start_idx = 1;
        int end_idx = 2;
        StringBuilder sb = new StringBuilder();
        while (end_idx <= fin) {
            int result = (int) (pow(end_idx, 2) - pow(start_idx, 2));
            if (result == g) {
                sb.append(end_idx).append("\n");
                end_idx ++;
            } else if (result > g) {
                start_idx ++;
            } else {
                end_idx ++;
            }
        }

        System.out.print(sb.length() == 0 ? -1 : sb);
    }
}