import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        HashMap<String, Integer> gMap = new HashMap<>();
        
        for(int i = 0 ; i < genres.length ; i++) {
            String genre = genres[i];
            int cnt = plays[i];
            gMap.put(genre, gMap.getOrDefault(genre, 0) + cnt);
        }
        
        ArrayList<Sing> list = new ArrayList<>();
        
        for(int i = 0 ; i < plays.length ; i++) {
            Sing s = new Sing(genres[i], plays[i], i);
            list.add(s);
        }
        
        Collections.sort(list, (o1, o2) -> {
            int res1 = Integer.compare(gMap.get(o2.genre()), gMap.get(o1.genre()));
            
            if (res1 == 0) {
                int res2 = Integer.compare(o2.play(), o1.play());
                
                if (res2 == 0)
                    return Integer.compare(o1.seq(), o2.seq());
                return res2;
            }
            return res1;
        });
        
        String gen = list.get(0).genre();
        int cnt = 1;
        answer.add(list.get(0).seq());
        for(int i = 1 ; i < list.size() ; i++) {
            Sing s = list.get(i);
            
            if (gen.equals(s.genre()) && cnt < 2) {
                answer.add(s.seq());
                cnt++;
            } else if (!gen.equals(s.genre())) {
                gen = s.genre();
                cnt = 1;
                answer.add(s.seq());
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}

record Sing(
    String genre,
    int play,
    int seq
){}