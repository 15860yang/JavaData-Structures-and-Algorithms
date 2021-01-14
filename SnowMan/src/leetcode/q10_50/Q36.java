package leetcode.q10_50;

import java.util.HashSet;

/**
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 */

public class Q36 {

    /**
     * char[][] input = {
     *                 {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
     *                 {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
     *                 {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
     *                 {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
     *                 {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
     *                 {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
     *                 {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
     *                 {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
     *                 {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
     *         };
     * @param board
     * @return
     */


    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> nowRow = new HashSet<>();
        HashSet<Character> nowCol = new HashSet<>();
        HashSet<Character> nowLattice = new HashSet<>();
        //这个循环表示判断9次，也就是9行，9列，9个方格
        for (int i = 0; i < board.length; i++) {
            nowCol.clear();
            nowRow.clear();
            nowLattice.clear();
            int latticeLocationRow = i / 3;
            int latticeLocationCol = i % 3;
            for (int j = 0; j < board[i].length; j++) {
                //判断行
                if (board[i][j] != '.' && !nowRow.add(board[i][j])) return false;
                //判断列
                if (board[j][i] != '.' && !nowCol.add(board[j][i])) return false;
                //判断方格
                int latticeRow = j / 3;
                int latticeCol = j % 3;
                if (board[latticeLocationRow * 3 + latticeRow][latticeLocationCol * 3 + latticeCol] != '.'
                        && !nowLattice.add(board[latticeLocationRow * 3 + latticeRow][latticeLocationCol * 3 + latticeCol]))
                    return false;
            }
        }
        return true;
    }
}
