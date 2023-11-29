import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            arr.add(i);
        }
        int index = 0;
        ArrayList<Integer> del = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            index = (index+k-1)%(arr.size());
            del.add(arr.get(index));
            arr.remove(index);
        }
        System.out.print("<");
        for (int i = 0; i < del.size(); i++) {
            System.out.print(del.get(i));
            if(i<del.size()-1) System.out.print(", ");
        }
        System.out.println(">");
    }
}