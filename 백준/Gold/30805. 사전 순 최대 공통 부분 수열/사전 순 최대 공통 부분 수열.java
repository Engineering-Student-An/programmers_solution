import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int[] arr = new int[a];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int b = Integer.parseInt(br.readLine());
        int[] brr = new int[b];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) {
            brr[i] = Integer.parseInt(st.nextToken());
        }

        PriorityQueue<Info> queue = new PriorityQueue<>();
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if(arr[i] == brr[j]) {
                    queue.add(new Info(arr[i], i, j));
                }
            }
        }


        if(queue.isEmpty()) {
            System.out.println(0);
        } else {
            int size = 1;
            StringBuilder sb = new StringBuilder();

            Info info = queue.poll();
            int aIndex = info.aIndex, bIndex = info.bIndex;
            sb.append(info.num).append(" ");

            while (!queue.isEmpty()) {
                Info now = queue.poll();
                if(now.aIndex > aIndex && now.bIndex > bIndex) {
                    sb.append(now.num).append(" ");
                    aIndex = now.aIndex;
                    bIndex = now.bIndex;
                    size ++;
                }
            }

            System.out.println(size);
            System.out.println(sb);
        }
    }

    static class Info implements Comparable<Info> {
        int num, aIndex, bIndex;

        public Info(int num, int aIndex, int bIndex) {
            this.num = num;
            this.aIndex = aIndex;
            this.bIndex = bIndex;
        }

        @Override
        public int compareTo(Info o) {
            if(this.num == o.num) {
                if(this.aIndex == o.aIndex) {
                    return Integer.compare(this.bIndex, o.bIndex);
                }

                return Integer.compare(this.aIndex, o.aIndex);
            }

            return Integer.compare(o.num, this.num);
        }
    }
}