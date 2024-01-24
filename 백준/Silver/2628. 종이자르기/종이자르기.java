import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        int c = scanner.nextInt();
        int r = scanner.nextInt();
        int n = scanner.nextInt();

        PriorityQueue<Integer> row = new PriorityQueue<>();
        PriorityQueue<Integer> col = new PriorityQueue<>();
        row.add(0);
        row.add(r);
        col.add(0);
        col.add(c);
        for (int i = 0; i < n; i++) {
            int temp = scanner.nextInt();
            if (temp == 0) {
                row.add(scanner.nextInt());
            } else{
                col.add(scanner.nextInt());
            }
        }

        int[] row_cut = new int[row.size()-1];
        int[] col_cut = new int[col.size()-1];
        int max = 0;

        int rs = row.size();
        for (int i = 0; i < rs-1; i++) {
            int small = row.poll();
            int big = row.poll();
            row_cut[i] = big - small;
            row.add(big);
        }
        int cs = col.size();
        for (int i = 0; i < cs-1; i++) {
            int small = col.poll();
            int big = col.poll();
            col_cut[i] = big - small;
            col.add(big);
        }

        for (int i = 0; i < row_cut.length; i++) {
            for (int j = 0; j < col_cut.length; j++) {
                if(col_cut[j] * row_cut[i] > max){
                    max = col_cut[j] * row_cut[i];
                }
            }
        }

        System.out.println(max);
    }
}
