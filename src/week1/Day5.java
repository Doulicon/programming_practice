package week1;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fengyongquan
 * @description io复习
 * @date 2020/8/28
 */
public class Day5 {

    public static void main(String[] args) throws IOException {
        testFileInput();
    }
    /**读取文本，获取每个字符的个数
     * 原理：创建字符流
     * 创建集合
     * 创建文件，用流读取文件
     * 遍历字符，将字符作为key，value作为出现个数
     * 遍历后放到map中
     * */
    public static void test() throws IOException {
        FileReader fr = null;
        BufferedWriter bufferedWriter = null;
        //创建集合
        Map<Character,Integer> map = new HashMap<>();

        try {
            fr = new FileReader(new File("hello.txt"));
            //遍历，读操作
            int len;
            while ((len = fr.read()) != -1) {
                char c = (char) len;

                if (map.get(c) == null) {
                    map.put(c, 1);
                } else {
                    map.put(c, map.get(c) + 1);
                }
            }
            //遍历每一个字符
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(fr!=null){
                fr.close();
            }
        }
        //把map里的数据放到map里
        //迭代
        //switch判断输出
        //每次完成就换行
    }

    //图片解密操作，最好有封装操作
    //异或操作，两数转为二进制，从高位开始比较,相同为0 不同为1
    public static void test2() throws IOException {
        String path = "C:\\Users\\temp\\Desktop\\我的文档\\图片\\new.jpg";
        String path2 = "C:\\Users\\temp\\Desktop\\我的文档\\图片\\new2.jpg";
        FileInputStream fileInputStream = new FileInputStream(new File(path));
        FileOutputStream fileOutputStream = new FileOutputStream(new File(path2));
        byte[] buffer = new byte[20];
        int len;
        try {
            while ((len = fileInputStream.read(buffer)) != -1){
                for(int i= 0; i<len; i++){
                    buffer[i] = (byte)(buffer[i]^5);
                }
                fileOutputStream.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileInputStream!=null){
                fileInputStream.close();
            }
            if(fileInputStream!=null){
                fileInputStream.close();
            }
        }
    }

    //图片加密操作
    public static void test1() throws IOException {
        String path = "C:\\Users\\temp\\Desktop\\我的文档\\图片\\0df750b8aac5187c68404307087123a.jpg";
        String path2 = "C:\\Users\\temp\\Desktop\\我的文档\\图片\\new.jpg";
        FileInputStream fileInputStream = new FileInputStream(new File(path));
        FileOutputStream fileOutputStream = new FileOutputStream(new File(path2));

        byte[] buffer = new byte[20];
        int len;
        try {
            while ((len = fileInputStream.read(buffer)) != -1){

                for(int i= 0; i<len; i++){
                    buffer[i] = (byte)(buffer[i]^5);

                }
                fileOutputStream.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileInputStream!=null){
                fileInputStream.close();
            }
            if(fileInputStream!=null){
                fileInputStream.close();
            }
        }

    }

    //缓冲流，处理流之一，装饰器模式，在已有的流的基础上，在加上处理流
    //效率较高，实际开发中会使用
    public  static void testBufferReader() throws IOException {
        //创建流对象
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("hello.txt")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("newHello.txt")));
        //读取流对象
        char [] cbuf = new char[1024];
        int len;
        try {
            while ((len = bufferedReader.read(cbuf))!=-1){
                bufferedWriter.write(cbuf,0,len);
                bufferedWriter.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {

                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bufferedReader!=null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }

        //字节流
    public static void testFileInput() throws  IOException{
        //创文件
        File file = new File("hello.txt");
        //创对象
        FileInputStream fileInputStream = new FileInputStream(file);

        //读数据
        byte [] buffer = new byte[10];
        int len;
        //
        while (( len = fileInputStream.read(buffer))!=-1){
            String str = new String(buffer,0,len);
            //每次读10次打印
            //中文会乱码，最好用字符流来用
            System.out.println(str);
        }
    }

    //字符流写入
    public static void writeFile() throws IOException {
        //不存在：创建
        //存在：直接覆盖（有追加的构造方法）
        String path = "hello.txt";
        File file = new File(path);
        FileWriter fw = new FileWriter(file,true);
        fw.write("加油，，激发立刻就发生fgasdfd");
        fw.write("fasfsadf ");
        fw.close();
    }

    //字符流结合使用
    public static void readWriter() throws IOException{
        File file1 = new File("hello.txt");
        File file2 = new File("hell0new.txt");

        //创建流对象
        FileWriter fw = new FileWriter(file2);
        FileReader fr = new FileReader(file1);
        char[] cbuf = new char[5];
        int len;
        try {
            while ((len = fr.read(cbuf))!=-1){

                //写入操作
                fw.write(cbuf,0,len);

            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (fw!=null){
                try {
                    fw.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
                if(fr != null){
                        try {
                            fr.close();
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                }
        }
    }
    //字节流读入
    public void readFile() throws IOException {
        String path = "/d:";
        //创建文件对象
        File file = new File(path);
        //流对象实例化
        FileReader fis = new FileReader(file);
        //捕捉异常
        //读操作,这个太慢,用到了read
        int data ;
        try{
            //每次读5个
            char  [] cbuf = new char[5];
            int len;
            //@Range(from = -1, to = Integer.MAX_VALUE)
            while (( len = fis.read(cbuf))!= -1){

                //错误写法
//                for(int 1=0;i<cbuf.length;i++){
//                    System.out.println(cbuf[i]);
//
//                }

                //正确写法
                for(int i = 0 ;i<len ;i++){
                    System.out.println(cbuf[i]);
                }
            }
            //方式二
            String str = new String(cbuf,0,len);
            //太慢
//            while( (data = fis.read()) !=-1){
//
//                System.out.println(data);
//
//            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(fis != null){
                try {
                    fis.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
