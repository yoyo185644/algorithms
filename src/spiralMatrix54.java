import java.util.ArrayList;
import java.util.List;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/5/14 4:47 下午
 */
/*
54. 螺旋矩阵
给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
示例 1:
输入:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
输出: [1,2,3,6,9,8,7,4,5]

示例 2:
输入:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class spiralMatrix54 {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix==null||matrix.length==0) return list;
        int n = matrix.length,m=matrix[0].length;
        circleOrder(matrix,list,0,n-1,0,m-1);
        return list;
    }
    //递归
    public static void circleOrder(int[][] matrix,List<Integer> list,int row_begin,int row_end,int col_begin,int col_end){
        if (row_begin>row_end || col_begin>col_end) return ;
        for (int j = col_begin;j<=col_end;j++){
            list.add(matrix[row_begin][j]);
        }
        for (int i = row_begin+1 ;i <= row_end ;i++){
            list.add(matrix[i][col_end]);
        }
        if (row_end>row_begin){
            for (int j = col_end-1;j>=col_begin;j--){
                list.add(matrix[row_end][j]);
            }
        }
        if (col_end>col_begin){
            for (int i = row_end-1 ; i>row_begin ; i--){
                list.add(matrix[i][col_begin]);
            }
        }
        circleOrder(matrix,list,row_begin+1,row_end-1,col_begin+1,col_end-1);

    }

    //不使用递归 暗层模拟
    public List < Integer > spiralOrder_leetcode(int[][] matrix) {
        List ans = new ArrayList();
        if (matrix.length == 0)
            return ans;
        int r1 = 0, r2 = matrix.length - 1;
        int c1 = 0, c2 = matrix[0].length - 1;
        while (r1 <= r2 && c1 <= c2) {
            for (int c = c1; c <= c2; c++) ans.add(matrix[r1][c]);
            for (int r = r1 + 1; r <= r2; r++) ans.add(matrix[r][c2]);
            if (r1 < r2 && c1 < c2) {
                for (int c = c2 - 1; c > c1; c--) ans.add(matrix[r2][c]);
                for (int r = r2; r > r1; r--) ans.add(matrix[r][c1]);
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return ans;
    }



}
