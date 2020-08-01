/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/5/12 3:04 下午
 */
/*
48. 旋转图像
给定一个 n × n 的二维矩阵表示一个图像。
将图像顺时针旋转 90 度。

说明：
你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。

示例 1:
给定 matrix =
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

原地旋转输入矩阵，使其变为:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
https://leetcode-cn.com/problems/rotate-image/
 */

public class rotateImage {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int temp;
        //先折叠
        for (int i = 0;i<n-1;i++){
            for (int j = 0;j<n-1-i;j++){
                //swap(matrix[i][j],matrix[n-1-j][n-1-i]);
                temp = matrix[n-1-j][n-1-i];
                matrix[n-1-j][n-1-i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        //再翻转
        for (int i = 0; i<n/2; i++){
            for (int j = 0; j<n; j++){
                //swap(matrix[i][j],matrix[n-1-i][j]);
                temp = matrix[n-1-i][j];
                matrix[n-1-i][j] = matrix[i][j];
                matrix[i][j] = temp;

            }
        }
    }
    //java是个值传递，就算你交换了这两个值 原来的也不交换
//    public static void swap(int a,int b){
//        int temp = b;
//        b = a;
//        a = temp;
//    }




}
