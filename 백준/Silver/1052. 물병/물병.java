import java.lang.reflect.Array;
import java.util.*;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();

        int q, r = 2;
        while(r>1){
            q = nearest(n);
            r = n % nearest(n);
            arr.add(q);
            if(r==1) arr.add(1);
            n = r;
        }


        int ans = 0;
        int count = 0;
        while (true) {
            if(arr.size()<=k) break;
            Collections.sort(arr);
            if(arr.get(1) % arr.get(0) != 0){
                ans = -1;
                break;
            }
            ans += ((arr.get(1) / arr.get(0)) - 1) * arr.get(0);
            arr.add(arr.get(1) * 2);

            arr.remove(0);
            arr.remove(0);
        }
        System.out.println(ans);
    }

    public static int nearest(int n){
        int ans = 1;
        for(int i=1;i<=23;i++){
            if((int)pow(2,i) > n) break;
            ans = (int)pow(2,i);
        }
        return ans;
    }
}