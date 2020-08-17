package mainIdea.offer;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/8/14 5:08 下午
 */
public class GetNumberOfK {
    public static void main(String[] args) {
        System.out.println(GetNumberOfK(new int[]{1,2,3,3,3,3,5,6},3));
    }
    public static int GetNumberOfK(int [] array , int k) {
        int i = 0,j = array.length-1;
        while (i<=j){
            int mid = i + ((j-i)>>1);
            if (array[mid]>=k){
                j--;
            }else {
                i++;
            }
        }
        int start = i;
        i = 0; j = array.length-1;
        while (i<=j){
            int mid = i + ((j-i)>>1);
            if (array[mid]<=k){
                i++;
            }else {
                j--;
            }
        }
        int end = j;
        return end-start+1;
    }
}
