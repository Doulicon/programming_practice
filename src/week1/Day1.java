package week1;

/**
 * @author fengyongquan
 * @description 冒泡排序和选择排序
 * 区别，选择排序是全部对比，冒泡是相邻对比
 * @date 2020/8/24
 */
public class Day1 {

    public static void main(String[] args) {
        int[] arrays = {2, 3, 1, 4, 3, 5, 1, 6, 1, 2, 3, 7, 2, 3};
        //selectSort(arrays);
        bubbleSort(arrays);

        for(int i=0;i<arrays.length;i++){
            System.out.println(arrays[i]);
        }
    }


    /**
     * 每次和后面的元素进行两两对比，大的就往后走，每次内循环大的数就会跑到后面了
     * @param arr
     */
    public static void bubbleSort(int [] arr){

        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                //对比，如果大，交换后面元素
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }


    /**
     * 和全部的数字进行比较大小，标记比他大（小）的数，内循环结束时交换位置
     * @param arr
     */
    public static void selectSort(int [] arr){
        //初始角标
        int temp = 0;
        for(int i = 0;i<arr.length-1;i++){
            int index = 0;
            for(int j=0; j<arr.length-i ;j++){
                if(arr[j]>arr[index]){
                    index = j;
                    //交换位置
                }
            }
            temp = arr[index];
            arr[index] = arr[arr.length-i-1];
            arr[arr.length-i-1] = temp;
        }

    }

}
