import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        List<Integer> arr = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            arr.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int index = 0;
        while (!arr.isEmpty()) {
            index = (index + k-1) % arr.size();

            Integer remove = arr.remove(index);
            sb.append(remove).append((arr.isEmpty()) ? "" : ", ");
        }

        sb.append(">");

        System.out.print(sb);
    }
}