import java.util.*;

class Solution {

    public class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean isEqual(Node o) {
            return this.x == o.x && this.y == o.y;
        }
    }

    public boolean is3x3Valid(int x, int y, char[][] board) {
        Set<Character> set = new HashSet<>();
        for(int i = y; i < y+3; i++) {
            for(int j = x; j < x+3; j++) {
                if(set.contains(board[i][j]) && board[i][j] != '.'){
                    return false;
                }
                set.add(board[i][j]);
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        
        Map<Character, List<Node>> map = new HashMap<>();

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){

                if(i % 3 == 0 && j % 3 == 0){
                    if(!is3x3Valid(j, i, board)){
                        return false;
                    }
                }

                char key = board[i][j];
                if(key != '.'){
                    if(!map.containsKey(key)){
                        map.put(key, new ArrayList<Node>());
                    }

                    for(Node nd : map.get(key)){
                        if(nd.x == j || nd.y == i) {
                            return false;
                        }
                    }
                    map.get(key).add(new Node(j, i));
                }
            }
        }
        return true;
    }
}