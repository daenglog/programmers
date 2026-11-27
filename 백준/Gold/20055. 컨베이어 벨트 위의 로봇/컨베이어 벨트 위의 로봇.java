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
    void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NK = br.readLine().split(" ");
        int N = Integer.parseInt(NK[0]); int K = Integer.parseInt(NK[1]);

        String[] A = br.readLine().split(" ");
        int[] an = new int[2*N];
        for(int i = 0 ; i < 2*N ; i++) {
            an[i] = Integer.parseInt(A[i]);
        }

        int[] robot = new int[N];
        int i = 0;
        while (true) {
            i++;
            first(an, robot, N);
            second(an, robot, N);

            if (an[0] != 0) {
                robot[0] = 1;
                an[0]--;
            }

            int cnt = 0;
            for(int j = 0 ; j < 2 * N ; j++) {
                if (an[j] == 0)
                    cnt++;
            }

            if(cnt >= K) {
                break;
            }
        }

        
        System.out.println(i);
    }

    void second(int[] an, int[] robot, int N) {
        robot[N-1] = 0;
        
        for (int i = N-2 ; i >= 0 ; i--) {
            if(robot[i] == 0) continue;
            
            int nextI = i+1;

            if (robot[nextI] == 0 && an[nextI] > 0) {
                robot[nextI] = 1;
                robot[i] = 0;
                an[nextI]--;
            }
        }
    }
    
    void first(int[] an, int[] robot, int N) {
        int tmp = an[2*N-1];

        for(int i = 2*N-1 ; i > 0 ; i--) {
            an[i] = an[i-1];
        }

        an[0] = tmp;

        for(int i = N - 1; i > 0 ; i--) {
            robot[i] = robot[i-1];
        }
        robot[0] = 0;
    }
}