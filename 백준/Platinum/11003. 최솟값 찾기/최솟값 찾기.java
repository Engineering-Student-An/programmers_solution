import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Data> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            Data data = new Data(arr[i], i);

            while(!deque.isEmpty() && deque.getLast().value > data.value) {
                deque.removeLast();
            }
            deque.addLast(data);

            if(i-deque.getFirst().index >= l) {
                deque.removeFirst();
            }

            bw.write(deque.getFirst().value + " ");
        }

        bw.flush();
        bw.close();
        System.out.println(bw);
    }

    static class Data {
        int value;
        int index;

        public Data(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}