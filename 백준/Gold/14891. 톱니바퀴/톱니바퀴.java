import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] arr, rotate;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new boolean[5][8];

        for (int i = 1; i <= 4; i++) {
            String line = br.readLine();
            for (int j = 0; j < 8; j++) {
                arr[i][j] = line.charAt(j) - '0' != 0;
            }
        }

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int rot = Integer.parseInt(st.nextToken());

            rotate = new boolean[5][8];
            boolean[] isRotated = new boolean[5];

            // 해당 톱니
            rotate(num, rot);
            isRotated[num] = true;

            // 뒤
            int tempRot = rot;
            for (int j = num + 1; j <= 4; j++) {
                if(arr[j][6] == arr[j-1][2]) break;

                tempRot *= -1;
                rotate(j, tempRot);
                isRotated[j] = true;
            }

            // 앞
            tempRot = rot;
            for (int j = num - 1; j >= 0; j--) {
                if(arr[j][2] == arr[j+1][6]) break;

                tempRot *= -1;
                rotate(j, tempRot);
                isRotated[j] = true;
            }

            // 옮기기
            for (int j = 1; j <= 4; j++) {
                if(isRotated[j]) {
                    for (int l = 0; l < 8; l++) {
                        arr[j][l] = rotate[j][l];
                    }
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= 4; i++) {
            if(arr[i][0]) {
                result += (int) Math.pow(2, i - 1);
            }
        }

        System.out.println(result);
    }

    static void rotate(int num, int rot) {
        boolean[] result = new boolean[8];

        if(rot == -1) {
            for (int i = 1; i < 8; i++) {
                result[i-1] = arr[num][i];
            }
            result[7] = arr[num][0];
        } else {
            result[0] = arr[num][7];
            for (int i = 0; i < 7; i++) {
                result[i + 1] = arr[num][i];
            }
        }

        for (int j = 0; j < 8; j++) {
            rotate[num][j] = result[j];
        }
    }
}