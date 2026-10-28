import java.util.*;

class Solution {
    public int countHillValley(int[] nums) {

        Deque<Integer> qu = new ArrayDeque<>();

        for (int e : nums) {
            if (!qu.isEmpty() && qu.peekLast() == e) {
                continue;
            }
            qu.offer(e);
        }

        int left = qu.poll();
        int answer = 0;
        while (!qu.isEmpty()) {

            int now = qu.poll();
            if (qu.isEmpty())
                break;
            if (left < now && qu.peek() < now)
                answer++;
            if (left > now && qu.peek() > now)
                answer++;
            left = now;
        }

        return answer;
    }
}