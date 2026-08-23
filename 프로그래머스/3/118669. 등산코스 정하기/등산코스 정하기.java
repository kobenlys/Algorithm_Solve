import java.util.*;

class Solution {
    
    public int[] parents;
    public boolean[] isGate;
    public boolean[] isSummit;
    public int eNode;
    public int intensity = Integer.MAX_VALUE;
    
    public class Node implements Comparable<Node>{
        int s, e, v;
        public Node(int s, int e, int v){
            this.s = s;
            this.e = e;
            this.v = v;
        }
        
        @Override
        public int compareTo(Node o){
            if(this.v == o.v){
                return this.e - o.e;
            }
            return this.v - o.v;
        }
    }
    
    public int find(int x){
        if(parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }
    
    public boolean union(int x, int y){
        int from = find(x);
        int to = find(y);
        
        if(from != to){
            parents[to] = from;
            return true;
        }
        return false;
    }
    
    public List<List<Node>> kruskal(int n, int[][] paths){
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        List<List<Node>> edges = new ArrayList<>();
        
        for(int i = 0; i <= n; i++){
            edges.add(new ArrayList<>());
        }
        
        
        for(int[] p : paths){
            pq.offer(new Node(p[0], p[1], p[2]));
        }
        
        while(!pq.isEmpty()){
            Node nd = pq.poll();
            if(union(nd.s, nd.e)) {
                edges.get(nd.s).add(new Node(nd.s, nd.e, nd.v));
                edges.get(nd.e).add(new Node(nd.e, nd.s, nd.v));
            }
        }
        
        return edges;
    }
    
    public void dfs(int sNode, int maxVal, List<List<Node>> edges){
        
        if(isSummit[sNode]){
            
            if(intensity >= maxVal){
                if(intensity == maxVal){
                    eNode = Math.min(eNode, sNode);
                } else {
                    eNode = sNode;
                }
                intensity = maxVal;
            }
            return;
        }
        
        
        for(Node nx : edges.get(sNode)){
            
            if(isGate[nx.e] || nx.v > intensity) {
                continue;
            }
            
            int newMax = Math.max(maxVal, nx.v);
            isGate[nx.e] = true;
            dfs(nx.e, newMax, edges);
            isGate[nx.e] = false;
        }
        
    }
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = {};
        parents = new int[n+1];
        isGate = new boolean[n+1];
        isSummit = new boolean[n+1];
        
        for(int i = 0 ; i <= n; i++){
            parents[i] = i;
        }
        
        for(int g : gates) {
            isGate[g] = true;
        }
        
        for(int s : summits) {
            isSummit[s] = true;
        }
        
        List<List<Node>> edges = kruskal(n, paths);
        
        
        int temp = intensity;
        for(int sn : gates) {
            dfs(sn, -1, edges);
            if(temp != intensity){
                temp = intensity;
            }
        }
        
        
        // System.out.println(3_500_000 * 24);
        
        return new int[]{eNode, intensity};
    }
}