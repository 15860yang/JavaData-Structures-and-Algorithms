/**
 * 以之字形打印矩阵
 *
 * 未完成
 */
public class Q2 {
    private static void printMatrixZigZag(int[][] matrix){
        int maxRaw = matrix[0].length;
        int maxCol = matrix.length;
        int raw = 0;
        int col = 0;

        int aRaw = 0;
        int aCol = 0;
        int bRaw = 0;
        int bCol = 0;
        while (raw < maxRaw + maxCol && col < maxRaw + maxCol){
            if(raw < maxRaw && col < maxCol){
                aRaw = raw;
                aCol = col;
                bRaw = col;
                bCol = raw;
            }else {
                aRaw = raw;
                aCol = col;
                bRaw = col;
                bCol = raw;
            }


            raw++;
            col++;
        }
    }
}
