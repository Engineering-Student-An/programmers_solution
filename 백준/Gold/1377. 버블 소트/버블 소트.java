import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        PriorityQueue<Data> q = new PriorityQueue<>(new QComparator());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            q.add(new Data(arr[i], i));
        }
        int max = -1;
        for (int i = 0; i < n; i++) {
            Data data = q.poll();
            if(max < data.index - i) max = data.index - i;
        }

        System.out.println(max + 1);

    }

    static class Data {
        int value;
        int index;

        public Data(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    static class QComparator implements Comparator<Data> {

        @Override
        public int compare(Data o1, Data o2) {
            if(o1.value == o2.value) {
                return o1.index - o2.index;
            }
            return o1.value - o2.value;
        }
    }
}