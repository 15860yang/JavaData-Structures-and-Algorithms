package leetcode.q51_100;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *  
 * <p>
 * 提示：
 * <p>
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 */
public class Q79 {
    public boolean exist(char[][] board, String word) {
        boolean res = false;
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean r = exist(board, i, j, word, 0);
                if (r) {
                    return true;
                }
            }
        }
        return res;
    }

    private boolean exist(char[][] board, int i, int j, String word, int start) {
        if (start >= word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j > board[0].length) {
            return false;
        }
        if (board[i][j] == word.charAt(start)) {
            char c = board[i][j];
            board[i][j] = '#';
            boolean res = exist(board, i + 1, j, word, start + 1)
                    || exist(board, i - 1, j, word, start + 1)
                    || exist(board, i, j + 1, word, start + 1)
                    || exist(board, i, j - 1, word, start + 1);
            board[i][j] = c;
            return res;
        }
        return false;
    }
}
