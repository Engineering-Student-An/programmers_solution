import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        ArrayList<Integer> check = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        search(n, m, check, sb);
        System.out.print(sb);
    }

    private static void search(int n, int m, ArrayList<Integer> check, StringBuilder sb) {
        if(check.size() == m) {
            for (Integer integer : check) {
                sb.append(integer);
                sb.append(" ");
            }
            sb.append("\n");
        }
        for (int i = 1; i <= n; i++) {
            if(!check.contains(i) && (check.isEmpty() || check.get(check.size()-1) < i)){
                check.add(i);
                search(n, m, check, sb);
                check.remove(check.indexOf(i));
            }
        }
    }
}
