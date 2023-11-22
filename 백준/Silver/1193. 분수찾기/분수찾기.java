import java.util.Scanner;

public class Main {
    public static class Dir{
        int[] x = {1, -1, 0, 1};
        int[] y = {0, 1, 1, -1};
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();

        int ind_x=1, ind_y=1, ind=0;
        Dir dir = new Dir();

        for (int i = 1; i < x; i++) {
            if (ind_x + dir.x[ind] < 1 || ind_y + dir.y[ind] < 1) {
                ind=(ind+1)%4;
            }
            ind_x += dir.x[ind];
            ind_y += dir.y[ind];
            if(ind%2==0) ind=(ind+1)%4;
        }

        System.out.println(ind_y + "/" + ind_x);


    }
}
