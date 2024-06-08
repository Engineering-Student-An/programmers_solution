class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int now = health;
        int count = 0;
        int index = 0;
        for (int i=1; i<=attacks[attacks.length-1][0]; i++) {
            
            if(attacks[index][0] == i) {
                now -= attacks[index][1];
                index ++;
                count = 0;
                if(now <= 0) return -1;
            } else {
                if(now < health && count < bandage[0]) {
                    now += bandage[1];
                    count ++;

                }
                if(now < health && count == bandage[0]) {
                    now += bandage[2];
                    count = 0;
                }
            }
            if(now > health) now = health;
            
            
        }
        return now;
    }
}