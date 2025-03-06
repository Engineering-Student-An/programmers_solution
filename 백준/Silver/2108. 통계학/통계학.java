import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        long sum = 0;
        int max = -5000;
        int min = 5000;
        int[] count = new int[8001];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];

            count[arr[i] + 4000] ++;
            max = Math.max(arr[i], max);
            min = Math.min(arr[i], min);
        }

        Arrays.sort(arr);

        int cntMax = -5000;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 8001; i++) {
            if(cntMax < count[i]) {
                cntMax = count[i];
                list = new ArrayList<>();
                list.add(i - 4000);
            } else if(cntMax == count[i]) {
                list.add(i - 4000);
            }
        }

        int avg = (int) Math.round((double) sum / n);
        System.out.println(avg);
        System.out.println(arr[n/2]);

        if(list.size() > 1) {
            Collections.sort(list);
            System.out.println(list.get(1));
        } else {
            System.out.println(list.get(0));
        }

        System.out.println(max-min);
    }

    static class Info implements Comparable<Info>{

        int value;
        int count;

        public Info(int value, int count) {
            this.value = value;
            this.count = count;
        }

        @Override
        public int compareTo(Info o) {
            if(this.count == o.count) return this.value - o.value;

            return o.count - this.count;
        }
    }
}