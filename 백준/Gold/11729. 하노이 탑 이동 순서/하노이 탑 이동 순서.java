import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Integer[]> arr;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        arr = new ArrayList<>();
        hanoi(n, 1, 3, 2);

        System.out.println(arr.size());

        StringBuilder sb = new StringBuilder();

        for (Integer[] integers : arr) {
            for (Integer integer : integers) {
                sb.append(integer);
                sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void hanoi(int n, int start, int destination, int temp) {
        if(n == 1){
            arr.add(new Integer[]{start, destination});
            return;
        }
        hanoi(n - 1, start, temp, destination);
        arr.add(new Integer[]{start, destination});
        hanoi(n-1, temp, destination, start);
    }
}

