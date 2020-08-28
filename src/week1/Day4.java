package week1;

/**
 * @author fengyongquan
 * @description 希尔排序
 * @date 2020/8/27
 */
public class Day4 {

    public static void main(String[] args) {
        int[] arrays = {2, 3, 1, 4, 3, 5, 1, 6, 1, 2, 3, 7, 2, 3};

        shellSort(arrays);

        for(int i=0;i<arrays.length;i++){
            System.out.println(arrays[i]);
        }
    }

    public static void shellSort(int [] arrays){
        //分组间隔
        //int step = arrays.length/2;
        //每次循环，间隔减半，直到为1
        for(int step = arrays.length/2;step>0;step/=2){
            //插入排序，默认前面是已经排序好的 ,从增量开始，因为要循环到末尾结束，所以i=i<arrays.length
            for(int i = step;i<arrays.length;i++){
                //标记开始量
                int j = i;
                //标记对比元素
                int temp = arrays[j];

                //对比，小就插入
                while (j-step>=0&&temp<arrays[j-step]){
                    //插入，后面等于前面的，记得加增量，并不是不同的插入排序的1 step
                    arrays[j] = arrays[j-step];
                    j = j-step;
                }
                //直到找到那个坑，插入那个坑
                arrays[j] = temp;
            }

        }

    }



}
