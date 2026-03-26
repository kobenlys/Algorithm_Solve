class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int left = 0, right = 0, answer = 1;
        boolean[] vi = new boolean[128];

        if(s.length() == 0){
            return 0;
        }

        while(right != s.length()) {

            char c = s.charAt(right);

            if(vi[c]){
                answer = Math.max(answer, right - left);
                while(left < right) {
                    char d = s.charAt(left++);
                    vi[d] = false;
                    if(d == c) {
                        break;
                    }
                }
            }
            
            right++;
            vi[c] = true;
        }

        answer = Math.max(answer, right - left);
        return answer;
    }
}