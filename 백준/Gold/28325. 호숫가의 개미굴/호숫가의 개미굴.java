import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long[] infos = new long[N];
        int zeroCnt = 0;
        int idx = -1;
        long answer =0;
        int roomCnt = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            infos[i] = Long.parseLong(st.nextToken());

            if (infos[i] > 0) {
                if (idx == -1) {
                    idx = i;
                }
                roomCnt++;
                answer += infos[i];
            }
        }

        if (roomCnt == 0) {
            answer += N / 2;

        } else {
            idx++;
            while (roomCnt > 0) {
                idx %= N;
                if (infos[idx] > 0) {
                    answer += (zeroCnt + 1) / 2;
                    zeroCnt = 0;
                    roomCnt--;
                } else {
                    zeroCnt++;
                }
                idx++;
            }
        }
        // 0 0 1 0 1 0
        System.out.println(answer);
    }
}