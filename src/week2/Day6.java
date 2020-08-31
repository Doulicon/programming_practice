package week2;

/**
 * @author fengyongquan
 * @description //复盘快速排序
 * @date 2020/8/31
 */
public class Day6 {

    public static int AdjustArray(int l,int r,int []s){
        //标记左右两边，挖坑
        int i = l,j = r;
        //找基准值，取第一个数为基准值
        int x = s[i];

        //左右两边靠拢
        while(i<j){
            //从右边开始，向左移动，直到找到比基准值小的元素
            while(i<j&&s[i]>=x){
                j--;
            }
            if(i<j){
                s[i] = s[j];
                i++;
            }
            //找到后就填坑，s[j]就会形成一个坑位
            //因为是右边形成坑位，所以从左边检索找小于基准值的值
            while(i<j&&s[i]<x){
                i++;
            }
            if(i<j){
                s[j] = s[i];
                j--;
            }

        }
        //退出是 i等于j x填回坑中
        s[i] = x;
        return i;
    }

    //分治
    void quick_sort(int s[],int l,int r){

        if(l<r){
            int i = AdjustArray(l,r,s);
            quick_sort(s,l,i-1);
            quick_sort(s,i+1,r);
        }
    }

}
