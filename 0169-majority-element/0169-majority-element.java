class Solution {
    public int majorityElement(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int answer = 0;
        for(int e : nums) {
            map.put(e, map.getOrDefault(e, 0) + 1);
        }
        
        for(Map.Entry<Integer, Integer> et : map.entrySet()) {
            if(et.getValue() > nums.length / 2) {
                return et.getKey();
            }
        }
        
        return answer;
    }
}