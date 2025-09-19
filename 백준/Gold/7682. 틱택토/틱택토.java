import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static char[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        arr = new char[3][3];
        while(true) {
            String line = br.readLine();
            if(line.equals("end")) break;

            int xCount = 0, oCount = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = line.charAt(i * 3 + j);
                    if(arr[i][j] == 'X') xCount ++;
                    else if(arr[i][j] == 'O') oCount ++;
                }
            }

            int xBingo = bingoCount('X');
            int oBingo = bingoCount('O');

            // 서로 빙고가 존재하면 x
            if(xBingo > 0 && oBingo > 0) sb.append("invalid").append("\n");
            else {
                // 둘 다 빙고 없는 경우
                if(xBingo == 0 && oBingo == 0) {
                    if(xCount == 5 && oCount == 4) sb.append("valid").append("\n"); // 판이 다 찼다면 o
                    else sb.append("invalid").append("\n");                         // 판이 다 안찼다면 x
                } else {    // 둘 중 하나는 빙고 있는 경우
                    if(xCount < oCount) sb.append("invalid").append("\n");          // o의 개수가 더 많다면 x
                    else {
                        if(xBingo > 0) sb.append(validate('X') && xCount == oCount + 1 ? "valid\n" : "invalid\n");
                        else sb.append(validate('O') && xCount == oCount ? "valid\n" : "invalid\n");
                    }
                }
            }
        }

        System.out.println(sb);
    }

    static boolean validate(char c) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(arr[i][j] == c) {
                    arr[i][j] = '.';
                    if(bingoCount(c) == 0) return true;
                    arr[i][j] = c;
                }
            }
        }

        return false;
    }

    static int bingoCount(char c) {
        int bingo = 0;

        for (int i = 0; i < 3; i++) {
            // 행 검사
            if(arr[i][0] == c && arr[i][1] == c && arr[i][2] == c) bingo ++;

            // 열 검사
            if(arr[0][i] == c && arr[1][i] == c && arr[2][i] == c) bingo ++;
        }

        // 대각선 검사
        if(arr[0][0] == c && arr[1][1] == c && arr[2][2] == c) bingo ++;
        if(arr[0][2] == c && arr[1][1] == c && arr[2][0] == c) bingo ++;

        return bingo;
    }
}

/*
,xx
x.x
ooo
 */