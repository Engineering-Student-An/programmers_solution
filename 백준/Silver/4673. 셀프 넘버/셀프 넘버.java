public class Main {
    public static int sum(int n){
        int sum=0;
        while(n!=0){
            sum+=n%10;
            n/=10;
        }
        return sum;
    }

    public static void main(String[] args) {

        Boolean[] self = new Boolean[10001];
        for(int i=1;i<=10000;i++){
            self[i]=true;
        }
        for(int i=1;i<=10000;i++){
            if(sum(i)+i <=10000) self[sum(i)+i] = false;
        }
        for(int i=1;i<=10000;i++){
            if (self[i]) {
                System.out.println(i);
            }
        }
    }
}
