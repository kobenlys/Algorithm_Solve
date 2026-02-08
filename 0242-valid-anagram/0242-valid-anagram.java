class Solution {
    public boolean isAnagram(String s, String t) {
        
        int[] arr1 = new int[26];

        if(s.length() != t.length()) {
            return false;
        }

        for(int i = 0; i < s.length(); i++) {
            arr1[s.charAt(i) - 'a']++;
            arr1[t.charAt(i) - 'a']--;
        }


        for(int e : arr1) {
            if(e != 0) {
                return false;
            }
        }
        return true;
    }
}