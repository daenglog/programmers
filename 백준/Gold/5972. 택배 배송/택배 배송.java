import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        Solution sol = new Solution();
        sol.solution();
    }
}
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]); int M = Integer.parseInt(str[1]);

        HashMap<Integer, ArrayList<int[]>> map = new HashMap<>();

        for(int i = 0 ; i < N ; i++) {
            map.put(i+1, new ArrayList<>());
        }

        for(int i = 0 ; i < M ; i++) {
            String[] tmp = br.readLine().split(" ");
            int[] itmp = new int[3];

            for(int j = 0 ; j < 3 ; j++) {
                itmp[j] = Integer.parseInt(tmp[j]);
            }

            ArrayList<int[]> list0 = map.get(itmp[0]);
            ArrayList<int[]> list1 = map.get(itmp[1]);

            list0.add(new int[]{itmp[1], itmp[2]});
            list1.add(new int[]{itmp[0], itmp[2]});

            map.put(itmp[0], list0);
            map.put(itmp[1], list1);
        }

        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{1, 0});

        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        while(!queue.isEmpty()) {
            int[] now = queue.pollFirst();
            
            if(now[1] > dist[now[0]]) continue;

            for(int[] m : map.get(now[0])) {
                if(dist[m[0]] > now[1] + m[1]) {
                    dist[m[0]] = now[1] + m[1];
                    queue.offer(new int[] {m[0], dist[m[0]]});
                }
            }
        }

        System.out.println(dist[N]);
    }
}