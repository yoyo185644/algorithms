package mainIdea.datasturcter.arrays;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/8/17 10:55 上午
 */
//求前n个树的和
public class Sum {
    //用状态树解决
    public static  int[] arr = new int[]{1,2,3,4,5};
    public static int[] c = new int[6];
    public static void main(String[] args) {

        for (int i =1;i<=5;i++){
            add(i,arr[i-1]);
        }
        int sum = getSum(3);
        System.out.println(sum);
    }
    public static int lowbit(int x){
        return x&(-x);
    }
    public static void add(int i ,int data){
        while (i<=arr.length){
            c[i] += data;
            i+=lowbit(i);
        }
    }
    //如果是二维数组
    public static int[][] arr2 = new int[8][8];
    public static int[][] c2 = new int[8][8];
    public static void add2(int i, int j,int data){
        for(int x = i; x< arr2.length; x += lowbit(x))
            for(int y = j; y <arr2[i].length; y += lowbit(y)){
                c2[x][y] += data;

            }
    }
    public static int getSum2(int i, int j){
        int result = 0;
        for(int x = i; x > 0; x -= lowbit(x)) {
            for(int y = j; y > 0; y -= lowbit(y)) {
                result += c2[x][y];
            }
        }
        return result;
    }
    public static int getSum(int n){
        int sum = 0;
        while (n>0){
            sum += c[n];
            n -= lowbit(n);
        }
        return sum;
    }
}
