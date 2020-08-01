import java.util.HashMap;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/5/9 2:19 下午
 */
/*
36. 有效的数独
判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。

数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。

上图是一个部分填充的有效的数独。

数独部分空格内已填入了数字，空白格用 '.' 表示。

示例 1:

输入:
[
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
输出: true
示例 2:

输入:
[
  ["8","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
输出: false
解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
     但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
说明:

一个有效的数独（部分已被填充）不一定是可解的。
只需要根据以上规则，验证已经填入的数字是否有效即可。
给定数独序列只包含数字 1-9 和字符 '.' 。
给定数独永远是 9x9 形式的。

https://leetcode-cn.com/problems/valid-sudoku/
 */
public class validSudoku36 {
    //将多个判断化解为一个判断 ，但是对于转数组的操作过于麻烦
    public static boolean isValidSudoku(char[][] board) {
        char[][] board_reverse = new char[9][9];
        StringBuilder[] strs = new StringBuilder[9];
        for (int i = 0 ;i<9;i++) strs[i] = new StringBuilder();
        for (int i = 0 ; i<9 ; i++){
            for (int j =0 ;j<9 ;j++){
                board_reverse[j][i] = board[i][j];
                strs[i/3+j/3*3].append(board[i][j]);
            }
        }
        for (int i = 0; i<9 ;i++){
            if (!isValidCAL(board[i])||!isValidCAL(board_reverse[i])||!isValidCAL(strs[i].toString().toCharArray()))
                return false;
        }

        return true;
    }
    public static Boolean isValidCAL(char[] line){
        int num = line.length,i=0;
        HashMap<Character,Integer> map  = new HashMap<>();
        while (i<num){
            if (Character.isDigit(line[i])){
                if (map.containsKey(line[i])) return false;
                map.put(line[i],1);
            }
            i++;
        }
        return true;

    }

    //官方用的hashmap，但采用数组更方便,直接用数组判断是否有这个数
    public static boolean isValidSudoku_leetcode(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] col = new int[9][9];
        int[][] sbox = new int[9][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j]!='.'){
                    int num = board[i][j] - '1';
                    int index_box = (i/3)*3+j/3;
                    if (rows[i][num]==1) { return false;}
                    else { rows[i][num]=1; }
                    if (col[j][num]==1) { return false;}
                    else { col[j][num]=1; }
                    if (sbox[index_box][num]==1)  { return false;}
                    else { sbox[index_box][num]=1; }
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        char[][] chars = {
            {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(isValidSudoku(chars));
        //System.out.println(isValidCAL(new char[]{'5','3','.','.','7','.','.','.','.'}));

    }
}
