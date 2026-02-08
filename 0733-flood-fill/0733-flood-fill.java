class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        Queue<int[]> qu = new ArrayDeque<>();
        int[] dx = { 0, 0, -1, 1 };
        int[] dy = { -1, 1, 0, 0 };
        int N = image.length;
        int M = image[0].length;
        qu.offer(new int[] { sc, sr });
        boolean[][] vi = new boolean[N][M];
        int baseColor = image[sr][sc];
        image[sr][sc] = color;

        while (!qu.isEmpty()) {
            int[] nd = qu.poll();

            for (int i = 0; i < 4; i++) {
                int nx = nd[0] + dx[i];
                int ny = nd[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= M || ny >= N) {
                    continue;
                }

                if (image[ny][nx] == baseColor && !vi[ny][nx]) {
                    vi[ny][nx] = true;
                    image[ny][nx] = color;
                    qu.offer(new int[] { nx, ny });
                }
            }
        }

        return image;
    }
}