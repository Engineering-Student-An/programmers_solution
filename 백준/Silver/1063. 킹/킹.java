import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String k = scanner.next();
        int[] king = new int[2];
        int[] rock = new int[2];
        king[0] = 9 - (k.charAt(1) - '0');
        king[1] = k.charAt(0) - 'A' + 1;
        String r = scanner.next();
        rock[0] = 9 - (r.charAt(1) - '0');
        rock[1] = r.charAt(0) - 'A' + 1;

        Map<String, Integer> row = new HashMap<>();
        Map<String, Integer> col = new HashMap<>();
        row.put("R", 0);        col.put("R", 1);
        row.put("L", 0);        col.put("L", -1);
        row.put("B", 1);        col.put("B", 0);
        row.put("T", -1);       col.put("T", 0);
        row.put("RT", -1);      col.put("RT", 1);
        row.put("LT", -1);      col.put("LT", -1);
        row.put("RB", 1);       col.put("RB", 1);
        row.put("LB", 1);       col.put("LB", -1);

        int n = scanner.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            String temp = scanner.next();

            int changedKingRow = king[0] + row.get(temp);
            int changedKingCol = king[1] + col.get(temp);
            Boolean change = true;
            if(changedKingRow > 0 && changedKingRow < 9 && changedKingCol > 0 && changedKingCol < 9){
                if(changedKingRow == rock[0] && changedKingCol == rock[1]){
                    int changedRockRow = rock[0] + row.get(temp);
                    int changedRockCol = rock[1] + col.get(temp);

                    if(changedRockRow > 0 && changedRockRow < 9 && changedRockCol > 0 && changedRockCol <9) {
                        rock[0] = changedRockRow;
                        rock[1] = changedRockCol;
                        king[0] = changedKingRow;
                        king[1] = changedKingCol;
                    }

                } else{
                    king[0] = changedKingRow;
                    king[1] = changedKingCol;
                }
            }
        }
        System.out.println((char)(king[1]-1 + 'A') + "" + (9-king[0]));
        System.out.println((char)(rock[1]-1 + 'A') + "" + (9-rock[0]));


    }
}