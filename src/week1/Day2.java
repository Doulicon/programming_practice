package week1;

/**
 * @author fengyongquan
 * @description 快速排序和插入排序
 * @date 2020/8/25
 */
public class Day2 {

    public static void main(String[] args) {
        int[] arrays = {2, 3, 1, 4, 3, 5, 1, 6, 1, 2, 3, 7, 2, 3};

        insertSort(arrays);

        for(int i=0;i<arrays.length;i++){
            System.out.println(arrays[i]);
        }
    }


    //向一个已经排序好的数据进行插入操作
    public static void insertSort(int [] arr){

        //因为是从一开始，所以arr.length没有-1
        for(int i=1;i<arr.length;i++){
            //从第二个元素开始比较，比较上一个元素
            int preIndex = i-1;
            //把当前元素拿出来
            int temp = arr[i];
            while (preIndex>=0&&temp<arr[preIndex]){
                System.out.println(arr[1]);
                //后面等于前面
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            //循环结束时吧之前拿出来的放回去
            arr[preIndex+1] = temp;
        }
    }

}
