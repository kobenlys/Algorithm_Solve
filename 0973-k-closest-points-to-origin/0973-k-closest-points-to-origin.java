class Solution {

    public class Node {
        int[] point;
        double val;
        public Node (int[] point, double val) {
            this.point = point;
            this.val = val;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        int[][] answer = new int[k][2];
        List<Node> list = new ArrayList<>();

        for(int[] e : points) {
            double ud = Math.sqrt(Math.pow(e[0], 2) + Math.pow(e[1], 2));
            list.add(new Node(e, ud));
        }
        
        Collections.sort(list, Comparator.comparingDouble(e -> e.val));

        for(int i = 0; i < k; i++) {
            int[] p = list.get(i).point;
            answer[i][0] = p[0];
            answer[i][1] = p[1];
        }

        return answer;
    }
}