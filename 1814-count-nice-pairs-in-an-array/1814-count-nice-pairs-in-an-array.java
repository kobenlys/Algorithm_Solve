import java.util.*;

class Solution {

    public int rev(int num) {
        int res = 0;

        while(num != 0) {
            res *= 10;
            res += num % 10;
            num /= 10;
        }

        return res;
    }

    public int countNicePairs(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        long answer = 0;
        long mod = 1_000_000_007L;

        for(int e : nums){
            
            int key = e - rev(e);
            if(!map.containsKey(key)){
                map.put(key, 1);
            } else {
                map.put(key, map.get(key) + 1);
            }
        }

        for(int v : map.values()) {
            if(v <= 1) continue;
            answer = (answer + (long) v * (v-1) / 2) % mod;
        }

        return (int) answer;
    }
}