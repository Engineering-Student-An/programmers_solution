import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    
    static int n;
    static int h;
    static int[] first;
    static int[] second;
        
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        first = new int[n/2];
        second = new int[n/2];
        int index = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            if (i % 2 == 0) {
                first[index] = Integer.parseInt(st.nextToken());
            } else {
                second[index++] = h - Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(first);
        Arrays.sort(second);

        int[] count = new int[n+1];
        for (int i = 1; i <= h; i++) {

            int firstIndex = 0;
            if(first[n/2 - 1] < i) {
                firstIndex = n/2;
            } else {
                firstIndex = search(first, i);
                int temp = first[firstIndex];
                while (firstIndex > 0 && first[firstIndex -1] == temp) {
                    firstIndex--;
                }
            }
            firstIndex = n/2 - firstIndex;

            int secondIndex = 0;
            if(second[n/2 - 1] < i) {
                secondIndex = n/2;
            } else {
                secondIndex = search(second, i);
                int temp = second[secondIndex];
                while(secondIndex > 0 && second[secondIndex -1] == temp) {
                    secondIndex --;
                }
            }
            index = firstIndex + secondIndex;

            count[index] ++;
        }


        for (int i = 0; i < n + 1; i++) {
            if(count[i] > 0) {
                System.out.print(i + " " + count[i]);
                break;
            }
        }
    }
    
    static int search(int[] arr, int i) {
        
        int left = 0;
        int right = n/2 - 1;
        int middle = 0;

        while(left <= right) {
            middle = (left + right) / 2;
            if(arr[middle] == i || left == right) {
                break;
            }
            
            if(arr[middle] > i) {
               right = middle - 1; 
            } else if(arr[middle] < i) {
                left = middle + 1;
            }
        }
        if(arr[middle] < i && middle < n/2 - 1) return middle + 1;
        return middle;
    }
}