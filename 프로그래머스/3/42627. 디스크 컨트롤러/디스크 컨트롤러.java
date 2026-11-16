import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        PriorityQueue<Disk> pq = new PriorityQueue<>((o1, o2) -> {
            int res1 = Integer.compare(o1.jobTm(), o2.jobTm());
            
            if (res1 == 0) {
                int res2 = Integer.compare(o1.start(), o2.start());
                
                if (res2 == 0) {
                    return Integer.compare(o1.jobNo(), o2.jobNo());
                }
                
                return res2;
            }
            return res1;
        });
        
        ArrayList<Disk> list = new ArrayList<>();
        
        for(int i = 0 ; i < jobs.length ; i++) {
            list.add(new Disk(i, jobs[i][0], jobs[i][1]));
        }
        
        Collections.sort(list, (a,b) -> {
           return Integer.compare(a.start(), b.start()); 
        });
        
        int t = 0; int idx = 0;
        while (idx < jobs.length || !pq.isEmpty()) {
            
            while (idx < jobs.length && list.get(idx).start() <= t) {
                pq.offer(list.get(idx));
                idx++;
            }
            
            if (pq.isEmpty()) {
                t = list.get(idx).start();
                continue;
            }
            
            Disk now = pq.poll();
            t += now.jobTm();
            
            answer += t - now.start();
        }
        
        return answer/jobs.length;
    }
}

record Disk(
    int jobNo,
    int start,
    int jobTm
){}