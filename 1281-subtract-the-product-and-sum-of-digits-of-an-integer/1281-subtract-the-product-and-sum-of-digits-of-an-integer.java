class Solution {
    public int subtractProductAndSum(int n) {
        
        int numA = 1;
        int numB = 0;

        while(n != 0){
            int c = n % 10;
            n /= 10;
            numA *= c;
            numB += c;
        }

        return numA - numB;
    }
}