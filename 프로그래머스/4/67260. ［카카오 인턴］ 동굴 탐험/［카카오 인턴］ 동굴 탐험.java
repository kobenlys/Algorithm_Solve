import java.util.*;

class Solution {
    
    public static boolean[] blocked;
    public static Map<Integer, List<Integer>> edges = new HashMap<>();
    public static Map<Integer, Integer> orderMap = new HashMap<>();
    public static Set<Integer> checkSet = new HashSet<>();
    
    public boolean bfs(int node, int n){
        
        if( blocked[0] ){
            return false;
        }
        if(orderMap.containsKey(0)) {
            blocked[orderMap.get(0)] = false;
        }
        
        Queue<Integer> qu = new ArrayDeque<>();
        int changeCnt = 1;
        blocked[0] = true;
        qu.offer(node);
        
        while(!qu.isEmpty()){
            
            int curr = qu.poll();

            for(int e : edges.get(curr)){

                if(!blocked[e]){

                    blocked[e] = true;
                    qu.offer(e);
                    changeCnt++;

                    if(orderMap.containsKey(e)){
                        
                        if(checkSet.contains(orderMap.get(e))) {
                            qu.offer(orderMap.get(e));
                            changeCnt++;
                        } else {
                             blocked[orderMap.get(e)] = false;
                        }
                        
                    }
                } else {
                    checkSet.add(e);
                }
            }   
        }
        return changeCnt == n;
    }
    
    public boolean solution(int n, int[][] path, int[][] order) {
        
        blocked = new boolean[n];
        
        for(int i = 0; i < path.length; i++) {
            
            
            if( !edges.containsKey(path[i][0]) ){
                edges.put(path[i][0], new ArrayList<>());
            }
            if( !edges.containsKey(path[i][1]) ){
                edges.put(path[i][1], new ArrayList<>());
            }
            edges.get(path[i][0]).add(path[i][1]);
            edges.get(path[i][1]).add(path[i][0]);
        }
        
        for(int[] e : order){
            orderMap.put(e[0], e[1]);
            blocked[e[1]] = true;
        }
        
        return bfs(0, n);
    }
}