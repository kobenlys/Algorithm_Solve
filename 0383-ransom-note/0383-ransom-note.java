class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        int[] vi = new int[27];

        for(char e : magazine.toCharArray()) {
            vi[e - 'a']++;
        }

        for(char e : ransomNote.toCharArray()) {
            if(vi[e-'a'] > 0) {
                vi[e-'a']--;
            } else {
                return false;
            }
        }
        

        return true;
    }
}