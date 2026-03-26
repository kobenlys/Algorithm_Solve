class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int left = 0, right = 0, answer = 1;
        Set<Character> set = new HashSet<>();

        if(s.length() == 0){
            return 0;
        }

        while(right != s.length()) {

            char c = s.charAt(right);

            if(set.contains(c)){
                
                answer = Math.max(answer, set.size());
                while(left < right) {
                    char d = s.charAt(left++);
                    set.remove(d);
                    if(d == c) {
                        break;
                    }
                }
            }
            
            right++;
            set.add(c);
        }
        
        answer = Math.max(answer, set.size());
        return answer;
    }
}