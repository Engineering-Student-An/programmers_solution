import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<>();

        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String name = scanner.next();
            if(map.containsKey(name)){
                int value = map.get(name);
                map.remove(name);
                map.put(name, value+1);
            } else {
                map.put(name, 1);
            }
        }

        int max = 0;
        String name = "";
        for (String string : map.keySet()) {
            if(max<map.get(string)){
                max = map.get(string);
                name = string;
            } else if((max == map.get(string))){
                String[] temp = {name, string};
                Arrays.sort(temp);
                name = temp[0];
            }
        }

        System.out.println(name);
    }
}