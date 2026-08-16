import java.util.*;

class Solution {
    public int solution(int[][] signals) {
        int answer = -1;
        int size = calcArraySize(signals);
        int[] arr1 = new int[size+1];
        
        for(int i = 0; i < signals.length; i++){
            
            int totalSum = signals[i][0] + signals[i][1] + signals[i][2]; 
            int curr = 1;
            
            while(curr <= size) {
                for(int j = 0; j < signals[i].length; j++){
                    
                    if( j == 1 && curr + signals[i][j] <= size) {
                        for(int k = 0; k < signals[i][j]; k++){
                            arr1[curr]++;
                            if(arr1[curr] == signals.length){
                                return curr;
                            }
                            curr++;
                        }
                    } else {
                        curr+= signals[i][j];
                    }
                    //System.out.println(curr);
                }
            }
            //System.out.println(curr);
            //System.out.println(Arrays.toString(arr1));
        }
        return answer;
    }
    
    public int calcArraySize(int[][] arr1){
        
        int res = 1;
        
        for(int i = 0; i < arr1.length; i++){
            int tempRes = 0;
            for(int e : arr1[i]){
                tempRes += e;
            }
            res *= tempRes;
        }
        
        return res;
    }
}