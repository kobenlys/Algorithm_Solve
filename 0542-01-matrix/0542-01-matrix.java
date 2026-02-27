class Solution {

    public void bfs(int N, int M, int[][] mat, Queue<int[]> qu){
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};

        while(!qu.isEmpty()) {

            int[] curr = qu.poll();

            for(int i = 0; i < 4; i++) {
                int ny = curr[0] + dy[i];
                int nx = curr[1] + dx[i];
                
                if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
                if(mat[ny][nx] > mat[curr[0]][curr[1]] + 1){
                    mat[ny][nx] = mat[curr[0]][curr[1]] + 1;
                    qu.offer(new int[]{ny,nx});
                }
            }
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        
        Queue<int[]> qu = new ArrayDeque<>();
        int N = mat.length;
        int M = mat[0].length;
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(mat[i][j] != 0) {
                    mat[i][j] = Integer.MAX_VALUE;
                } else {
                    qu.offer(new int[]{i,j});
                }
            }
        }

        bfs(N, M, mat, qu);
        return mat;
    }
}