import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static Info[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int max = -1;
        int maxStart = 0, maxEnd = 0;
        arr = new Info[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr, new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                return o1.x - o2.x;
            }
        });

        for (int i = 0; i < n; i++) {
            if(max < arr[i].h) {
                max = arr[i].h;
                maxStart = i;
                maxEnd = i;
            } else if(max == arr[i].h) {
                maxEnd = i;
            }
        }

        // 증가하는 부분
        int result = 0;

        Stack<Info> stack = new Stack<>();
        for (int i = 0; i < maxStart; i++) {
            if(stack.isEmpty()) stack.push(arr[i]);
            else {
                if(arr[i].h > stack.peek().h) stack.push(arr[i]);
            }
        }

        int x = arr[maxStart].x;
        while(!stack.isEmpty()) {
            Info now = stack.pop();
            result += (x - now.x) * now.h;
            x = now.x;
        }

        // 중간 부분
        result += (arr[maxEnd].x - arr[maxStart].x + 1) * max;

        // 감소하는 부분
        for (int i = n - 1; i > maxEnd; i--) {
            if(stack.isEmpty()) stack.push(arr[i]);
            else {
                if(arr[i].h > stack.peek().h) stack.push(arr[i]);
            }
        }

        x = arr[maxEnd].x + 1;
        while(!stack.isEmpty()) {
            Info now = stack.pop();
            result += (now.x + 1 - x) * now.h;
            x = now.x + 1;
        }

        System.out.println(result);
    }

    static class Info {
        int x, h;

        public Info(int x, int h) {
            this.x = x;
            this.h = h;
        }
    }
}
