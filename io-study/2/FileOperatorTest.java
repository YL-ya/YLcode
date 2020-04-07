package lesson2;

import org.junit.Test;

import java.io.*;

public class FileOperatorTest {
    @Test//1：读取文件的操作
    public void testRead1() throws IOException {
        // 字节流转换为字符流，需要使用字节字符转换流
        // 转换流可以设置编码：java文件的编码格式(自己还有输出的格式UTF-8)、文件编码(依赖文件)格式
        // InputStreamReader：输入的字节字符转换流，或OutputStreamWriter：输出的字节字符转换流

        //1：这是我创建了一个文件的输入流：目前是一个二进制(字节)流
        FileInputStream fis = new FileInputStream(
                new File("E:\\20191218dataStructure\\io-study\\res\\info.txt"));//反斜杠是进行转义的

        //2：进行文件读取：转成(字符流)：可以设置一个转换流的方法进行转换
        //BufferedReader：缓冲流
        BufferedReader br = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
        //2.1：字符流的按行读取
        /*String line;
        while ((line = br.readLine()) != null){//当读取到为null的时候，读取(IO流已经结束)停止；读取到String定义的line中
            System.out.println(line);
        }*/

        /*因为流的操作只能执行一次，所以2.1和2.2只能存在*/

        //abcdefg不用设置偏移量
        //2.2：字符流按字符数组读取
        char[] chars = new char[1024];
        int len;
        /*while (len=fis.read(chars,0,1024)!=-1) {
        String str = new String(chars, 0, len);
        System.out.println(str);
        }*/
        while((len = br.read(chars)) != -1){//读入的时候，将数组的整个进行读入，返回的是实际长度
            String str = new String(chars, 0, len);
            System.out.println(str);
        }
    }

    @Test
    public void testRead2() throws IOException {
        FileInputStream fis = new FileInputStream(
                new File("E:\\20191218dataStructure\\io-study\\res\\info.txt"));
        //3：按字节流读取
        byte[] bytes = new byte[1024];
        int len;
        /*while (len=fis.read(bytes,0,1024)!=-1) {
         String str = new String(bytes, 0, len);
            System.out.println(str);
        }//这种写法当不足1024个字节的时候，会将空的部分打印出来*/
        while((len = fis.read(bytes)) != -1){
            String str = new String(bytes, 0, len);
            System.out.println(str);
        }
    }

    @Test
    //2：写文件的操作：
    public void testWrite1() throws IOException {
        FileOutputStream fos = new FileOutputStream(
                new File("E:\\20191218dataStructure\\io-study\\res\\info.txt"));

        //2：按字符流输出：将字节流转成字符流进行输出
        BufferedWriter br = new BufferedWriter(new OutputStreamWriter(fos, "UTF-8"));

        //3：使用缓冲流，输出的时候，要进行flush刷新缓冲区，否则不会真实输出数据到目的设备
        br.write("1：的说法就是打开附件\n");//write写数据到系统内存缓冲区
        br.write("2:dskfjdsjf\n");
        br.write("3:四道口附近的收费");

        br.flush();//缓冲区刷新，发送数据到目的设备
    }

    @Test
    //3：复制文件的操作：缓冲字节流的操作：
    /*思路：
    * 1：定义输入流：
    * 2：定义缓存的部分，将输入流的是从文件中输入
    * 3：定义输出流：
    * 4：定义缓存的一个输出流，输出到文件中去
    * 5：按字节流读取*/
    public void copyFile() throws Exception {
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        try {
            //作业：复制本地文件到另一个地方
            fis = new FileInputStream(
                    new File("E:\\20191218dataStructure\\io-study\\res\\info.txt"));
            bis = new BufferedInputStream(fis);
            fos = new FileOutputStream(
                    new File("E:\\20191218dataStructure\\io-study\\res\\info1.txt"));
            bos = new BufferedOutputStream(fos);//定义一个缓存的输出流，输出到文件中去
            byte[] bytes = new byte[1024 * 8];//每一次读取的单位变大
            int len;
            while ((len = fis.read(bytes)) != -1) {
                bos.write(bytes);
                bos.flush();
            }
        }finally {// IO流的操作完成之后，一定要释放资源，顺序是根据依赖关系B依赖A，反向释放（先释放B）
            if(bis != null)//类似于jdbc
                bis.close();
            if(fis != null)
                fis.close();
            if(bos != null)
                bos.close();
            if(fos != null)
                fos.close();
        }
    }
}
