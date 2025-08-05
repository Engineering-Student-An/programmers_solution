import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, result = 0;
    static Info[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new Info[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        step(0, 0);

        System.out.println(result);
    }

    static void step(int grab, int broken) {

//        System.out.println("grab = " + grab);

        if(grab == n) {
            result = Math.max(result, broken);
//            System.out.println("result = " + result);
            return;
        }

        if(arr[grab].hp <= 0 || (arr[grab].hp > 0 && broken >= n - 1)) {
            step(grab + 1, broken);
        } else {
            for (int i = 0; i < n; i++) {
                if(grab == i) continue;
                if(arr[i].hp <= 0) continue;

                arr[grab].hp -= arr[i].w;
                arr[i].hp -= arr[grab].w;

                int br = 0;
                for (int j = 0; j < n; j++) {
                    if(arr[j].hp <= 0) br ++;
                }

//                System.out.println("i = " + i);
                step(grab + 1, br);

                arr[grab].hp += arr[i].w;
                arr[i].hp += arr[grab].w;
            }
        }
    }

    static class Info {
        int hp, w;

        public Info(int hp, int w) {
            this.hp = hp;
            this.w = w;
        }
    }
}