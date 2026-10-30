import java.util.*;

class Solution {

    public void divide(Queue<Character> qu, String num){
        
        for(int i = 0; i < num.length(); i++) {
            qu.offer(num.charAt(i));
        }
    }

    public String digitSum(String s, int k) {
        
        Queue<Character> qu = new ArrayDeque<>();
        String answer = "";

        divide(qu, s);

        while(qu.size() > k){
            
            int len = qu.size();
            int tmp = 0;
            for(int i = 1; i <= len; i++) {

                tmp += qu.poll() - '0';
                if(i == len || i % k == 0) {
                    divide(qu, String.valueOf(tmp));
                    tmp = 0;
                }
            }
        }

        while(!qu.isEmpty()){
            answer += qu.poll();
        }
        
        return answer;
    }
}