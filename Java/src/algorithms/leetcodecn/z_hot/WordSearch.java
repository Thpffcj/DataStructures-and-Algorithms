package algorithms.leetcodecn.z_hot;

/**
 * Created by thpffcj on 2020/2/24.
 *
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复
 * 使用。
 *
 * 示例:
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 */
public class WordSearch {

    private int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0 ; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exist(board, visited, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean exist(char[][] board, boolean[][] visited, int x, int y, int position, String word) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || position >= word.length()) {
            return false;
        }

        if (!visited[x][y]) {
            if (board[x][y] == word.charAt(position)) {
                visited[x][y] = true;
                if (position == word.length() - 1) {
                    return true;
                }
                for (int k = 0; k < 4; k++) {
                    int newX = x + direction[k][0];
                    int newY = y + direction[k][1];
                    if (exist(board, visited, newX, newY, position + 1, word)) {
                        return true;
                    }
                }
                visited[x][y] = false;
            }
        }
        return false;
    }

    private boolean[][] marked;
    private int m;
    private int n;
    private String word;
    private char[][] board;

    public boolean exist2(char[][] board, String word) {
        m = board.length;
        if (m == 0) {
            return false;
        }
        n = board[0].length;
        marked = new boolean[m][n];
        this.word = word;
        this.board = board;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int start) {
        if (start == word.length() - 1) {
            return board[i][j] == word.charAt(start);
        }
        if (board[i][j] == word.charAt(start)) {
            marked[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int newX = i + direction[k][0];
                int newY = j + direction[k][1];
                if (inArea(newX, newY) && !marked[newX][newY]) {
                    if (dfs(newX, newY, start + 1)) {
                        return true;
                    }
                }
            }
            marked[i][j] = false;
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
