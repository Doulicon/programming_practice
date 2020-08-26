package week1;

/**
 * @author fengyongquan
 * @description 快速排序
 * @date 2020/8/26
 */
public class Day3 {

    /**
     *     挖坑填数代码
     *     不写死原因，因为左右两边的下标会变
     */
    static int AdjustArray(int[] s, int l, int r) {
        //标记左右两边数，准备挖坑
        int i = l, j = r;
        //第一个坑，基准值（分界值）
        int x = s[l];

        while (i < j) {
            //从右边开始向左边移动，直到找到大于基准值的值
            while (i < j && s[j] >= x) {
                j--;
            }
            //找到后将那个小于基准值的数即s[j]放到刚挖好的坑上s[i]
            if (i < j) {
                //填上去后，s[j]就成了一个新的坑位
                s[i] = s[j];
                i++;
            }
            //因为新的坑位在左边，所以从左边检索找到小于基准值的值
            while (i < j && s[i] < x) {
                i++;
            }
            if (i < j) {
                s[j] = s[i];
                j--;
            }
        }
        //退出时i = j
        s[i] = x;
        return i;
        //完成一次分值，然后用递归继续分治
    }

    //递归调用
    static void quick_sort(int[] s, int l, int r){

        if(l<r){
            int i = AdjustArray(s,l,r);
            quick_sort(s,l,i-1);
            quick_sort(s,i+1,r);
        }
    }

        public static void main (String[]args){
            int[] arrays = {2, 3, 1, 4, 3, 5, 1, 6, 1, 2, 3, 7, 2, 3};

            quick_sort(arrays, 0, arrays.length - 1);

            for (int i = 0; i < arrays.length; i++) {
                System.out.println(arrays[i]);
            }
        }

}
