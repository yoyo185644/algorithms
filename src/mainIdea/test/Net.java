package mainIdea.test;

import java.util.Scanner;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/9/8 6:46 下午
 */
class Net {
    static boolean[][] num;//存放当前位置是否用过
    static char[][] board;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String word = in.nextLine();
        System.out.println(exist(board,word));
    }
    public static boolean exist(char[][] board, String word) {
        if(board==null||board.length==0||board[0].length==0){
            return false;
        }
        num=new boolean[board.length][board[0].length];
        if(word==null||word.length()==0)
            return true;
        if(dfs(board,word,0,0,0)){
            return true;
        }
        else{
            return false;
        }
    }
    //start为当前的字符串第几个字符，x为二维矩阵中当前位置的行坐标，y为列坐标
    public static boolean dfs(char[][] board,String word,int start,int x,int y){
        if(start==word.length()){//当所有字符串字符都有有效解则返回
            return true;
        }
        char temp=word.charAt(start);
        if(start==0){//start=0时要找到第一个字符的解
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[0].length;j++){
                    if(board[i][j]==temp){
                        num[i][j]=true;
                        if(dfs(board,word,start+1,i,j))
                            return true;
                        num[i][j]=false;
                    }
                }
            }
            return false;
        }
        else{
            if(y-1>=0){//左边
                if(board[x][y-1]==temp&&!num[x][y-1]){
                    num[x][y-1]=true;
                    if(dfs(board,word,start+1,x,y-1))
                        return true;
                    num[x][y-1]=false;
                }
            }
            if(x-1>=0){//上边
                if(board[x-1][y]==temp&&!num[x-1][y]){
                    num[x-1][y]=true;
                    if(dfs(board,word,start+1,x-1,y))
                        return true;
                    num[x-1][y]=false;
                }
            }
            if(y+1<board[0].length){//右边
                if(board[x][y+1]==temp&&!num[x][y+1]){
                    num[x][y+1]=true;
                    if(dfs(board,word,start+1,x,y+1))
                        return true;
                    num[x][y+1]=false;
                }
            }
            if(x+1<board.length){//下边
                if(board[x+1][y]==temp&&!num[x+1][y]){
                    num[x+1][y]=true;
                    if(dfs(board,word,start+1,x+1,y))
                        return true;
                    num[x+1][y]=false;
                }
            }
            return false;
        }

    }
}