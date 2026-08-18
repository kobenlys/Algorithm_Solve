import java.util.*;

class Solution {
    
    public static boolean[] blocked; // 0 : 통과, 1 : 방문, 2 : Locked 상태
    public static Map<Integer, List<Integer>> edges = new HashMap<>();
    public static Map<Integer, Integer> orderMap = new HashMap<>();
    public static Set<Integer> checkSet = new HashSet<>();
    
    public boolean bfs(int node, int n){
        
        Queue<Integer> qu = new ArrayDeque<>();
        
        if( blocked[0] ){
            return false;
        }
        
        int changeCnt = 1;
        blocked[0] = true;
        qu.offer(node);
        
        if(orderMap.containsKey(0)) {
            blocked[orderMap.get(0)] = false;
        }
        
        //System.out.println(orderMap.size());
        
        while(!qu.isEmpty()){
            
            int curr = qu.poll();

            for(int e : edges.get(curr)){

                if(!blocked[e]){

                    // 통과 하거나 동시에 order에 조건이라면 cache에 값넣기
                    blocked[e] = true;
                    qu.offer(e);
                    changeCnt++;

                    if(orderMap.containsKey(e)){
                        
                        if(checkSet.contains(orderMap.get(e))) {
                            qu.offer(orderMap.get(e));
                            //checkSet.add(e);
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
            
            //System.out.println(path[i][0] + " w " + path[i][1]);
            
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
        
        //System.out.println(Arrays.toString(blocked));
        
        //return true;
        return bfs(0, n);
    }
}