import java.util.HashSet;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        HashSet<Integer> a = new HashSet<>();
        HashSet<Integer> b = new HashSet<>();
        HashSet<Integer> amb = new HashSet<>();
        HashSet<Integer> bma = new HashSet<>();

        for (int i = 0; i < n; i++) {
            a.add(scanner.nextInt());
        }
        for (int i = 0; i < m; i++) {
            b.add(scanner.nextInt());
        }
        amb = (HashSet<Integer>) a.clone();
        bma = (HashSet<Integer>) b.clone();
        amb.removeAll(b);
        bma.removeAll(a);

        int ans = amb.size() + bma.size();
        System.out.println(ans);
    }
}