import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(scanner.nextInt());
        }
        Collections.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (Integer integer : arr) {
            sb.append(integer);
            sb.append('\n');
        }
        System.out.print(sb);
    }
}