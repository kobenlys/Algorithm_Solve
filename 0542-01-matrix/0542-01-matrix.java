class Solution {

    public void bfs(int N, int M, int[][] mat, int[][] vi, Queue<int[]> qu){
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};

        while(!qu.isEmpty()) {

            int[] curr = qu.poll();

            for(int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];
                int newDist = vi[curr[1]][curr[0]] + 1;
                if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;

                if(mat[ny][nx] == 1 && (vi[ny][nx] > newDist || vi[ny][nx] == 0)){
                    vi[ny][nx] = newDist;
                    qu.offer(new int[]{nx,ny});
                }
            }
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        
        Queue<int[]> qu = new ArrayDeque<>();
        int N = mat.length;
        int M = mat[0].length;
        int[][] answer = new int[N][M];
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(mat[i][j] != 0) continue;
                qu.offer(new int[]{j,i});
            }
        }

        bfs(N, M, mat, answer, qu);

        return answer;
    }
}