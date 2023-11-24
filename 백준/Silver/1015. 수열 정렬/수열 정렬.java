import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] a = new int[n];
        int[] b = new int[n];
        int[] p = new int[n];
        Boolean[] check = new Boolean[n];
        Arrays.fill(check, false);

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        b = a.clone();  Arrays.sort(b);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i] == b[j] && check[j] == false) {
                    check[j]=true;
                    p[i]=j;
                    break;
                }
            }
        }

        for (int i : p) {
            System.out.print(i + " ");
        }
    }
}