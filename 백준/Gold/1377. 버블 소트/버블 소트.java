import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        Ddata[] sorted = new Ddata[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sorted[i] = new Ddata(arr[i], i);
        }

        Arrays.sort(sorted);

        int max = -1;
        for (int i = 0; i < n; i++) {
            if(sorted[i].index - i > max) {
                max = sorted[i].index - i;
            }
        }
        System.out.println(max + 1);
    }

    static class Ddata implements Comparable<Ddata>{
        int value;
        int index;

        public Ddata(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Ddata o) {
            return this.value - o.value;
        }
    }
}