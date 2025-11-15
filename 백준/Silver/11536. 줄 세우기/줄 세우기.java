import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];
        String[] increasing = new String[n];
        String[] decreasing = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
            increasing[i] = arr[i];
            decreasing[i] = arr[i];
        }

        Arrays.sort(increasing);
        Arrays.sort(decreasing, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        boolean isIncrease = true, isDecrease = true;
        for (int i = 0; i < n; i++) {
            if(!arr[i].equals(increasing[i])) isIncrease = false;
            if(!arr[i].equals(decreasing[i])) isDecrease = false;
        }

        if(isIncrease) System.out.println("INCREASING");
        else if(isDecrease) System.out.println("DECREASING");
        else System.out.println("NEITHER");
    }
}