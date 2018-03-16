import java.io.*;

//用char类型数组存放字节
public class writerReaderDemo {
    public static void main(String[] args) {

        try {
        //读取文件内容
            FileInputStream fileInputStream=new FileInputStream("ann.txt");
            InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
            
       //将内容写入annn.txt中
            FileOutputStream fileOutputStream=new FileOutputStream("annn.txt");
            OutputStreamWriter outputStreamWriter=new OutputStreamWriter(fileOutputStream);

            int n=0;
            //读取的是文本内容，将其存放在字节数组中，n存放的是实际存储的内容
            char[] chars=new char[10];
            while((n=inputStreamReader.read())!=-1)
            {
                System.out.print((char)n);
            }

            System.out.println();
           //读取的是字节，n存储实际读取的字节数
            char[] c=new char[10];
            while ((n=inputStreamReader.read(c))!=-1)
            {
                String s=new String(c);//将内容转换成字符串输出
                System.out.print(s);
                
            }

      //将读取的内容存入另一个文件中
            char[] cbuf=new char[10]；
            while ((n=inputStreamReader.read(cbuf))!=-1)
            {
                outputStreamWriter.write(cbuf,0,n);
                /*
                字符数组的长度为10，读取完毕的时候不能保证字符数组是满的
                如果读取完毕字符数组未满，可能会在后面多出内容，所以要传入实际长度
                n为数组实际长度
                */
            }

            outputStreamWriter.flush();
            fileInputStream.close();
            inputStreamReader.close();
            fileOutputStream.close();
            outputStreamWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
