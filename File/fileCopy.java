//copy功能

import java.io.*;

public class Filecopy {
    public static void main(String[] args) {
    
    //文件copy，利用文件输入流，文件输出流，将内容读取存储到byte数组中，再通过FileOutputStream将byte数组中的内容写入到新的文件中
        try {
        /*
        FileOutputStream fileOutputStream=new FileOutputStream("ann2.txt");
        如果没有在当前路径中找到ann2.txt文件，则新生成改文件，并将内容写入其中，实现copy
        */
            FileInputStream fileInputStream=new FileInputStream("ann.txt");
            FileOutputStream fileOutputStream=new FileOutputStream("ann2.txt");
            byte[] b=new byte[1024*1024];
            int n=0;
            
            //FileInputStream.read()方法，返回值为int类型，如果返回值为-1，则已经读到文本末尾
         
            while((n=fileInputStream.read(b))!=-1)
            {
                fileOutputStream.write(b);
            }
//关闭输入输出流，释放资源
            fileInputStream.close();
            fileOutputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//通过缓冲输入流和缓冲输出流实现copy，缓冲流可以提高文本的读写速度
        try {
            FileInputStream fileInputStream2=new FileInputStream("ann.txt");
            BufferedInputStream bufferedInputStream=new BufferedInputStream(fileInputStream2);
            FileOutputStream fileOutputStream2=new FileOutputStream("ann3.txt");
            BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(fileOutputStream2);

            byte[] bytes=new byte[1024*1024];
            int n=0;
            while((n=bufferedInputStream.read(bytes))!=-1)
            {
                bufferedOutputStream.write(bytes);
            }

            fileInputStream2.close();
            fileOutputStream2.close();
            bufferedInputStream.close();
            bufferedOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
