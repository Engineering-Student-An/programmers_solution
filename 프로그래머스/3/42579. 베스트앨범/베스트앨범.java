import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int n = genres.length;
        int[] answer;
        
        Map<String, Integer> indexMap = new HashMap<>();
        Map<String, Integer> genreTotal = new HashMap<>();
        int index = 0;
        for(int i = 0; i < n; i ++) {
            if(indexMap.get(genres[i]) == null) {
                indexMap.put(genres[i], index ++);
                genreTotal.put(genres[i], plays[i]);
            } else {
                genreTotal.replace(genres[i], genreTotal.get(genres[i]) + plays[i]);
            }
        }
        
        int gSize = indexMap.size();
        PriorityQueue<Info>[] queue = new PriorityQueue[gSize];
        for(int i = 0; i < gSize; i ++) {
            queue[i] = new PriorityQueue<>();
        }
        
        PriorityQueue<GenreInfo> genreQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.total, o1.total));
        for(String g : genreTotal.keySet()) {
            genreQueue.add(new GenreInfo(indexMap.get(g), genreTotal.get(g)));
        }
        
        for(int i = 0; i < n; i ++) {
            queue[indexMap.get(genres[i])].add(new Info(i, plays[i]));
        }
        
        List<Integer> answerList = new ArrayList<>();
        while(!genreQueue.isEmpty()) {
            GenreInfo genre = genreQueue.poll();
            
            index = genre.index;
            
            int songCount = 0;
            while(!queue[index].isEmpty() && songCount < 2) {
                Info now = queue[index].poll();
                answerList.add(now.index); 
                songCount ++;
            }
        }
        
        answer = new int[answerList.size()];
        index = 0;
        for(Integer i : answerList) {
            answer[index ++] = i;
        }
        
        return answer;
    }
    
    public class GenreInfo{
        int index, total;
        
        public GenreInfo(int index, int total) {
            this.index = index;
            this.total = total;
        }
    }
    
    public class Info implements Comparable<Info> {
        int index, play;
        
        public Info (int index, int play) {
            this.index = index;
            this.play = play;
        }
        
        @Override
        public int compareTo(Info o) {
            if(this.play == o.play) return(this.index - o.index);
            return (o.play - this.play);
        }
    }
}