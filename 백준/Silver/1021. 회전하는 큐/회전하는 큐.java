import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        int n = scanner.nextInt();

        List<Integer> arr = new ArrayList();

        for (int i = 0; i < size; i++) {
            arr.add(i + 1);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            int want = scanner.nextInt();
            if(want != arr.get(0)){
                int index = arr.indexOf(want);

                count += Math.min((index), (arr.size() - index));

                while(arr.get(0) != want){
                    arr.add(arr.get(0));
                    arr.remove(0);
                }

            }
            arr.remove(0);

        }

        System.out.println(count);
    }
}