import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Integer[] crane = new Integer[n];
        for(int i=0;i<n;i++){
            crane[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        ArrayList<Integer> box = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            box.add(scanner.nextInt());
        }

        Arrays.sort(crane, Collections.reverseOrder());
        box.sort(Collections.reverseOrder());
        if(box.get(0) > crane[0]){
            System.out.println(-1);
        } else{
            int count = 0;
            int index = 0;
            while(!box.isEmpty()){
//                System.out.println(box);
                index = 0;
                for(int i=0;i<n;){
                    if(index == box.size()) break;
                    if(box.get(index) <= crane[i]){
                        box.remove(index);
                        i++;
                    }
                    else{
                        index++;
                    }
                }

                count++;
            }
            System.out.println(count);
        }
    }
}
