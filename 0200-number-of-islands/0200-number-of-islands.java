class Solution {

    public static int N, M;

    public void remove(char[][] grid, int y, int x) {
        Queue<int[]> qu = new ArrayDeque<>();
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        qu.offer(new int[]{y,x});
        grid[y][x] = '0';

        while(!qu.isEmpty()){
            int[] now = qu.poll();
            for(int i = 0; i < 4; i++){
                
                int nx = now[1] + dx[i];
                int ny = now[0] + dy[i];
                if(nx < 0 || ny < 0 || nx >= M || ny >= N){
                    continue;
                }
                if(grid[ny][nx] == '1'){
                    grid[ny][nx] = '0';
                    qu.offer(new int[]{ny, nx});
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int answer = 0;
        N = grid.length;
        M = grid[0].length;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++){
                if(grid[i][j] == '1'){
                    remove(grid, i, j);
                    answer++;
                }
            }
        }

        return answer;
    }
}