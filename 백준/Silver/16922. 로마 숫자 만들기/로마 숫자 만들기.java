import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    static int n;
    static int[] num = {1, 5, 10, 50};
    static int[] check;
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        check = new int[4];
        find(0, 0);

        System.out.println(set.size());
    }

    static void find(int index, int count) {
        if(index == 4) {
            int s = 0;
            for (int i = 0; i < 4; i++) {
                s += (check[i] * num[i]);
            }

            set.add(s);
            return;
        }

        if(index == 3) {
            check[index] = n - count;
            find(4, n);
        } else {
            for (int i = 0; i <= n - count; i++) {
                check[index] = i;
                find(index + 1, count + i);
            }
        }
    }
}