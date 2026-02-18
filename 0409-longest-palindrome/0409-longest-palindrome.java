class Solution {

    public int longestPalindrome(String s) {
        
        int[] vi = new int[128];
        int answer = 0;
        boolean isOdd = false;

        for(int i = 0; i < s.length(); i++) {
            vi[s.charAt(i)]++;
        }

        for(int i = 0; i < 128; i++) {
            if(!isOdd && vi[i] % 2 != 0) {
                isOdd = true;
            }
            answer += vi[i] / 2 * 2;
        }

        if(isOdd) answer++;

        return answer;
    }
}