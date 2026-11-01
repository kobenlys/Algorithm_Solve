class Solution {

    public boolean isPossible(int[] piles, int eatNum, int limitHour) {
        for(int e : piles) {
            int minus = e % eatNum == 0 ? e / eatNum : e / eatNum + 1;
            limitHour -= minus;
            if(limitHour < 0) {
                return false;
            }
        }
        return true;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int answer = 1;
        Arrays.sort(piles);
        
        int left = 1;
        int right = 1_000_000_001;

        while(left <= right) {

            int mid = (left + right) / 2;

            if(isPossible(piles, mid, h)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
}