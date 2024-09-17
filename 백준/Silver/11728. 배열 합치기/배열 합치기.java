import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] nArr = new int[n];
        int[] mArr = new int[m];
        for (int i = 0; i < n; i++) {
            nArr[i] = scanner.nextInt();
        }

        for (int i = 0; i < m; i++) {
            mArr[i] = scanner.nextInt();
        }
        StringBuilder sb = new StringBuilder();
        int n_idx = 0;
        int m_idx = 0;
        while(n_idx < n && m_idx < m) {
            if(nArr[n_idx] < mArr[m_idx]) {
                sb.append(nArr[n_idx]).append(" ");
                n_idx ++;
            } else {
                sb.append(mArr[m_idx]).append(" ");
                m_idx ++;
            }
        }

        for (int i = n_idx; i < n; i++) {
            sb.append(nArr[i]).append(" ");
        }

        for (int i = m_idx; i < m; i++) {
            sb.append(mArr[i]).append(" ");
        }

        System.out.println(sb);
    }
}