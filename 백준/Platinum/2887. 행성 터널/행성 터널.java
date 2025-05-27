import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static PriorityQueue<Info> queue = new PriorityQueue<>((o1, o2) -> Double.compare(o1.value, o2.value));
    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        Node[] arr = new Node[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            arr[i] = new Node(i, x, y, z);
        }

        // x 좌표 기준 오름차순
        Arrays.sort(arr, (o1, o2) -> Integer.compare(o1.x, o2.x));
        for (int i = 0; i < n - 1; i++) {
            queue.add(new Info(arr[i].num, arr[i + 1].num, Math.abs(arr[i].x - arr[i + 1].x)));
        }

        // y 좌표 기준 오름차순
        Arrays.sort(arr, (o1, o2) -> Integer.compare(o1.y, o2.y));
        for (int i = 0; i < n - 1; i++) {
            queue.add(new Info(arr[i].num, arr[i + 1].num, Math.abs(arr[i].y - arr[i + 1].y)));
        }

        // z 좌표 기준 오름차순
        Arrays.sort(arr, (o1, o2) -> Integer.compare(o1.z, o2.z));
        for (int i = 0; i < n - 1; i++) {
            queue.add(new Info(arr[i].num, arr[i + 1].num, Math.abs(arr[i].z - arr[i + 1].z)));
        }

        int count = 0;
        long sum = 0;
        while(!queue.isEmpty() && count < n-1) {
            Info info = queue.poll();
            if(find(info.s) != find(info.e)) {
                union(info.s, info.e);
                count ++;
                sum += info.value;
            }
        }

        System.out.println(sum);
    }

    static int find(int a) {
        if(a == parent[a]) return a;

        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b) {
            parent[Math.max(a, b)] = Math.min(a, b);
        }
    }

    static class Info {
        int s;
        int e;
        long value;

        public Info(int s, int e, long value) {
            this.s = s;
            this.e = e;
            this.value = value;
        }
    }

    static class Node {
        int num;
        int x, y, z;

        public Node(int num, int x, int y, int z) {
            this.num = num;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}