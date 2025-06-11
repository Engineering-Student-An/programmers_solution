import java.util.*;
import java.io.*;

public class Main{
    
    static int[] arr;
    static boolean[] visit, done;
    static int count;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int p = 0; p < T; p++){
            int n = Integer.parseInt(br.readLine());
            arr = new int[n+1];
            visit = new boolean[n+1];
            done = new boolean[n+1];
            count = 0;

            st = new StringTokenizer(br.readLine());

            for(int i=1; i<= n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=1; i<= n; i++){
                if(!done[i]){
                    dfs(i);
                }
            }
            sb.append(n - count).append("\n");
        }
        System.out.print(sb);
    }

    public static void dfs(int n){
        // 이미 방문 했을 때!
        if(visit[n]){
            done[n] = true;    // 팀 편성 완료했다고 처리
            count++;    // 팀 편성 완료 인원 증가
        }else{
            // 방문하지 않았을 때 -> 방문 처리!
            visit[n] = true;
        }

        // 다음 학생이 팀 결성을 아직 못했을 경우
        if(!done[arr[n]]){
            dfs(arr[n]);
        }

        visit[n] = false;
        done[n] = true;
    }
}