import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] arr, goal, shuffle, temp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        goal = new int[n];
        shuffle = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            goal[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            shuffle[i] = Integer.parseInt(st.nextToken());
        }

        temp = new int[n];

        int count = 0;
        boolean find = false;
        while(true) {
            if(check()) {
                find = true;
                break;
            }

            shuffle();
            if(checkOriginal()) break;
            count ++;
        }

        System.out.println((find) ? count : -1);
    }

    static boolean checkOriginal() {
        for (int i = 0; i < n; i++) {
            if(arr[i] != i) return false;
        }

        return true;
    }

    static void shuffle() {
        for (int i = 0; i < n; i++) {
            temp[shuffle[i]] = arr[i];
        }

        for (int i = 0; i < n; i++) {
            arr[i] = temp[i];
        }
    }

    static boolean check() {
        for (int i = 0; i < n; i++) {
            if(i % 3 != goal[arr[i]]) return false;
        }

        return true;
    }
}