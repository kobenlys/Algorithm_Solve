class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        List<int[]> answerList = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e[0]));

        pq.offer(newInterval);

        for(int[] e : intervals) {
            pq.offer(e);
        }

        while(!pq.isEmpty()) {

            if(answerList.size() == 0){
                answerList.add(pq.poll());
                continue;
            }

            int[] prev = answerList.get(answerList.size()-1);
            int[] curr = pq.poll();

            if(prev[0] <= curr[0] && curr[0] <= prev[1]) {
                prev[1] = Math.max(prev[1], curr[1]);
                continue;
            }

            if(prev[1] <= curr[0]) {
                answerList.add(curr);
            }
        }

        return answerList.toArray(new int[0][]);
    }
}