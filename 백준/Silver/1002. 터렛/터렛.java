import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            if (x1 == x2 && y1 == y2 && r1 == r2) {
                sb.append(-1).append("\n"); // 같은 원
                continue;
            }

            int dx = x2 - x1;
            int dy = y2 - y1;
            int distSq = dx * dx + dy * dy; // 중심 거리 제곱
            int sumR = r1 + r2;
            int diffR = Math.abs(r1 - r2);

            int sumRSq = sumR * sumR;
            int diffRSq = diffR * diffR;

            if (distSq > sumRSq) { // 떨어져 있음
                sb.append(0).append("\n");
            } else if (distSq == sumRSq) { // 외접
                sb.append(1).append("\n");
            } else if (distSq < diffRSq) { // 한 원이 다른 원 안에 있고 접하지 않음
                sb.append(0).append("\n");
            } else if (distSq == diffRSq) { // 내접
                sb.append(1).append("\n");
            } else { // 두 점에서 만남
                sb.append(2).append("\n");
            }
        }

        System.out.print(sb);
    }
}
